package com.letcode.SecureBankSystem.service.suggestions;

import com.letcode.SecureBankSystem.bo.suggestion.CreateSuggestionRequest;

public interface ProcessSuggestion {
    void processSuggestion(CreateSuggestionRequest suggestionTex);
}
