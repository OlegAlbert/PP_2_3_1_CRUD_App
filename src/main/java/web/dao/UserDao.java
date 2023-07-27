package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    void delete(Long id);

    void update(User user, Long id);

    User get(Long id);

    List<User> listUsers();


}
