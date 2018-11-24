package com;

import com.site.service.StorageProperties;
import com.site.service.StorageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    //初始化    @Bean
//    CommandLineRunner init(@Qualifier("fileSystemStorageService") StorageService storageService) {
//        return (args) -> {
//            storageService.init();
//        };
//    }
//    @Bean
//    CommandLineRunner init2(@Qualifier("wallPaperStorageService") StorageService storageService) {
//        return (args) -> {
//            storageService.init();
//        };
//    }
}
