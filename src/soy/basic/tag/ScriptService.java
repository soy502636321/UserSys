package soy.basic.tag;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

public class ScriptService extends Component {
	private ValueStack valueStack;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String functionName;
	private String action;
	private String function;

	public ScriptService(ValueStack valueStack, HttpServletRequest request,
			HttpServletResponse response) {
		super(valueStack);
		this.valueStack = valueStack;
		this.request = request;
		this.response = response;
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
	
	@Override
	public boolean start(Writer writer) {
		System.out.println("script");
		System.out.println(getValueStack().getRoot());
		System.out.println(getValueStack());
		return super.start(writer);
	}

}
