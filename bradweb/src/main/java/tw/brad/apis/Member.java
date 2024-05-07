package tw.brad.apis;

public class Member {
	private int id;
	private String account, passwd, realname;
	
	public void setId(int id) {
		this.id = id;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getId() {
		return id;
	}
	public String getAccount() {
		return account;
	}
	
	
	
}
