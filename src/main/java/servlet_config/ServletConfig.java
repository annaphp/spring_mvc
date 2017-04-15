package servlet_config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import core.CoreConfiguration;
import web.WebConfiguration;

public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{CoreConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	

}
