package com.sustech.main_service.controller;

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
        mockMvc.perform(MockMvcRequestBuilders.post("/account/login")
                        .params(params)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.user").isNotEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        params.put("username", Collections.singletonList("no_such_user"));
        mockMvc.perform(MockMvcRequestBuilders.post("/account/login")
                        .params(params)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No such user or invalid username or password"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Transactional
    @Rollback
    void register() throws Exception {
        MultiValueMap<String, String> params1 = new LinkedMultiValueMap<>();
        params1.put("username", Collections.singletonList("for_test_no_password"));
        params1.put("password", Collections.singletonList("123456"));
        params1.put("nick_name", Collections.singletonList("nick_test"));
        params1.put("email", Collections.singletonList("123456789@sus.com"));

        mockMvc.perform(MockMvcRequestBuilders.post("/account/register")
                        .params(params1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Success to register."))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        MultiValueMap<String, String> params2 = new LinkedMultiValueMap<>();
        params2.put("username", Collections.singletonList("for_test"));
        params2.put("password", Collections.singletonList("123456"));
        params2.put("nick_name", Collections.singletonList("nick_test"));
        params2.put("email", Collections.singletonList("123456789@sus.com"));
        mockMvc.perform(MockMvcRequestBuilders.post("/account/register")
                        .params(params2)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("User exists, please try again."))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        MultiValueMap<String, String> params3 = new LinkedMultiValueMap<>();
        params3.put("username", Collections.singletonList("for_test_new"));
        params3.put("nick_name", Collections.singletonList("nick_test"));
        params3.put("email", Collections.singletonList("123456789@sus.com"));
        mockMvc.perform(MockMvcRequestBuilders.post("/account/register")
                        .params(params3)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No password."))
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
        mockMvc.perform(MockMvcRequestBuilders.post("/account/revise")
                        .params(params)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}