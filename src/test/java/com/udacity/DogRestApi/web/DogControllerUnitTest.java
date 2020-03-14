package com.udacity.DogRestApi.web;

import com.udacity.DogRestApi.controller.DogController;
import com.udacity.DogRestApi.service.retrieveDog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {DogController.class})
@AutoConfigureMockMvc(addFilters = false)
public class DogControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    retrieveDog dogService;

    @Test
    public void getAllDogs() throws Exception {
        mockMvc.perform(get("/dogs/"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
        verify(dogService, times(1)).retrieveDogs();
    }

    @Test
    public void retrieveDogByBreed() throws Exception {
        mockMvc.perform(get("/dogbreeds/"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
        verify(dogService, times(1)).retrieveDogByBreed();
    }

    @Test
    public void retrieveDogNames() throws Exception {
        mockMvc.perform(get("/dognames/"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
        verify(dogService, times(1)).retrieveDogNames();
    }

    @Test
    public void retrieveDogBreedById() throws Exception {
        mockMvc.perform(get("/dogbreeds/1"))
                .andExpect(status().isOk());
        verify(dogService, times(1)).retrieveDogBreedById(new Long(1));
    }
}