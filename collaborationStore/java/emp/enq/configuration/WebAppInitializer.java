package emp.enq.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("getRootConfigClasses is created");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("getServletConfigClasses is created");
		return new Class[] {WebAppconfiger.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("getServletMappings is created");
		return new String[] {"/"};
	}
	

}
