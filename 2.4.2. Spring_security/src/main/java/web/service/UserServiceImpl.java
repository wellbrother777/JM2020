package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDaoImpl;

    public UserServiceImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    @Transactional
    public Optional<User> findUserByUserName(String userName) {
        return userDaoImpl.findByUserName(userName);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return userDaoImpl.getUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDaoImpl.addUser(user);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDaoImpl.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(long id) {
        return userDaoImpl.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userDaoImpl.deleteUser(id);
    }
}
