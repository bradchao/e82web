package tw.brad.apis;

import javax.websocket.Session;

public class WSClient {
	private Session session;
	private boolean isClient1;
	
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public boolean isClient1() {
		return isClient1;
	}
	public void setClient1(boolean isClient1) {
		this.isClient1 = isClient1;
	}
	
	
}
