package com.home.english.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.home.english.dao.Role;
import com.home.english.dao.WordForStudy;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@ApiModel(description = "Detail about user.")
public class UsersDto {
    @ApiModelProperty(notes = "The unique id of the user.")
    private Long id;
    @ApiModelProperty(notes = "The user's login.")
    private String login;
    @ApiModelProperty(notes = "The user's pass will be save in bcrypt.")
    private String pass;
    @ApiModelProperty(notes = "The user's status of online.")
    private Boolean active;
    @ApiModelProperty(notes = "List words for current user.")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<WordForStudy> words;
    @ApiModelProperty(notes = "Set roles for user and his security.")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Role> roles;
}
