package com.gifisan.nio.extend.plugin.rtp.server;

import com.gifisan.nio.common.ByteUtil;
import com.gifisan.nio.component.Session;
import com.gifisan.nio.component.UDPEndPoint;
import com.gifisan.nio.component.protocol.nio.future.NIOReadFuture;

public class RTPJoinRoomServlet extends RTPServlet {

	public static final String	SERVICE_NAME	= RTPJoinRoomServlet.class.getSimpleName();

	public void doAccept(Session session, NIOReadFuture future, RTPSessionAttachment attachment) throws Exception {

		RTPContext context = getRTPContext();

		Integer roomID = Integer.valueOf(future.getText());

		RTPRoomFactory roomFactory = context.getRTPRoomFactory();

		RTPRoom room = roomFactory.getRTPRoom(roomID);

		UDPEndPoint udpEndPoint = session.getUDPEndPoint();

		if (room == null || udpEndPoint == null) {

			future.write(ByteUtil.FALSE);

			session.flush(future);
			
			return;
		}

		if (room.join(udpEndPoint)) {
			
			future.write(ByteUtil.TRUE);
			
		} else {

			future.write(ByteUtil.FALSE);
		}

		session.flush(future);

	}

}
