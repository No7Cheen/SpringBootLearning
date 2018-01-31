package com.issexplorer.hello;

import com.alibaba.fastjson.JSON;
import com.issexplorer.hello.controller.HelloController;
import com.issexplorer.hello.controller.UserController;
import com.issexplorer.hello.model.UserEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// Back 默认配置
// @RunWith(SpringRunner.class)
// @SpringBootTest

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class HelloApplicationTests {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController(), new UserController()).build();
    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World!!!")));
    }

    @Test
    public void testUserController() throws Exception {
        UserEntity user = new UserEntity();
        user.id = 1L;
        user.name = "测试Name-" + user.id;
        user.gender = 1;
        user.age = 20;

        // get user列表，第一次应该为空
        RequestBuilder request = get("/users/")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        String responseString = mvc.perform(request)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().string(equalTo("[]")))
                .andReturn().getResponse().getContentAsString();

        System.out.println("Get--------返回的json = " + responseString);

        // post user
        request = post("/users/")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(JSON.toJSONString(user));
        responseString = mvc.perform(request)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        Assert.assertEquals(user, JSON.parseObject(responseString, UserEntity.class));
        Assert.assertEquals(user.toString(), JSON.parseObject(responseString, UserEntity.class).toString());

        System.out.println("Put--------返回的json = " + user.toString());
        System.out.println("Put--------返回的json = " + JSON.parseObject(responseString, UserEntity.class).toString());
        System.out.println("Put--------返回的json = " + responseString);

        // get user列表，应该有刚才插入的数据
        request = get("/users/")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        responseString = mvc.perform(request)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println("Get--------返回的json = " + responseString);

        // put 修改 user
        user.age = user.age + 1;
        user.name = user.name + "-put";
        request = put("/users/" + user.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(JSON.toJSONString(user));
        responseString = mvc.perform(request)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println("Put--------返回的json = " + responseString);

        // get user
        request = get("/users/" + user.id);
        responseString = mvc.perform(request)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println("Get id--------返回的json = " + responseString);

        // delete user
        request = delete("/users/" + user.id);
        responseString = mvc.perform(request)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println("Delete--------返回的json = " + responseString);

        // get user 列表，应该为空
        request = get("/users/");
        responseString = mvc.perform(request)
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().string(equalTo("[]")))
                .andReturn().getResponse().getContentAsString();

        System.out.println("删除后的列表应该为空--------返回的json = " + responseString);

    }

    @Test
    public void contextLoads() {
    }

}
