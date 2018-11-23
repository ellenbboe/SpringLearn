//package com.site.configuration;
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import javax.servlet.MultipartConfigElement;
//import javax.servlet.ServletRegistration;
//
//public class websiteInit extends AbstractAnnotationConfigDispatcherServletInitializer {
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[]{Websiteconfiguration.class};
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return null;
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//    @Override
//    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        registration.setMultipartConfig(new MultipartConfigElement("/KosmosUserData",2097152,4194304,0));
//    }
//}
