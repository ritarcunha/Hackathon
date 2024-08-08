package io.codeforall.drunkers.services;

import io.codeforall.drunkers.model.User;

public interface LoginService {

    User getUserByUsernameAndPassword(String username, String password);
}
