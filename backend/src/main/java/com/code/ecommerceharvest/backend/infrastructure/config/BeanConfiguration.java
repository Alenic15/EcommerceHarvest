package com.code.ecommerceharvest.backend.infrastructure.config;

import com.code.ecommerceharvest.backend.application.*;
import com.code.ecommerceharvest.backend.domain.port.ICategoryRepository;
import com.code.ecommerceharvest.backend.domain.port.IOrderRepository;
import com.code.ecommerceharvest.backend.domain.port.IProductRepository;
import com.code.ecommerceharvest.backend.domain.port.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class BeanConfiguration {
    @Bean
    public UserService userService(IUserRepository iUserRepository){
        return new UserService(iUserRepository);
    }

    @Bean
    public CategoryService categoryService(ICategoryRepository iCategoryRepository){
        return new CategoryService(iCategoryRepository);
    }

    @Bean
    public ProductService productService(IProductRepository iProductRepository, UploadFile uploadFile ){
        return  new ProductService(iProductRepository, uploadFile);
    }

    @Bean
    public OrderService orderService(IOrderRepository iOrderRepository){
        return new OrderService(iOrderRepository);
    }

    @Bean
    public UploadFile uploadFile(){
        return new UploadFile();
    }

    @Bean
    public RegistrationService registrationService(IUserRepository iUserRepository){
        return new RegistrationService(iUserRepository);
    }

}
