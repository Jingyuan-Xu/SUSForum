package com.sustech.main_service.controller;

import com.sustech.main_service.entity.User;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserCenterControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getUserData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/userCenter/getUserData")
                        .param("userId", "8348635108338113213")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.user").isNotEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        mockMvc.perform(MockMvcRequestBuilders.get("/userCenter/getUserData")
                        .param("userId", "")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No such user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Transactional
    @Rollback
    void editUserData() throws Exception {
        User user = new User();
        user.setId("8348635108338113213");
        user.setNick_name("nick name for test");
        mockMvc.perform(MockMvcRequestBuilders.post("/userCenter/editUserData")
                        .content(JSONObject.toJSONString(user))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.user").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.user.id").value("8348635108338113213"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.user.nick_name").value("nick name for test"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        user.setId("");
        mockMvc.perform(MockMvcRequestBuilders.post("/userCenter/editUserData")
                        .content(JSONObject.toJSONString(user))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No such user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    void getUserArticles() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/userCenter/getUserArticles")
                        .param("userId", "8348635108338113213")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.articles").isNotEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    void getUserTopics() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/userCenter/getUserTopics")
                        .param("userId", "8348635108338113213")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.topics").isNotEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    void getUserComments() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/userCenter/getUserComments")
                        .param("userId", "8348635108338113213")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.comments").isNotEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    void getUserCollections() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/userCenter/getUserCollections")
                        .param("userId", "8348635108338113213")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.collections").isNotEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}