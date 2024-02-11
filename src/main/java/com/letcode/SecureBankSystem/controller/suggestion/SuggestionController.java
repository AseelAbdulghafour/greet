package com.letcode.SecureBankSystem.controller.suggestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {

    private final GuestSuggestionService suggestionService;

    @Autowired
    public SuggestionController(GuestSuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @PostMapping("/suggest")
    public ResponseEntity<List<GuestSuggestionEntity>> handleSuggestions(@RequestBody CreateSuggestionRequest suggestionRequest) {
        List<GuestSuggestionEntity> suggestionList = suggestionService.printAndProcessSuggestion(suggestionRequest.getSuggestionText());
        return ResponseEntity.ok(suggestionList);
    }
}
