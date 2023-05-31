package com.sustech.main_service.controller;

import com.alibaba.fastjson.JSONObject;
import com.sustech.main_service.entity.UserCollection;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserCollectionControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Transactional
    @Rollback
    void addUserCollections() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("userId", Collections.singletonList("8348635108338113213"));
        params.put("articleOrTopicId", Collections.singletonList("8348635108338113213"));
        params.put("isArticle", Collections.singletonList("true"));
        mockMvc.perform(MockMvcRequestBuilders.post("/userCollection/addUserCollections")
                        .params(params)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.data.collection").isNotEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Transactional
    @Rollback
    void deleteUserCollections() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("userId", Collections.singletonList("8348635108338113213"));
        params.put("collectionId", Collections.singletonList("1"));
        mockMvc.perform(MockMvcRequestBuilders.post("/userCollection/deleteUserCollections")
                        .params(params)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.data.message").value("Success to delete collection"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}