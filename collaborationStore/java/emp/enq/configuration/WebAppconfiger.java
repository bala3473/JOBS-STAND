package emp.enq.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="emp.enq")//similar to <context:component-scan> in dispatcher-servlet.xml 
public class WebAppconfiger extends WebMvcConfigurerAdapter {
	
	public WebAppconfiger() {
		System.out.println("web app configuration created or instantiated");
	}

}
