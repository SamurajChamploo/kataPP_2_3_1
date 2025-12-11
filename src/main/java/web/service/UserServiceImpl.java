package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User createUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User updateUser(Long id, String firstName, String lastName, String email, Integer age, String city) {
        User existingUser = getUserById(id);

        existingUser.setFirstName(firstName);
        existingUser.setLastName(lastName);
        existingUser.setEmail(email);
        existingUser.setAge(age);
        existingUser.setCity(city);

        return userDao.update(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.delete(id);
    }

}
