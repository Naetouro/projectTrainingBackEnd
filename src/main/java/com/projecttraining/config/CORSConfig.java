package com.projecttraining.config;// Created by M.Melloul

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author quentin
 *
 */
@Configuration
@EnableWebMvc
public class CORSConfig extends WebMvcConfigurerAdapter {

    /**
     *
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
