package com.home.english.repository;

import com.home.english.dao.WordForStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRepository extends JpaRepository<WordForStudy, Long> {
}