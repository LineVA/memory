package com.doyenm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListLearningConfig {

    @Bean
    public ListLearning listLearning(){
        return new ListLearning();
    }
}
