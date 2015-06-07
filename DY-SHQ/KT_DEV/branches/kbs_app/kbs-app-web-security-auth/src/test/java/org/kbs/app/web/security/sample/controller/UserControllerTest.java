package org.kbs.app.web.security.sample.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kbs.app.web.security.sample.config.AppConfig;
import org.kbs.app.web.security.sample.config.MvcConfig;
import org.kbs.app.web.security.sample.config.SecurityConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={ AppConfig.class, SecurityConfig.class,MvcConfig.class})
public class UserControllerTest {
    @Resource
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void printBeans(){
        String[] beans=webApplicationContext.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }
    }

}
