package com.daeduk.service;

public interface UserService {

    public Boolean confirmLogin(String email, String password);

    public Boolean signup(String email, String password);
}
