package com.home.english.repository;

import com.home.english.dao.WordForStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordsRepository extends JpaRepository<WordForStudy, Long> {
    List<WordForStudy> findAllByUsersId(Long id);

    WordForStudy findFirstByWordIs(String word);
}