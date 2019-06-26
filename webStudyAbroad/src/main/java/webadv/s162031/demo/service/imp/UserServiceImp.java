package webadv.s162031.demo.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webadv.s162031.demo.entity.User;
import webadv.s162031.demo.repository.UserRepository;
import webadv.s162031.demo.service.UserService;

import java.util.List;

/**
 * @author: yjp
 * @date:
 * @description:
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findById(long i) {
        return userRepository.findById(i).orElse(null);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByAccountAndPassword(String account, String password) {
        return userRepository.findByAccountAndPassword(account,password);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void updataByID(User userInfo) {
        userRepository.saveAndFlush(userInfo);
    }

    @Override
    public void deleteUserInfo(Long id) {
        userRepository.deleteById(id);
    }


}
