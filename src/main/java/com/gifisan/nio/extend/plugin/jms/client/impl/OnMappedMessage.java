package com.gifisan.nio.extend.plugin.jms.client.impl;

import com.gifisan.nio.extend.plugin.jms.MapByteMessage;
import com.gifisan.nio.extend.plugin.jms.MapMessage;

public abstract class OnMappedMessage {
	
	public void onReceive(MapMessage message) {}
	public void onReceive(MapByteMessage message){}

}
