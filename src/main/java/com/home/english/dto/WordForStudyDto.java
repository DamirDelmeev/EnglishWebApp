package com.home.english.dto;

import com.home.english.dao.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class WordForStudyDto {

    private Long id;

    private String word;

    private String translation;

    private Integer successCounter;

    private Users users;
}
