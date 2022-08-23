package com.home.english.dto;

import com.home.english.dao.Role;
import com.home.english.dao.WordForStudy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class UsersDto {

    private Long id;

    private String login;

    private String pass;

    private Boolean active;

    private List<WordForStudy> words;

    private Set<Role> roles;
}
