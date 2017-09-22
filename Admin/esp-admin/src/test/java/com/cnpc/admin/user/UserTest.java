package com.cnpc.admin.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext

    @Before // 在测试开始前初始化工作
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

    }

    @Test
    public void save() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("http://localhost:8888/admin/user/save.do?password=code1");  //构造一个请求
        MvcResult mvcResult = mockMvc.perform(request)//执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
                .andReturn() ; //表示执行完成后返回相应的结果。
        System.out.println(mvcResult.getResponse().getContentAsString());

    }


}