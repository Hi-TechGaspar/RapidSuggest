package link.hitech.gaspar.controller;

import link.hitech.gaspar.entity.Suggestion;
import link.hitech.gaspar.service.DataIngestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestAPIController {

    @Autowired
    DataIngestionService dataIngestionService;

    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postSuggestions(@RequestBody List<Suggestion> suggestions) {
        dataIngestionService.submitSuggestions(suggestions);
        return new ResponseEntity(HttpStatus.OK);
    }


}
