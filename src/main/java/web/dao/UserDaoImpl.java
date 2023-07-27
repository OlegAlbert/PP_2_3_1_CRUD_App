package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(get(id));
    }

    @Override
    public void update(User user, Long id) {
        User temp = get(id);
        temp.setName(user.getName());
        temp.setAge(user.getAge());
        temp.setEmail(user.getEmail());
        entityManager.merge(temp);
    }

    @Override
    public User get(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("SELECT c FROM User c", User.class)
                .getResultList();
    }
}
