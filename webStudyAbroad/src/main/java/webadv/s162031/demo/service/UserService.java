package webadv.s162031.demo.service;

import webadv.s162031.demo.entity.User;

import java.util.List;

public interface UserService {
    User findById(long i);

    void addUser(User user);

    User findByAccountAndPassword(String account, String password);
    List<User> findAll();

    void  updataByID(User userInfo);

    void deleteUserInfo(Long id);

}
