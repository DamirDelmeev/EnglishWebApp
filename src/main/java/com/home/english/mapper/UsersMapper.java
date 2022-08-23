package com.home.english.mapper;

import com.home.english.dao.Users;
import com.home.english.dto.UsersDto;
import org.mapstruct.Mapper;

@Mapper
public interface UsersMapper {
    Users usersDtoInUsers(UsersDto userDto);

    UsersDto usersInUsersDto(Users user);
}
