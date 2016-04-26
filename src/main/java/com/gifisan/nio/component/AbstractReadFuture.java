package com.gifisan.nio.component;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class AbstractReadFuture extends ReadFutureImpl implements IOReadFuture {

	protected EndPoint			endPoint		= null;
	protected Session			session		= null;
	protected ByteBuffer		textBuffer	= null;
	protected boolean 		hasStream 	= false;
	private boolean 			flushed 		= false;

	public AbstractReadFuture(ByteBuffer textBuffer, Session session, String serviceName) {
		super(serviceName);
		this.endPoint = ((AbstractSession)session).getEndPoint();
		this.session = session;
		this.textBuffer = textBuffer;
	}

	public EndPoint getEndPoint() {
		return endPoint;
	}

	public Session getSession() {
		return session;
	}

	public void catchException(IOException e) {
		if (this.handle == null) {
			return;
		}
		this.handle.handle(session, this, e);
	}

	public boolean hasOutputStream() {
		return hasStream;
	}

	public String getText() {
		if (text == null) {
			text = new String(textBuffer.array(),0,textBuffer.position());
		}
		return text;
	}

	public boolean flushed() {
		return flushed;
	}

	public void flush() {
		flushed = true;
	}
	
}