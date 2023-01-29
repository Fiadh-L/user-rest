package io.wdevstudy.rest.store;

import io.wdevstudy.rest.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

public interface UserStore {

    String create(User newUser);
    void update(User newUser);
    void delete(String id);

    User retrieve(String id);
    List<User> retrieveAll();
}
