package com.cot.controller;

import com.cot.base.AbstractWebIntegrationTest;
import com.cot.domain.Campaign;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CampaignControllerTest extends AbstractWebIntegrationTest {

    @Test
    public void getCampaigns() throws Exception {
        mockMvc.perform(get("/campaign")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    public void getCampaign() throws Exception {
        mockMvc.perform(get("/campaign/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    public void create() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(post("/campaign")
                .content(mapper.writeValueAsString(Campaign.builder().name("test_create").build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.CREATED.value()));
    }

    @Test
    public void update() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(put("/campaign/2")
                .content(mapper.writeValueAsString(Campaign.builder().id(2L).name("test_create").build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/campaign/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()));
    }
}
