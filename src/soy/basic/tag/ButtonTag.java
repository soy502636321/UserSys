package soy.basic.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;

public class ButtonTag extends ComponentTagSupport {
	private String functionId;

	@Override
	public Component getBean(ValueStack valueStack, HttpServletRequest request,
			HttpServletResponse response) {
		return new ButtonService(valueStack, request, response);
	}

	@Override
	protected void populateParams() {
		ButtonService buttonService = (ButtonService) getComponent();
		buttonService.setFunctionId(getFunctionId());
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

}
