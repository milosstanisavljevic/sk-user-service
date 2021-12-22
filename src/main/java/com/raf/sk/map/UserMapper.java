package com.raf.sk.map;

import com.raf.sk.domain.User;
import com.raf.sk.dto.UserCreateDto;
import com.raf.sk.dto.UserDto;
import com.raf.sk.repository.RankRepository;
import com.raf.sk.repository.RoleRepository;

public class UserMapper {

    private RankRepository rankRepository;
    private RoleRepository roleRepository;

    public UserMapper(RankRepository rankRepository, RoleRepository roleRepository) {
        this.rankRepository = rankRepository;
        this.roleRepository = roleRepository;
    }

    public UserDto userToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setIme(user.getIme());
        userDto.setPrezime(user.getPrezime());
        userDto.setEmail(user.getEmail());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setNumberOfReservations(user.getNumberOfReservations());
        userDto.setRank(user.getRank());
        return userDto;
    }

    public User userCreateDtoToUser(UserCreateDto userCreateDto){
        User user = new User();
        user.setIme(userCreateDto.getIme());
        user.setPrezime(userCreateDto.getPrezime());
        user.setEmail(userCreateDto.getEmail());
        user.setPassword(userCreateDto.getPassword());
        user.setDateOfBirth(userCreateDto.getDateOfBirth());
        user.setNumberOfReservations(userCreateDto.getNumberOfReservations());
        return user;
    }
}
