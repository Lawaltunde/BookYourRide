package com.bookride.user;

import java.util.UUID;

public class UserDAO {
    private static final User[] users;

    static {
            users = new User[]{
                    new User(UUID.fromString("d7e79eed-8128-46d9-b911-6e8980925b92"), "Olatunde"),
                    new User(UUID.fromString("230c8a5b-827f-4b61-8f08-3c5769eb25a0"), "Lawal")
            };
    }
    public User[] getUsers(){
        return users;
    }
}
