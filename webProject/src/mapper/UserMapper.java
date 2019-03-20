package mapper;

import model.User;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    /**
     * limit、翻页
     */
    public List<User> queryLimitData(int i, int pageSize) {
        List<User> list = new ArrayList<>();
        String sql1 = "select * from sfpt_zc_wjsb where zhcq = '110109' limit ?";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement pre1 = null;
        ResultSet rs1 = null;

        String sql2 = "select * from sfpt_zc_wjsb where zhcq = '110109' limit ?, ?";
        PreparedStatement pre2 = null;
        ResultSet rs2 = null;
        try {
            //取前i行数据
            pre1 = connection.prepareStatement(sql1);
            pre1.setInt(1, i);
            rs1 = pre1.executeQuery();
            while (rs1.next()) {
                list.add(new User("limit1", rs1.getInt(1)));
            }
            rs1.close();
            pre1.close();

            //取从i行开始，pageSize条数据
            pre2 = connection.prepareStatement(sql2);
            pre2.setInt(1, i);
            pre2.setInt(2, pageSize);
            rs2 = pre2.executeQuery();
            while (rs2.next()) {
                list.add(new User("limit2", rs2.getInt(1)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs2, pre2, connection);

        }
        return list;

    }
    /**
     * description 表中数据条数
     * @return 总数
     */
    public int getTableCount() {
        String sql = "select count(1) from sfpt_zc_wjsb where zhcq = '110109'";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        int count = 0;
        try {
            pre = connection.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pre, connection);
        }
        return count;
    }

}
