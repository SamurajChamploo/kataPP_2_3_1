package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    List<User> getAllUsers();
    User createUser(User user);
    User updateUser(Long id, String firstName, String lastName, String email, Integer age, String city);
    void deleteUser(Long id);
}
