package com.test;

import java.io.IOException;

import com.gifisan.nio.client.ClientSession;
import com.gifisan.nio.client.ClientTCPConnector;
import com.gifisan.nio.common.CloseUtil;
import com.gifisan.nio.common.ThreadUtil;
import com.gifisan.nio.server.RESMessage;
import com.likemessage.client.LMClient;

public class TestRegist {

	public static void main(String[] args) throws IOException {

		final ClientTCPConnector connector = ClientUtil.getClientConnector();

		connector.connect();

		ClientSession session = connector.getClientSession();

		LMClient client = new LMClient();

		RESMessage message = client.regist(session, "sh1", "sh");

		System.out.println(message);

		ThreadUtil.sleep(500);

		CloseUtil.close(connector);

	}
}