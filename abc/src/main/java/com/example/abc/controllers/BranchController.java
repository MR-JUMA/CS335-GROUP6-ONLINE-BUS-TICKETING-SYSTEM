package com.example.abc.controllers;

import com.example.abc.models.Branch;
import com.example.abc.models.Bus;
import com.example.abc.models.City;
import com.example.abc.repositories.BranchRepository;
import com.example.abc.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.util.ArrayUtils;

import java.util.List;

@Controller
public class BranchController {
    @Autowired
    BranchRepository branchRepository;

    @Autowired
    CityRepository cityRepository;

//    @Bean
//    public ViewResolver htmlViewResolver() {
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine(htmlTemplateResolver()));
//        resolver.setContentType("text/html");
//        resolver.setCharacterEncoding("UTF-8");
//        resolver.setViewNames(ArrayUtil.array("*.html"));
//        return resolver;
//    }
//
//    private ITemplateResolver htmlTemplateResolver(){
//        SpringResourceTemplateResolver resolver=new SpringResourceTemplateResolver();
//        resolver.setApplicationContext(applicationContext);
//        resolver.setPrefix("/resources/templates");
//        resolver.setCacheable(false);
//        resolver.setTemplateMode(TemplateMode.HTML);
//        return resolver;
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/resources/**", "/static/**")
//                .addResourceLocations("/resources/templates","/resources/static/css");
//    }



}
