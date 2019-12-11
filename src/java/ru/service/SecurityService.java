package ru.service;

public interface SecurityService {
    String finaLoggerInuser();
    void autoLogin( String username, String password);
}
