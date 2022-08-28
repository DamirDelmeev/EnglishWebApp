package com.home.english.controller;

import com.home.english.dto.UsersDto;
import com.home.english.dto.WordForStudyDto;
import com.home.english.services.EnglishServices;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/en")
public class EnglishController {
    @Autowired
    EnglishServices englishServices;

    @GetMapping("/online/word/{id}")
    @ApiOperation(value = "Find word by UserId.",
            notes = "Find one of the word from db with counter successCounter lees then 3.",
            response = WordForStudyDto.class)
    public WordForStudyDto getWord(@ApiParam(value = "UserId for search word.", required = true)
                                   @PathVariable Long id) {
        return englishServices.getWordForStudyDto(id);
    }

    @GetMapping("/online/user/{id}")
    @ApiOperation(value = "Find user by UserId.",
            notes = "Provide an id to find specific user from db.",
            response = UsersDto.class)
    public UsersDto getUser(@ApiParam(value = "Id for search user", required = true) @PathVariable Long id) {
        return englishServices.getUsersDto(id);
    }

    @PostMapping("/online/newWord")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Add new word.",
            notes = "Add new word in db after use mapper.",
            response = HttpStatus.class)
    public void addWord(@ApiParam(value = "WordObject check model.", required = true)
                        @RequestBody WordForStudyDto wordDto) {
        englishServices.addWord(wordDto);
    }

    @PostMapping("/online/user")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Add new user.",
            notes = "Add new user in db after use mapper.",
            response = HttpStatus.class)
    public void addUser(@ApiParam(value = "UserObject check model.", required = true)
                        @RequestBody UsersDto usersDto) {
        englishServices.addUser(usersDto);
    }

    @PostMapping("/online/check")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Check word.",
            notes = "Check word ,change successCounter and update word.",
            response = HttpStatus.class)
    public void checkWord(@ApiParam(value = "WordObject check model.", required = true)
                          @RequestBody WordForStudyDto wordDto) {
        englishServices.checkWord(wordDto);
    }
}