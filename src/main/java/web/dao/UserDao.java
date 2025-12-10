package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    User findById(Long id);
    List<User> findAll();
    User save(User user);
    User update(User user);
    void delete(Long id);
}
