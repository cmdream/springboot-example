package service;

import mapper.UserMapper;
import model.User;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserService {

    private UserMapper userMapper = new UserMapper();

    /**
     * limit、翻页
     */
    public List<User> queryLimitData(int i, int pageSize) {
        return userMapper.queryLimitData(i, pageSize);
    }
    /**
     * 表中数据总条数
     */
    public int getTableCount() {
        return userMapper.getTableCount();
    }

}
