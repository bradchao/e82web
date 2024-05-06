package tw.brad.apis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

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
}
