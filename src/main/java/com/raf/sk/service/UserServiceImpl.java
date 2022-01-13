package com.raf.sk.service;


import com.raf.sk.domain.UserRank;
import com.raf.sk.domain.Role;
import com.raf.sk.domain.User;
import com.raf.sk.dto.TokenRequestDto;
import com.raf.sk.dto.TokenResponseDto;
import com.raf.sk.dto.UserCreateDto;
import com.raf.sk.dto.UserDto;
import com.raf.sk.map.UserMapper;
import com.raf.sk.repository.RankRepository;
import com.raf.sk.repository.RoleRepository;
import com.raf.sk.repository.UserRepository;
import com.raf.sk.security.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private RankRepository rankRepository;
    private RoleRepository roleRepository;
    private UserMapper userMapper;
    private TokenService tokenService;

    public UserServiceImpl(UserRepository userRepository, RankRepository rankRepository, RoleRepository roleRepository, UserMapper userMapper, TokenService tokenService) {
        this.userRepository = userRepository;
        this.rankRepository = rankRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.tokenService = tokenService;
    }

    @Override
    public List<UserDto> findAll() {
        List<UserDto> result_list = new ArrayList<UserDto>();

        for (User user : userRepository.findAll()){
            result_list.add(userMapper.userToUserDto(user));
        }

        return result_list;
    }

    @Override
    public UserDto findById(Integer id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto add(UserCreateDto userCreateDto) {
        User user = userMapper.userCreateDtoToUser(userCreateDto);
        UserRank userRank = rankRepository.findByType("Bronze").orElseThrow();
        Role role = roleRepository.findByRoleName("ROLE_USER").orElseThrow();
        user.setUserRank(userRank);
        user.setRole(role);
        userRepository.save(user);
        System.out.println(user.getEmail());

        return userMapper.userToUserDto(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
        System.out.println(tokenRequestDto.getEmail() +"  "+ tokenRequestDto.getPassword());
        User user = userRepository
                .findUserByEmailAndPassword(tokenRequestDto.getEmail(), tokenRequestDto.getPassword())
                .orElseThrow();
        //Create token payload
        Claims claims = Jwts.claims();
        claims.put("id", user.getId());
        claims.put("role", user.getRole().getRoleName());
        //Generate token
        return new TokenResponseDto(tokenService.generate(claims));

    }

    @Override
    public UserDto updateNumberOfReservations(Integer number) {
       return null;
    }

    @Override
    public UserDto editUser(String authorization, UserCreateDto userCreateDto) {
        Claims claims = tokenService.parseToken(authorization.split(" ")[1]);
        int id = claims.get("id", Integer.class);

        User curr_user = userRepository.findById(id).orElseThrow();
        curr_user.setIme(userCreateDto.getIme());
        curr_user.setPrezime(userCreateDto.getPrezime());
        curr_user.setEmail(userCreateDto.getEmail());
        curr_user.setPassword(userCreateDto.getPassword());
        return userMapper.userToUserDto(curr_user);
    }
}
