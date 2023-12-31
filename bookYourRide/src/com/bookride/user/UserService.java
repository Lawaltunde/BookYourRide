package com.bookride.user;

import java.util.UUID;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public User[] getUsers() {
        return userDAO.getUsers();
    }

    public User getUserById(UUID userId) {

        for (User getUser : getUsers()) {
            if(getUser.getId().equals(userId)){
                return getUser;
            }
        }
        throw new IllegalStateException(String.format("User with Id %s not available", userId));
    }
}
