package com.cot.controller;

import com.cot.base.AbstractWebIntegrationTest;
import com.cot.domain.Placement;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PlacementControllerTest extends AbstractWebIntegrationTest {

    @Test
    public void getPlacements() throws Exception {
        mockMvc.perform(get("/placement")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    public void getPlacement() throws Exception {
        mockMvc.perform(get("/placement/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    public void create() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(post("/placement")
                .content(mapper.writeValueAsString(Placement.builder().name("test_create").build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.CREATED.value()));
    }

    @Test
    public void update() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(put("/placement/2")
                .content(mapper.writeValueAsString(Placement.builder().id(2L).name("test_create").build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/placement/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()));
    }
}
