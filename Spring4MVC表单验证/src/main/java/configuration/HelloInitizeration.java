package configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HelloInitizeration extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{HelloConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
}
