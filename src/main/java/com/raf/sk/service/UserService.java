package com.raf.sk.service;

import com.raf.sk.dto.TokenRequestDto;
import com.raf.sk.dto.TokenResponseDto;
import com.raf.sk.dto.UserCreateDto;
import com.raf.sk.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserDto> findAll();

    UserDto findById(Integer id);

    UserDto add(UserCreateDto userCreateDto);

    void deleteById(Integer id);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);

    UserDto updateNumberOfReservations(Integer number);

    UserDto editUser(String authorization,UserCreateDto userCreateDto);
}
