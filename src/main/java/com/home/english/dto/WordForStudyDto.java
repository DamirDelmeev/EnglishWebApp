package com.home.english.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.home.english.dao.Users;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@ApiModel(description = "Detail about word.")
public class WordForStudyDto {
    @ApiModelProperty(notes = "The unique id of the word.")
    private Long id;
    @ApiModelProperty(notes = "Value of the word")
    private String word;
    @ApiModelProperty(notes = "Translation of the word.")
    private String translation;
    @ApiModelProperty(notes = "Counter of success when user enters the correct answer.")
    private Integer successCounter;
    @ApiModelProperty(notes = "UserId for current word.")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Users users;
}
