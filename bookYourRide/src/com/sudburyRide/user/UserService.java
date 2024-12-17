package com.sudburyRide.user;

import java.util.UUID;

public class UserService {
    private final UserDAO userDAO = new UserDAO();


    public User[] getAllUsers(){
        if (userDAO.getUsers().length == 0){
            return new User[0];
        }
        return userDAO.getUsers();
    }

    public User getUser(UUID id){
        for (User user : getAllUsers()) {
            if(user.getId().equals(id)){
                return user;
            }
        }
        throw new IllegalArgumentException("User id can't be null!");
    }
}
