package com.github.jsf.primefaces.example.beans;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.jsf.primefaces.example.services.JsfManagedService;
import com.github.jsf.primefaces.example.services.SpringManagedService;

/**
 * Created by jah on 2/3/16.
 */

@Named
@RequestScoped
public class JsfManagedBean extends AbstractManagedBean {

	private SpringManagedService sms;
	private JsfManagedService jms;

	@Inject
	public JsfManagedBean(SpringManagedService sms, JsfManagedService jms) {
		super("JSF", sms, jms);
	}

}