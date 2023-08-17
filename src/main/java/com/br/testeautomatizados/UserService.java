package com.br.testeautomatizados;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> users = new ArrayList<>();

    public List<User> create(User user) {
        if (isUsernameAlreadyInUse(user))
            throw new RuntimeException();

        users.add(user);
        return users;
    }

    private boolean isUsernameAlreadyInUse(User newUser) {
        return users.stream()
                .filter(user -> user.username().equals(newUser.username()))
                .findAny()
                .isPresent();
    }
}
