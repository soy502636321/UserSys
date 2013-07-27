package soy.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class SystemUtil {
	public static boolean isEmpty(Object o) {
		if (o == null)
			return true;
		if (o.getClass().isArray()) {
			return Array.getLength(o) == 0;
		} else if (o instanceof Map) {
			return ((Map) o).isEmpty();
		} else if (o instanceof Collection) {
			return ((Collection) o).isEmpty();
		}

		return false;
	}

	public static boolean isNull(byte[] array) {
		return (null == array || array.length == 0);
	}

	public static boolean isNull(Collection col) {
		return (null == col || col.isEmpty());
	}

	public static boolean isNull(Object[] array) {
		return (null == array || array.length == 0);
	}
	
	public static boolean isYes(Integer integer) {
		if (integer != null) {
			if (integer.intValue() == 1) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isNumber(String string) {
		try {
			Integer.valueOf(string);
			return true;
		} catch (NumberFormatException e) {
		}
		return false;
	}
}
