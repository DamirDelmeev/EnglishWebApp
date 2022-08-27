package com.home.english.services;

import com.home.english.dto.UsersDto;
import com.home.english.dto.WordForStudyDto;

public interface EnglishServices {
    WordForStudyDto getWordForStudyDto(Long id);

    UsersDto getUsersDto(Long id);

    void addWord(WordForStudyDto wordDto);

    void addUser(UsersDto usersDto);

    void checkWord(WordForStudyDto wordDto);
}

