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
class ArticleControllerTest {
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
    void saveArticle() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("id", Collections.singletonList("for_test"));
        params.put("title", Collections.singletonList("123456"));
        params.put("content", Collections.singletonList("123456"));
        params.put("user_id", Collections.singletonList("8348635108338113213"));
        params.put("cover", Collections.singletonList("123456"));
        mockMvc.perform(MockMvcRequestBuilders.post("/article/save")
                        .params(params)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    void getArticle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/article/getById")
                        .param("id", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.article").isNotEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    void getAllArticle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/article/getAllArticles")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.articles").isNotEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Transactional
    @Rollback
    void comment() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("info", Collections.singletonList("for_test"));
        params.put("articleId", Collections.singletonList("123456"));
        params.put("userId", Collections.singletonList("8348635108338113213"));
        mockMvc.perform(MockMvcRequestBuilders.post("/article/comment")
                        .params(params)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    void getArticleComments() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/article/getArticleComments")
                        .param("id", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.data.articleComments").isNotEmpty())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Transactional
    @Rollback
    void likeArticle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/article/likeArticle")
                        .param("id", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.data.message").value("Like increased by 1"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Transactional
    @Rollback
    void unlikeArticle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/article/unlikeArticle")
                        .param("id", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.data.message").value("Like decreased by 1"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}