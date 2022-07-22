package com.example.purchases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PurchasesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PurchasesApplication.class, args);
    }

    /*@Bean
    public HttpMessageConverter<Object> createXmlHttpMessageConverter() {

        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        return new MarshallingHttpMessageConverter(jaxb2Marshaller, jaxb2Marshaller);
    }*/
}
