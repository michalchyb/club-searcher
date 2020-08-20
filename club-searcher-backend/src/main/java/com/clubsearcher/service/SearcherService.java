package com.clubsearcher.service;

import com.clubsearcher.model.Information;
import com.clubsearcher.model.Output;
import com.clubsearcher.model.Query;
import com.clubsearcher.model.Search;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SearcherService {
    private static final String OUTPUT = "https://en.wikipedia.org/wiki/%s";
    private static final String CLUB_NOT_FOUND_MESSAGE = "There is no football club found for \"%s\" in Wikipedia";
    private static final ImmutableList<String> CATEGORIES = ImmutableList.of("Football", "Football Club", "F.C");

    public Output getClubLink(String clubName, Information information) {
        Optional<Search> search = CATEGORIES.stream().map(c -> filterInformationByCategories(information, c)).findFirst();

        Output output = new Output();

        search.ifPresent(s -> {
            if (s.getTitle() != null) {
                output.setOutput(String.format(OUTPUT, s.getTitle().replace(" ", "_")));
            } else {
                output.setOutput(String.format(CLUB_NOT_FOUND_MESSAGE, clubName));
            }
        });
        return output;
    }

    private Search filterInformationByCategories(Information information, String category) {
        Query query = information.getQuery();
        Search resultSearch = new Search();
        if (query != null) {
            resultSearch = query.getSearch()
                    .stream()
                    .filter(x -> x.getSnippet().toLowerCase().contains(category.toLowerCase()))
                    .findFirst()
                    .orElse(new Search());
        }
        return resultSearch;
    }
}