package com.github.jsf.primefaces.example.beans;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.jsf.primefaces.example.services.JsfManagedService;
import com.github.jsf.primefaces.example.services.SpringManagedService;

/**
 * Created by jah on 2/3/16.
 */

@Component
@RequestScoped
public class SpringManagedBean extends AbstractManagedBean {

	@Autowired
	public SpringManagedBean(SpringManagedService sms, JsfManagedService jms) {
		super("Spring", sms, jms);
	}

}