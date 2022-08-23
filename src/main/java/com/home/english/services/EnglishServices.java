package com.home.english.services;

import com.home.english.dao.Users;
import com.home.english.dao.WordForStudy;

import java.util.Set;

public interface EnglishServices {
    WordForStudy getWordForCheck();

    WordForStudy addWord();

    void addUser(Users user);

    Set<String> getSetLogins();

    Users getUserIfExist(String login, String password);

    Users getUserById(Long id);

    void addWordForStudy(WordForStudy wordForStudy);
}
