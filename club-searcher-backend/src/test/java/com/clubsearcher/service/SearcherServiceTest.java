package com.clubsearcher.service;

import com.clubsearcher.model.Information;
import com.clubsearcher.model.Output;
import com.clubsearcher.model.Query;
import com.clubsearcher.model.Search;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.mockito.Mockito.mock;

class SearcherServiceTest {
    private static final String CORRECT_CLUB_NAME = "Lech Poznań";
    private static final String INCORRECT_CLUB_NAME = "Incorrect";
    private static final String WIKIPEDIA_API_ENDPOINT = "https://en.wikipedia.org/w/api.php?action=query&list=search&format=json&srsearch=%s&srlimit=10";


    @Test
    void get_url_correct_club_name() {
        final String expected = "https://en.wikipedia.org/wiki/Lech_Poznań";
        RestTemplate restTemplate = mock(RestTemplate.class);
        Information information = setApiResponse("Lech Poznań", "test football snippet");

        SearcherService searcherService = new SearcherService();
        Mockito.when(restTemplate.getForObject(String.format(WIKIPEDIA_API_ENDPOINT, CORRECT_CLUB_NAME), Information.class)).thenReturn(information);

        Output output = searcherService.getClubLink(CORRECT_CLUB_NAME, information);
        Assert.assertEquals(expected, output.getOutput());
    }

    @Test
    void get_url_incorrect_club_name() {
        final String expected = "There is no football club found for \"%s\" in Wikipedia";
        RestTemplate restTemplate = mock(RestTemplate.class);
        Information information = setApiResponse("incorrect", "test history snippet");

        SearcherService searcherService = new SearcherService();
        Mockito.when(restTemplate.getForObject(String.format(WIKIPEDIA_API_ENDPOINT, INCORRECT_CLUB_NAME), Information.class)).thenReturn(information);

        Output output = searcherService.getClubLink(INCORRECT_CLUB_NAME, information);
        Assert.assertEquals(String.format(expected, INCORRECT_CLUB_NAME), output.getOutput());
    }


    private Information setApiResponse(String title, String snippet) {
        Information information = new Information();
        Query query = new Query();
        Search search = new Search(11, title, 12321, 1221, 88664, snippet, "12-12-12");
        query.setSearch(Arrays.asList(search));
        information.setQuery(query);
        return information;
    }

}