package com.gifisan.nio.component;

import java.io.IOException;

import com.gifisan.nio.component.protocol.DatagramPacket;

public interface DatagramPacketAcceptor {
	
	public abstract void accept(UDPEndPoint endPoint,DatagramPacket packet) throws IOException;
}
