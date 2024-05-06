package tw.brad.apis;

public class MyModel {
	private int x, y;
	public MyModel(String x, String y) {
		try {
			this.x = Integer.parseInt(x);
			this.y = Integer.parseInt(y);
		}catch(Exception e) {
		}
	}
	public String plus() {
		return x + y + ""; 
	}
}
