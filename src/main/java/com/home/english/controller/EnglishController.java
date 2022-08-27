package com.home.english.controller;

import com.home.english.dto.UsersDto;
import com.home.english.dto.WordForStudyDto;
import com.home.english.services.EnglishServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class EnglishController {
    @Autowired
    EnglishServices englishServices;

    @GetMapping("online/word/{id}")
    public WordForStudyDto getWord(@PathVariable Long id) {
        return englishServices.getWordForStudyDto(id);
    }

    @GetMapping("online/user/{id}")
    public UsersDto getUser(@PathVariable Long id) {
        return englishServices.getUsersDto(id);
    }

    @PostMapping("online/newWord")
    @ResponseStatus(HttpStatus.OK)
    public void addWord(@RequestBody WordForStudyDto wordDto) {
        englishServices.addWord(wordDto);
    }

    @PostMapping("online/user")
    @ResponseStatus(HttpStatus.OK)
    public void addUser(@RequestBody UsersDto usersDto) {
        englishServices.addUser(usersDto);
    }

    @PostMapping("online/check")
    @ResponseStatus(HttpStatus.OK)
    public void checkWord(@RequestBody WordForStudyDto wordDto) {
        englishServices.checkWord(wordDto);
    }
}