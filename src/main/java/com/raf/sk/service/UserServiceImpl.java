package com.raf.sk.service;


import com.raf.sk.dto.TokenRequestDto;
import com.raf.sk.dto.TokenResponseDto;
import com.raf.sk.dto.UserCreateDto;
import com.raf.sk.dto.UserDto;
import com.raf.sk.map.UserMapper;
import com.raf.sk.repository.RankRepository;
import com.raf.sk.repository.RoleRepository;
import com.raf.sk.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private RankRepository rankRepository;
    private RoleRepository roleRepository;
    private UserMapper userMapper;

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public UserDto findById(Integer id) {
        return null;
    }

    @Override
    public UserDto add(UserCreateDto userCreateDto) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
        return null;
    }

    @Override
    public UserDto updateNumberOfReservations() {
        return null;
    }

    @Override
    public UserDto editUser(String authorization, UserCreateDto userCreateDto) {
        return null;
    }
}
