package soy.util;

import java.io.InputStream;
import java.util.Properties;


public class PropsParser {
	
	private static Properties props;
	
	// page size key
	public static final String PAGESIZE_KEY = "PAGE_SIZE";
	
	// page size
	private static int PAGESIZE;

	public static Properties getProperties() {
		if (props == null) {
			props = new Properties();
			try {
				//InputStream in = ClassLoader.getSystemResourceAsStream("config.properties");
				InputStream in =  PropsParser.class.getResourceAsStream("/config.properties");
				props.load(in);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return props;
	}
	
	// pageSize
	public static int getPageSize(){
		if(PAGESIZE ==0){
			try {
				PAGESIZE = Integer.parseInt(getProperties().getProperty(PAGESIZE_KEY));
			} catch (Exception e) {
				PAGESIZE = 10;
			}
		}
		return PAGESIZE;
	}
}
