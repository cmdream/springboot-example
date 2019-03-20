package mapper;

import model.Demo;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DemoTwoMapper {
    public List<Demo> getDemoList() {
        List<Demo> list = new ArrayList<Demo>();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            pre = connection.prepareStatement("select * from sfpt_zc_wjsb where zhcq = ?");
            pre.setString(1, "110109");
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Demo(rs.getString(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pre,connection);
        }
        return list;
    }

    /**
     * 查询
     */
    public List<Demo> queryList(String sblx) {
        List<Demo> list = new ArrayList<>();
        String sql = "select * from sfpt_zc_wjsb where sblx = " + sblx;
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            pre = connection.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Demo(rs.getString(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pre, connection);
        }
        return list;
    }
    /**
     * 更新
     */
    public void updateData(String sblx) {
        String sql = "update sfpt_zc_wjsb set sblx = ? where zhcq = '110109'";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement pre = null;
        try {
            pre = connection.prepareStatement(sql);
            pre.setString(1, sblx);
            pre.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null, pre, connection);
        }
    }
    /**
     * 插入example
     */
    public void saveZhcqData(){
        /*
        <insert id="insertStudent" parameterType="com.czd.mybatis01.bean.Student">
            INSERT stu(name)VALUES (#{name})
            <selectKey keyProperty="id" order="AFTER" resultType="java.lang.Integer">
                SELECT LAST_INSERT_ID()
            </selectKey>
        </insert>

        SELECT LAST_INSERT_ID():得到刚 insert 进去记录的主键值，只适用与自增主键
        keyProperty：将查询到主键值设置到 parameterType 指定的对象的那个属性
        order：SELECT LAST_INSERT_ID() 执行顺序，相对于 insert 语句来说它的执行顺序
        resultType：指定 SELECTLAST_INSERT_ID() 的结果类型
         */
        String sql = "SELECT LAST_INSERT_ID()";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement pre = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String zhcq = "111111";
        try {
            ps =  connection.prepareStatement("insert into ipole_zhcq set zhcq='"+zhcq+"',zhcqmc='11111',zhcqjc='11',xzqh='1111',cqh='000000000000',cqlx='1'");
//            ps.setTimestamp(1, new Timestamp(new Date().getTime()));
            ps.executeUpdate();
            ps.close();

            pre = connection.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pre, connection);
        }
    }

}
