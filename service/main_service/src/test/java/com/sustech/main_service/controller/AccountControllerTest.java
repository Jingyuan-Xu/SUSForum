package com.sustech.main_service.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
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
class AccountControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void login() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("username", Collections.singletonList("for_test"));
        params.put("password", Collections.singletonList("123456"));
        mockMvc.perform(MockMvcRequestBuilders.get("/account/login")
                        .params(params)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.user").isNotEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        params.put("username", Collections.singletonList("no_such_user"));
        mockMvc.perform(MockMvcRequestBuilders.get("/account/login")
                        .params(params)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.message").value("No such user or invalid username or password"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Transactional
    @Rollback
    void register() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("username", Collections.singletonList("for_test"));
        params.put("nick_name", Collections.singletonList("nick_test"));
        params.put("email", Collections.singletonList("123456789@sus.com"));

        mockMvc.perform(MockMvcRequestBuilders.get("/account/register")
                        .params(params)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.message").value("No password."))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        params.put("password", Collections.singletonList("123456"));
        mockMvc.perform(MockMvcRequestBuilders.get("/account/register")
                        .params(params)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.message").value("Success to register."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.user").isNotEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        mockMvc.perform(MockMvcRequestBuilders.get("/account/register")
                        .params(params)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.message").value("User exists, please try again."))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Transactional
    @Rollback
    void reviseInfo() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("id", Collections.singletonList("8348635108338113213"));
        params.put("username", Collections.singletonList("for_test"));
        params.put("password", Collections.singletonList("123456"));
        params.put("nick_name", Collections.singletonList("nick_test"));
        params.put("email", Collections.singletonList("123456789@sus.com"));
        params.put("avatar", Collections.singletonList("ava"));
        params.put("background", Collections.singletonList("bg"));
        mockMvc.perform(MockMvcRequestBuilders.get("/account/revise")
                        .params(params)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}