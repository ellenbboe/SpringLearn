package com.Configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan(basePackages={"com"},
        excludeFilters={@ComponentScan.Filter(type= FilterType.ANNOTATION,
                value=EnableWebMvc.class)})
@Import({jdbcConfiguration.class,
        JPAConfiguration.class,TransactionalConfig.class})
public class RootConfiguration {
}
