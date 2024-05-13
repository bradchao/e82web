package tw.brad.tutor;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/myserver")
public class MyServer {
	private static HashSet<Session> sessions = null;
	private static HashMap<String, Session> users = null;
	
	public MyServer() {
		if (sessions == null) {
			sessions = new HashSet<>();
			users = new HashMap<String, Session>();
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
//		if (!users.containsValue(session)) {
//			users.put(session.getId(), session);
//		}
		//System.out.println(session.getRequest);
		
		session.setMaxIdleTimeout(60*60*1000);
		
		if (sessions.add(session)) {
			users.put(session.getId(), session);
			System.out.println("new session");
		}
		System.out.println("Count:" + sessions.size());
	}
	
	@OnMessage
	public void onMessage(String mesg, Session fromSession) {
		System.out.println(mesg);
		for (Session session : sessions) {
			try {
				session.getBasicRemote().sendText(mesg);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("onClose");
		users.remove(session.getId());
		sessions.remove(session);
	}
	
	@OnError
	public void onError(Session session, Throwable tt) {
		System.out.println("onError");
	}
	
	
	
}
