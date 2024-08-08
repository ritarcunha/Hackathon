package io.codeforall.vimtages.services;

import io.codeforall.vimtages.model.User;

public interface LoginService {

    User getUserByUsernameAndPassword(String username, String password);
}
