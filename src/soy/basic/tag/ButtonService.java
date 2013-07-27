package soy.basic.tag;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

public class ButtonService extends Component {
	private String functionId;
	private ValueStack valueStack;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public ButtonService(ValueStack valueStack, HttpServletRequest request,
			HttpServletResponse response) {
		super(valueStack);
		this.valueStack = valueStack;
		this.request = request;
		this.response = response;
	}

	@Override
	public boolean start(Writer writer) {
		try {
			writer.write("我就是标签测死里面输出的:" + getFunctionId());
			System.out.println("biaoqian");
			System.out.println(getValueStack().getRoot());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.start(writer);
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
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

}
