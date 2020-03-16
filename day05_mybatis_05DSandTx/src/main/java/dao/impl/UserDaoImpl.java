package dao.impl;

import dao.IUserDao;
import domain.QueryVo;
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

    public List<User> findUserByVo(QueryVo vo) {
        return null;
    }

    public List<User> findUserByCondition(User user) {
        SqlSession session=factory.openSession();
        List<User> users = session.selectList("dao.IUserDao.findUserByCondition",user);
        session.close();
        return users;
    }

    public List<User> findUserInIds(QueryVo vo) {
        SqlSession session=factory.openSession();
        List<User> users = session.selectList("dao.IUserDao.findUserInIds",vo);
        session.close();
        return users;
    }


}
