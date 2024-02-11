package com.letcode.SecureBankSystem.repository;

import com.letcode.SecureBankSystem.entity.GuestSuggestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestSuggestionRepository extends JpaRepository<GuestSuggestionEntity,Long> {
    List<GuestSuggestionEntity> findByStatus(SuggestionsStatus status);
}
