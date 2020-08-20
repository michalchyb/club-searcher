package com.clubsearcher.controller;

import com.clubsearcher.service.SearcherService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SearcherController.class)
class SearcherControllerTest {

    private static final String EMPTY_CLUB_NAME = "";
    private static final String CORRECT_CLUB_NAME = "Lech Poznań";
    private static final String INCORRECT_CLUB_NAME = "Incorrect";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SearcherService searcherService;

    @Test
    void getUrlWithEmptyClubName_ERROR_MESSAGE() throws Exception {

        mvc.perform(get("/api")
                .contentType("application/json")
                .param("clubName", EMPTY_CLUB_NAME))
                .andExpect(status().isOk());

    }

    @Test
    void getUrlWithCorrectClubName_SUCCESS() throws Exception {
        mvc.perform(get("/api")
                .contentType("application/json")
                .param("clubName", CORRECT_CLUB_NAME))
                .andExpect(status().isOk());

    }

    @Test
    void getUrlWithWrongClubName_ERROR_MESSAGE() throws Exception {
        mvc.perform(get("/api")
                .contentType("application/json")
                .param("clubName", INCORRECT_CLUB_NAME))
                .andExpect(status().isOk());
    }

}