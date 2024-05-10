package tw.brad.apis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.SortedMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class BradUtils {
	public static String loadView(String view) throws Exception {
		String source = String.format(
			"C:\\Users\\User\\git\\repository2\\bradweb\\src\\main\\webapp\\views\\%s.html",view);
		File viewFile = new File(source);
		int len = (int)viewFile.length();
		byte[] buf = new byte[len];
		FileInputStream fin = new FileInputStream(viewFile);
		fin.read(buf);
		fin.close();
		
		return new String(buf);
	}
	
	public static String calc(String x, String y, String op) {
		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			StringBuffer sb = new StringBuffer();
			switch (op) {
				case "1": sb.append(intX + intY); break;
				case "2": sb.append(intX - intY); break;
				case "3": sb.append(intX * intY); break;
				case "4": 
					sb.append(intX / intY).append(" ...... ").append(intX % intY); 
					break;
			}
			return sb.toString();
			
		}catch(Exception e) {
			return "";
		}
	}
	
	public static int createScore() {
		return (int)(Math.random()*101);
	}
	
	public static LinkedList<HashMap<String, String>> parseTravel(String data){
		LinkedList<HashMap<String, String>> items = new LinkedList<HashMap<String,String>>();
		JSONArray root = new JSONArray(data);
		System.out.println("debug1:" + root.length());
		for (int i=0; i<root.length(); i++) {
			JSONObject row = root.getJSONObject(i);
			HashMap<String, String> item = new HashMap<String, String>();
			item.put("name", row.getString("Name"));
			item.put("city", row.getString("City"));
			item.put("town", row.getString("Town"));
			items.add(item);
			System.out.println(row.getString("Name"));
		}
		System.out.println(items.size());
		
		return items;
	}
	
	public static String Order2JSON(SortedMap[] rows) {
		JSONObject root = new JSONObject();
		if (rows.length >0) {
			root.put("orderId", rows[0].getOrDefault("OrderID", ""));
			root.put("customerId", rows[0].getOrDefault("CustomerID", ""));
			root.put("date", rows[0].getOrDefault("OrderDate", ""));
			
			JSONArray details = new JSONArray();
			for (int i=0; i<rows.length; i++) {
				SortedMap<String, String> row = rows[i];
				JSONObject detail = new JSONObject();
				detail.put("productId", row.getOrDefault("ProductID", ""));
				detail.put("productName", row.getOrDefault("ProductName", ""));
				detail.put("unitPrice", row.getOrDefault("UnitPrice", ""));
				detail.put("quantity", row.getOrDefault("Quantity", ""));
				details.put(detail);
			}
			
			root.put("details", details);
		}
		
		//System.out.println(root.toString());
		
		
		return root.toString();
	}
	
}
