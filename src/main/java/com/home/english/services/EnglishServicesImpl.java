package com.home.english.services;

import com.home.english.dao.WordForStudy;
import com.home.english.dto.UsersDto;
import com.home.english.dto.WordForStudyDto;
import com.home.english.mapper.UsersMapper;
import com.home.english.mapper.WordsMapper;
import com.home.english.repository.UserRepository;
import com.home.english.repository.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class EnglishServicesImpl implements EnglishServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WordsRepository wordsRepository;

    @Autowired
    private WordsMapper wordsMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public WordForStudyDto getWordForStudyDto(Long id) {
        List<WordForStudy> allById = wordsRepository.findAllById(id).stream()
                .filter(wordForStudy -> wordForStudy.getSuccessCounter() < 3)
                .collect(Collectors.toList());
        return wordsMapper
                .wordInWordDto(allById.get(ThreadLocalRandom.current().nextInt(0, allById.size() - 1)));
    }

    @Override
    public UsersDto getUsersDto(Long id) {
        return usersMapper.usersInUsersDto(userRepository.findById(id).get());
    }

    @Override
    public void addWord(WordForStudyDto wordDto) {
        wordsRepository.save(wordsMapper.wordDtoInWord(wordDto));
    }

    @Override
    public void addUser(UsersDto usersDto) {
        userRepository.save(usersMapper.usersDtoInUsers(usersDto));
    }

    @Override
    public void checkWord(WordForStudyDto wordDto) {
        wordsRepository.save(wordsMapper.wordDtoInWord(wordDto));
    }
}