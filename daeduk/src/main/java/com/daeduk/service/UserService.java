package com.daeduk.service;

import com.daeduk.dto.UserDto;

public interface UserService {

    public Boolean confirmLogin(String email, String password);

    public UserDto findPassword(String email);

    public Boolean signup(String email, String password);

    public Boolean checkDuplEmail(String email);
}
