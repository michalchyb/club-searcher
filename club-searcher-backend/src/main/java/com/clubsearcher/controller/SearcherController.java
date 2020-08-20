package com.clubsearcher.controller;

import com.clubsearcher.model.Information;
import com.clubsearcher.model.Output;
import com.clubsearcher.service.SearcherService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SearcherController {

    private static final String WIKIPEDIA_API_ENDPOINT = "https://en.wikipedia.org/w/api.php?action=query&list=search&format=json&srsearch=%s&srlimit=10";

    private SearcherService searcherService;

    public SearcherController(SearcherService searcherService) {
        this.searcherService = searcherService;
    }

    @GetMapping()
    public Output getUrl(@RequestParam(value = "clubName") String clubName) {
        Information information = getDataFromWikipedia(clubName);

        return searcherService.getClubLink(clubName, information);
    }

    private Information getDataFromWikipedia(String clubName) {
        return new RestTemplate().getForObject(String.format(WIKIPEDIA_API_ENDPOINT, clubName), Information.class);
    }
}
