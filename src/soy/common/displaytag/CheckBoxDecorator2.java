/*
 * Created on 2005-9-27
 *
 \*  To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package soy.common.displaytag;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

/**
 * @author Administrator
 * 
 \*  To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class CheckBoxDecorator2 implements DisplaytagColumnDecorator {

	/**
	 * transform the given object into a String representation. The object is
	 * supposed to be a date.
	 * 
	 * @param columnValue
	 *            Object
	 * @return String
	 */
	public Object decorate(Object columnValue, PageContext pageContext,
			MediaTypeEnum media) throws DecoratorException {
		if (columnValue == null) {
			return "";
		}
		String id = columnValue.toString();
		StringBuffer sb = new StringBuffer();
		sb.append("<input type=\"checkbox\" name=\"cbId2\" class=\"checkbox\" ");
		sb.append(" value=\"" + id
				+ "\" onClick=\"changeCheckBox(cbId2, cbAll)\">");
		return sb.toString();
	}
}
