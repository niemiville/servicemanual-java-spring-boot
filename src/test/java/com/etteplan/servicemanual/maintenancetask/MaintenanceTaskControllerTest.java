package com.etteplan.servicemanual.maintenancetask;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MaintenanceTaskControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getMaintenanceTasks() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/maintenancetasks").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
    
    @Test
    public void getMaintenanceTaskById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/maintenancetasks/1001").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
    
    @Test
    public void getMaintenanceTaskByTargetId() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/maintenancetasks/target/1").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    public void getMaintenanceTaskNotFound() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/maintenancetasks/1000000").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
    }
    
    @Test
    public void postMaintenanceTask() throws Exception {
    	final String task = "{\"targetId\": 1,\"description\": \"Test problem\",\"severity\": \"unimportant\",\"status\": \"closed\"}";
        mvc.perform(MockMvcRequestBuilders.post("/maintenancetasks").contentType(MediaType.APPLICATION_JSON)
            .content(task)).andExpect(status().isOk());
    }
    
    @Test
    public void putMaintenanceTask() throws Exception {
    	final String task = "{\"targetId\": 4,\"description\": \"Handle bar broke\",\"severity\": \"critical\",\"status\": \"open\"}";
        mvc.perform(MockMvcRequestBuilders.put("/maintenancetasks/1005").contentType(MediaType.APPLICATION_JSON)
            .content(task)).andExpect(status().isOk());
    }
    
    @Test
    public void deleteMaintenanceTask() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.delete("/maintenancetasks/1005").accept(MediaType.APPLICATION_JSON))
        	.andExpect(status().isOk());
    }
}