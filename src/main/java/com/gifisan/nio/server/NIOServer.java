package com.gifisan.nio.server;

import java.nio.charset.Charset;
import java.util.Set;

import com.gifisan.nio.AbstractLifeCycle;
import com.gifisan.nio.common.LifeCycleUtil;
import com.gifisan.nio.common.SharedBundle;
import com.gifisan.nio.component.Attributes;
import com.gifisan.nio.component.AttributesImpl;
import com.gifisan.nio.component.Connector;

public final class NIOServer extends AbstractLifeCycle implements Attributes {

//	private Logger			logger		= LoggerFactory.getLogger(NIOServer.class);
	private Attributes		attributes	= new AttributesImpl();
	private NIOConnector	connector		= null;
	private ServerContext	context		= null;
	
	public NIOServer() {
		this.addLifeCycleListener(new NIOServerListener());
	}

	protected void doStart() throws Exception {
		
//		logger.info("          [NIOServer] ======================================= 服务开始启动 =======================================");

		SharedBundle bundle = SharedBundle.instance();
		
		int serverPort = bundle.getIntegerProperty("SERVER.PORT");

		if (serverPort == 0) {
			throw new Exception("未设置服务端口或端口为0");
		}
		
		String encoding = bundle.getProperty("SERVER.ENCODING", "GBK");
		
		this.context = new ServerContextImpl(this);
		this.context.setServerPort(serverPort);
		this.context.setEncoding(Charset.forName(encoding));
		this.context.setServerCoreSize(bundle.getIntegerProperty("SERVER.CORE_SIZE",4));
		
		this.connector = new NIOConnector(context,serverPort);
		
		this.context.start();
		this.connector.start();
	}

	protected void doStop() throws Exception {
		LifeCycleUtil.stop(connector);
		LifeCycleUtil.stop(context);
	}

	protected Connector getConnector() {
		return connector;
	}

	public Object removeAttribute(String key) {
		return this.attributes.removeAttribute(key);
	}

	public void setAttribute(String key, Object value) {
		this.attributes.setAttribute(key, value);
	}

	public Object getAttribute(String key) {
		return this.attributes.getAttribute(key);
	}

	public Set<String> getAttributeNames() {
		return this.attributes.getAttributeNames();
	}

	public void clearAttributes() {
		this.attributes.clearAttributes();

	}

}
