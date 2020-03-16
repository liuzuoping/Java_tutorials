package dao.impl;

import dao.IUserDao;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }

    public List<User> findAll() {
        SqlSession session=factory.openSession();
        List<User> users = session.selectList("dao.IUserDao.findAll");
        session.close();
        return users;
    }

    public void saveUser(User user) {
        SqlSession session=factory.openSession();
        session.insert("dao.IUserDao.saveUser",user);
        session.commit();
        session.close();
    }

    public void updateUser(User user) {
        SqlSession session=factory.openSession();
        session.update("dao.IUserDao.updateUser",user);
        session.commit();
        session.close();
    }

    public void deleteUser(Integer userId) {
        SqlSession session=factory.openSession();
        session.delete("dao.IUserDao.deleteUser",userId);
        session.commit();
        session.close();
    }

    public User findById(Integer userId) {
        SqlSession session=factory.openSession();
        User user = session.selectOne("dao.IUserDao.findById",userId);
        session.close();
        return user;
    }

    public List<User> findByName(String username) {
        SqlSession session=factory.openSession();
        List<User> users = session.selectList("dao.IUserDao.findByName",username);
        session.close();
        return users;
    }

    public int findTotal() {
        SqlSession session=factory.openSession();
        Integer count = session.selectOne("dao.IUserDao.findTotal");
        session.close();
        return count;
    }
}
