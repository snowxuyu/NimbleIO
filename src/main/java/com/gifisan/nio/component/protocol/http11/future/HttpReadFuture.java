package com.gifisan.nio.component.protocol.http11.future;

import java.io.OutputStream;
import java.util.Map;

import com.gifisan.nio.component.protocol.future.ReadFuture;

public abstract interface HttpReadFuture extends ReadFuture {

	public abstract String getHeader(String name);

	public abstract String getHost();

	public abstract int getContentLength();

	/**
	 * <table summary="Examples of Returned Values">
	 * <tr align=left>
	 * <th>First line of HTTP request</th>
	 * <th>Returned Value</th>
	 * <tr>
	 * <td>POST /some/path.html HTTP/1.1
	 * <td>
	 * <td>/some/path.html
	 * <tr>
	 * <td>GET http://foo.bar/a.html HTTP/1.0
	 * <td>
	 * <td>/a.html
	 * <tr>
	 * <td>GET /xyz?a=b HTTP/1.1
	 * <td>
	 * <td>/xyz
	 * </table>
	 */
	public abstract String getRequestURI();

	public abstract String getMethod();

	public abstract String getVersion();

	public abstract String getBoundary();

	public abstract String getContentType();
	
	public abstract String getStatusDescription() ;

	public abstract void setStatusDescription(String statusDescription) ;

	public abstract Map<String, String> getRequestParams();
	
	public abstract Map<String, String> getHeaders();

	public abstract String getRequestParam(String key);

	public abstract void setReuestParam(String key,String value);
	
	public abstract void setRequestParams(Map<String, String> params);

	public abstract int getStatus();

	public abstract void setStatus(int status);

	public abstract void setOutputStream(OutputStream outputStream);
	
	public abstract String getCookie(String name);
	
	public abstract void addCookie(Cookie cookie);
	
	public abstract void setHeader(String name,String value);
	
	public abstract void updateWebSocketProtocol();
}
