package com.github.jsf.primefaces.example.configs;

import javax.faces.event.PhaseId;
import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.config.Direction;
import org.ocpsoft.rewrite.el.El;
import org.ocpsoft.rewrite.faces.config.PhaseBinding;
import org.ocpsoft.rewrite.servlet.config.DispatchType;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.Path;
import org.ocpsoft.rewrite.servlet.config.Redirect;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

@RewriteConfiguration
public class RewriteConfigurationProvider extends HttpConfigurationProvider {

	@Override
	public Configuration getConfiguration(ServletContext context) {
		return ConfigurationBuilder.begin().addRule().when(Path.matches("/")).perform(Redirect.permanent("/home.xhtml"))
				.addRule(Join.path("/mi.html").to("/home.xhtml"))

				.addRule(Join.path("/{message}/example.html").to("/home.xhtml"))
				.when(Direction.isInbound().and(DispatchType.isRequest())
						.andNot(Path.matches("{*}javax.faces.resource{*}")))
				.where("message")
				.bindsTo(PhaseBinding.to(El.property("exampleJSFBean.message")).after(PhaseId.RESTORE_VIEW));
	}

	@Override
	public int priority() {
		return 0;
	}
}