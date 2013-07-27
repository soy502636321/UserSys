package soy.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class StringUtil {
	
	public static boolean isNull(String value) {
		return (null == value || value.trim().length() == 0);
	}

}
