package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FontTagHandler extends SimpleTagSupport{
	
	private String fontColor;
	private String fontSize;
	
	public void doTag() throws IOException, JspException {
		
		JspWriter out=getJspContext().getOut();
		JspFragment body=getJspBody();
		
		StringBuffer sb=new StringBuffer();
		
		if(body!=null) {
			/*out.println("<p style='color:");
			out.println(fontColor);
			out.println("; font-size:");
			out.println(fontSize);
			out.println(";'>");*/
			sb.append("<p style='color:").append(fontColor).append("; font-size:").append(fontSize).append(";'>");
			out.println(sb.toString());
			body.invoke(null);
			out.println("</p>");
		}
		
		
		
		/*out.println("<p style='color:");
		out.println(fontColor);
		out.println("; font-size:");
		out.println(fontSize);
		out.println("px;'>");
		out.println("</p>");*/
		
	}
	
	public String getFontColor() {
		return fontColor;
	}
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}
	public String getFontSize() {
		return fontSize;
	}
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}
	
}
