package tw.brad.tutor;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import tw.brad.apis.WSClient;

@ServerEndpoint("/mycenter")
public class MyCenter {
	private static HashSet<Session> sessions = null;
	private static LinkedList<WSClient> users;
	
	public MyCenter() {
		if (sessions == null) {
			sessions = new HashSet<>();
			users = new LinkedList<WSClient>();
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		session.setMaxIdleTimeout(60*60*1000);
		
		if (sessions.add(session)) {
			WSClient wsClient = new WSClient();
			wsClient.setSession(session);
			users.add(wsClient);
		}
	}
	
	@OnMessage
	public void onMessage(String mesg, Session fromSession) {
		
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("onClose");
		for (WSClient wsClient : users) {
			if (wsClient.getSession().equals(session)) {
				sessions.remove(session);
				users.remove(wsClient);
				break;
			}
		}
	}
	
	@OnError
	public void onError(Session session, Throwable tt) {
		System.out.println("onError");
	}
	
	
	
}
