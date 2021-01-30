package link.hitech.gaspar.controller;

import link.hitech.gaspar.entity.Suggestion;
import link.hitech.gaspar.service.DataIngestionService;
import link.hitech.gaspar.service.RapidSuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class RestAPIController {

    @Autowired
    DataIngestionService dataIngestionService;

    @Autowired
    RapidSuggestService rapidSuggestService;

    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postSuggestions(@RequestBody List<Suggestion> suggestions) {
        dataIngestionService.submitSuggestions(suggestions);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/rapidsuggest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity autocomplete(@RequestParam("q") String query,
                                       @RequestParam(name = "n", defaultValue = "10") int n,
                                        @RequestParam(name = "g", defaultValue = "movies,people") String groups) {
        Set<Suggestion> results = rapidSuggestService.getSuggestions(n, groups, query);
        return new ResponseEntity(results, HttpStatus.OK);
    }


}
