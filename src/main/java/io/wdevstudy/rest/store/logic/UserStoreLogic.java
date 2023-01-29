package io.wdevstudy.rest.store.logic;

import io.wdevstudy.rest.entity.User;
import io.wdevstudy.rest.store.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserStoreLogic implements UserStore {

    private Map<String, User> userMap;

    public UserStoreLogic(){
        this.userMap = new HashMap<>();
    }

    @Override
    public String create(User newUser) {
        this.userMap.put(newUser.getId(), newUser);
        return newUser.getId();
    }

    @Override
    public void update(User newUser) {
        this.userMap.put(newUser.getId(), newUser);
    }

    @Override
    public void delete(String id) {
        this.userMap.remove(id);
    }

    @Override
    public User retrieve(String id) {
        return this.userMap.get(id);
    }

    @Override
    public List<User> retrieveAll() {

        return this.userMap.values().stream().collect(Collectors.toList());
    }
}
