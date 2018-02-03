package com.github.jsf.primefaces.example;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.Parameter;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "exampleRewriteJSFBean")
@ELBeanName(value = "exampleRewriteJSFBean")
@Join(path = "/{message}/rewrite", to = "/home.xhtml")
public class ExampleRewriteJSFBean {

	@Parameter("message")
	private String message = "default message";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}