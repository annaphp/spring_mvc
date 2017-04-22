package web;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
 * What is WEB-INF?
 * http://stackoverflow.com/questions/19786142/what-is-web-inf-used-for-in-a-java-ee-web-application
 * 
 * 
 * How to deploy SpringMVC app to tomcat?
 * http://stackoverflow.com/questions/19903637/how-to-deploy-my-spring-mvc-web-application-using-the-build-classes-or-war-file
 */

@Configuration
@EnableWebMvc
@ComponentScan("web")
public class WebConfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;
	
    @Bean
    public ViewResolver viewResolver(){
    	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    	resolver.setPrefix("/WEB-INF/templates/");
    	resolver.setSuffix(".jsp");
    	resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
    	return resolver;
    }
	

	
	@Bean
	public MultipartResolver multipartResolver() throws IOException{
		return new StandardServletMultipartResolver();
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	

}
