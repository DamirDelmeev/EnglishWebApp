package com.home.english.controller;

import com.home.english.dao.Role;
import com.home.english.dao.Users;
import com.home.english.dao.WordForStudy;
import com.home.english.services.EnglishServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/")
public class EnglishController {
    @Autowired
    EnglishServices englishServices;


    @GetMapping("online/checkWord/{id}")
    public String checkWord(@PathVariable Long id) {
        return "checkWord";
    }

    @GetMapping("online/addNotePage/{id}")
    public String getAddNotePage(@PathVariable Long id, Model model) {
        Users userById = englishServices.getUserById(id);
        model.addAttribute("user", userById);
        return "addNote";
    }

    @PostMapping("online/addNotePage/newWord")
    public String addNote(@RequestParam("userId") Long id, @RequestParam("word") String word,
                          @RequestParam("translation") String translation, Model model) {
        Users users = new Users();
        users.setId(id);
        WordForStudy wordForStudy = WordForStudy.builder()
                .word(word)
                .translation(translation)
                .users(users)
                .build();
        englishServices.addWordForStudy(wordForStudy);
        return "redirect:online/" + id;
    }

    @GetMapping("online/logout/{id}")
    public String logout(@ModelAttribute("id") @PathVariable Long id, Model model) {
        Users userById = englishServices.getUserById(id);
        userById.setActive(false);
        englishServices.addUser(userById);
        return "redirect:/";
    }

    @GetMapping()
    public String mainPage() {
        return "mainPage";
    }

    @GetMapping("registrationPage")
    public String getRegistrationPage() {
        return "registrationPage";
    }

    @GetMapping("logInPage")
    public String getLogInPage() {
        return "logInPage";
    }

    @PostMapping("registrationPage")
    public String addUser(@RequestParam("login") String login, @RequestParam("pass") String password) {
        Users user = Users.builder()
                .login(login)
                .pass(password)
                .active(true)
                .roles(Collections.singleton(Role.ADMIN))
                .build();
        if (englishServices.getSetLogins().contains(login)) {
            return "redirect:registrationPage";
        }
        englishServices.addUser(user);
        return "redirect:/logInPage";
    }

    @PostMapping("logInPage")
    public String getLoginPage(@RequestParam("login") String login, @RequestParam("pass") String password) {
        Users user;
        try {
            user = englishServices.getUserIfExist(login, password);
        } catch (IndexOutOfBoundsException e) {
            return "redirect:logInPage";
        }

        return "redirect:online/" + user.getId();
    }

    @GetMapping("online/{id}")
    public String getAfterLoginPage(@ModelAttribute("id") @PathVariable Long id, Model model) {
        model.addAttribute("user", englishServices.getUserById(id));
        return "onlinePage";
    }
}

