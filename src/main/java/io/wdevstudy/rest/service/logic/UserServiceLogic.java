package io.wdevstudy.rest.service.logic;

import io.wdevstudy.rest.entity.User;
import io.wdevstudy.rest.service.UserService;
import io.wdevstudy.rest.store.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceLogic implements UserService {
    /*
    * 1. autowired 어노테이션을 사용한다.
    * 2. userStore 파라미터를 받는 생성자를 만든다.
    *     public UserServiceLogic( UserStore userStore){
    *         this.userStore = userStore;
    *     }
    * 3. requiredargsconstructor 어노테이션을 올린다. > 생성자가 생긴것으로 간주
    * */
    private final UserStore userStore;

    @Override
    public String register(User newUser) {
        return userStore.create(newUser);
    }

    @Override
    public void modify(User newUser) {
        this.userStore.update(newUser);
    }

    @Override
    public void remove(String id) {
        this.userStore.delete(id);
    }

    @Override
    public User find(String id) {
        return this.userStore.retrieve(id);
    }

    @Override
    public List<User> findAll() {
        return this.userStore.retrieveAll();
    }
}
