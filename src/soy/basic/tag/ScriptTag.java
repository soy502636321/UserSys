package soy.basic.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;

public class ScriptTag extends ComponentTagSupport {
	private ValueStack valueStack;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String functionName;
	private String action;
	private String function;

	@Override
	public Component getBean(ValueStack valueStack, HttpServletRequest request,
			HttpServletResponse response) {

		return new ScriptService(valueStack, request, response);
	}

	@Override
	protected void populateParams() {
		ScriptService scriptService = (ScriptService) getComponent();
		scriptService.setFunctionName(getFunctionName());
		scriptService.setAction(getAction());
		scriptService.setFunction(getFunction());
		ButtonTag buttonTag = (ButtonTag)findAncestorWithClass(this, ButtonTag.class);
		System.out.println(buttonTag);
		System.out.println(buttonTag.getFunctionId());
		super.populateParams();
	}

	public ValueStack getValueStack() {
		return valueStack;
	}

	public void setValueStack(ValueStack valueStack) {
		this.valueStack = valueStack;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

}
