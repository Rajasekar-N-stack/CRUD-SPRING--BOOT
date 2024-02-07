package com.example.springapp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = SpringappApplication.class)
@AutoConfigureMockMvc
class SpringappApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Order(1)
@Test
void testAddEmployee() throws Exception {
    String requestBody = "{\"employeeId\": 1, \"employeeName\": \"John Doe\", \"employeeEmail\": \"john.doe@example.com\", \"salary\": 50000.00, \"department\": \"Engineering\"}";

    mockMvc.perform(MockMvcRequestBuilders.post("/api/employee")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.employeeName").value("John Doe"))
            .andReturn();
}


@Test
@Order(2)
void testupdateDetails() throws Exception {
    String requestBody = "{\"employeeId\": 1, \"employeeName\": \"John Doe\", \"employeeEmail\": \"john.doe@example.com\", \"salary\": 50000.00, \"department\": \"Engineering\"}";
    mockMvc.perform(MockMvcRequestBuilders.put("/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$.productName").value("KIO"))
            .andReturn();
}



@Test
@Order(3)
void testdeleteById() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete("/1")
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").value(true))
            .andReturn();
}








}
