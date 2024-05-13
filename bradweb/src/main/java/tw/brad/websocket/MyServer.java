package tw.brad.websocket;

import java.util.HashMap;
import java.util.HashSet;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/myserver")
public class MyServer {
	private static HashSet<Session> sessions;
	private static HashMap<String, Session> users;
	
	public MyServer() {
		sessions = new HashSet<>();
		users = new HashMap<String, Session>();
	}
	
	@OnOpen
	public void onOpen(Session session) {
//		if (!users.containsValue(session)) {
//			users.put(session.getId(), session);
//		}
		//System.out.println(session.getBasicRemote().);
		if (sessions.add(session)) {
			users.put(session.getId(), session);
		}
		System.out.println("Count:" + sessions.size());
	}
	
	@OnMessage
	public void onMessage(String mesg, Session session) {
		System.out.println(mesg);
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("onClose");
		users.remove(session.getId());
		sessions.remove(session);
	}
	
	@OnError
	public void onError(Session session) {
		System.out.println("onError");
	}
	
	
	
}
