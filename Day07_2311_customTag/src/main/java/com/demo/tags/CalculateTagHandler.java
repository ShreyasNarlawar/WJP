package com.demo.tags;

import java.io.IOException;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class CalculateTagHandler extends TagSupport {
	private int num1,num2;

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}
	
	public int doEndTag() {
		JspWriter out=pageContext.getOut();
		try {
			out.println("<br>this is calculate tag<br><br><br><br>");
			out.println("<br>attributes are:<br> Num1 ="+num1+" <br> Num2 ="+num2);
			out.println("<br> <b> Addition : </b>"+(num1+num2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}
