package dao;

import domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer userId);

    @Select("select * from user where id=#{id}")
    User findById(Integer userId);

    //@Select("select * from user where username like #{username}")
    @Select("select * from user where username like '%${value}%'")
    List<User> findUserByName(String username);

    @Select("select count(*) from user")
    int findTotalUser();
}
