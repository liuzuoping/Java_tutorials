package dao;

import domain.QueryVo;
import domain.User;

import javax.management.Query;
import java.util.List;

public interface IUserDao {
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer userId);
    User findById(Integer userId);
    List<User> findByName(String username);
    int findTotal();
    List<User> findUserByVo(QueryVo vo);
}
