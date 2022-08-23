package com.home.english.services;

import com.home.english.dao.Users;
import com.home.english.dao.WordForStudy;
import com.home.english.repository.UserRepository;
import com.home.english.repository.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class EnglishServicesImpl implements EnglishServices {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WordsRepository wordsRepository;

    @Override
    public WordForStudy getWordForCheck() {
        List<WordForStudy> allWords = wordsRepository.findAll();
        List<WordForStudy> wordsCurrentUser = allWords.stream()
                .filter(wordForStudy -> wordForStudy.getUsers().getId() == 1)
                .collect(Collectors.toList());
        return wordsCurrentUser.get(ThreadLocalRandom.current().nextInt(0, wordsCurrentUser.size()));
    }

    @Override
    public WordForStudy addWord() {
        return null;
    }

    @Override
    public void addUser(Users user) {
        userRepository.save(user);
    }

    @Override
    public Set<String> getSetLogins() {

        return userRepository.findAll().stream()
                .map(Users::getLogin)
                .collect(Collectors.toSet());
    }

    @Override
    public Users getUserIfExist(String login, String password) {
        List<Users> collect = userRepository.findAll().stream()
                .filter(user -> user.getLogin().equals(login) & user.getPass().equals(password))
                .collect(Collectors.toList());
        return collect.get(0) != null ? collect.get(0) : null;
    }

    @Override
    public Users getUserById(Long id) {
        Optional<Users> byId = userRepository.findById(id);
        return byId.get();
    }

    @Override
    public void addWordForStudy(WordForStudy wordForStudy) {
        wordsRepository.save(wordForStudy);
    }


}
