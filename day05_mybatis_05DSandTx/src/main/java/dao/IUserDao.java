package dao;

import domain.QueryVo;
import domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
    User findById(Integer userId);
    List<User> findByName(String username);
    List<User> findUserByVo(QueryVo vo);
    List<User> findUserByCondition(User user);
    List<User> findUserInIds(QueryVo vo);
}
