package com.home.english.mapper;

import com.home.english.dao.WordForStudy;
import com.home.english.dto.WordForStudyDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WordsMapper {
    WordForStudy wordDtoInWord(WordForStudyDto wordDto);

    WordForStudyDto wordInWordDto(WordForStudy word);

    List<WordForStudy> listWordDtoInWordList(List<WordForStudyDto> wordDtoList);

    List<WordForStudyDto> listWordInWordDtoList(List<WordForStudy> wordDtoList);
}
