package com.raf.sk.controller;

import com.raf.sk.dto.TokenRequestDto;
import com.raf.sk.dto.TokenResponseDto;
import com.raf.sk.dto.UserCreateDto;
import com.raf.sk.dto.UserDto;
import com.raf.sk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserCreateDto userCreateDto){
        return new ResponseEntity<>(userService.add(userCreateDto),HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> loginUser(@RequestBody TokenRequestDto tokenRequestDto) {
        return new ResponseEntity<>(userService.login(tokenRequestDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@RequestHeader("Authorization") String authorization, @PathVariable("id") Integer id){
        return new ResponseEntity<UserDto>(userService.findById(id), HttpStatus.OK);
    }
    @PutMapping("/updateNumberOfReservations")
    public ResponseEntity<UserDto> updateNumberOfReservations(@RequestBody Integer numberOfRes){
        return new ResponseEntity<>(userService.updateNumberOfReservations(numberOfRes),HttpStatus.OK);
    }

}
