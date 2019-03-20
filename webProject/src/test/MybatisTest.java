package test;

import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    private SqlSessionFactory sessionFactory;

    @Test
    public void test1() throws IOException{
        InputStream in = Resources.getResourceAsStream("sqlConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = build.openSession();
        List<User> userList = session.selectList("test.findAll");
        for (User user : userList) {
            System.out.println(user);
        }
        session.commit();
        session.close();

    }
    @Before
    public void demo() throws IOException{
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建SqlSessionFactory
        sessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
    }
    //根据id查询
    @Test
    public void test0() throws IOException{
        //调用SqlSession的CUID
        //第一个参数：表示statement的唯一标识
        //第二个参数：参数
        SqlSession session = sessionFactory.openSession();
        User user = session.selectOne("test.findUserById", 2);

        System.out.println(user);
        //关闭资源
        session.close();
    }
    //查询所有
    @Test
    public void test2(){
        SqlSession session = sessionFactory.openSession();
        List<User> userList = session.selectList("test.findAll");
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();
    }
    //查询count
    @Test
    public void test3() throws IOException{
        SqlSession session = sessionFactory.openSession();
        int count = session.selectOne("test.count");
        System.out.println(count);
        session.close();
    }
    //模糊查询
    @Test
    public void test4() throws IOException{
        SqlSession session = sessionFactory.openSession();
        List<User> userList = session.selectList("test.getMohu","哈哈");
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();
    }
    //根据id查询
    @Test
    public void test5() throws IOException{
        SqlSession session = sessionFactory.openSession();
        List<User> userList = session.selectList("test.getUserById",new User(2, null, 0, null));
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();
    }
    //分页查询
    @Test
    public void test6() throws IOException{
        SqlSession session = sessionFactory.openSession();
        List<User> userList = session.selectList("test.getUserListWithPage",new User("1", 2));
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();
    }
    //删除
    @Test
    public void test7() throws IOException {
        SqlSession session = sessionFactory.openSession();
        session.delete("test.deleteById",2);
        session.commit();
        session.close();
    }
    //更新
    @Test
    public void test8() throws IOException{
        SqlSession session = sessionFactory.openSession();
        session.update("test.updateById", new User(4, "丢丢", 12, "ss"));
        session.commit();
        session.close();
    }
    //插入
    @Test
    public void test9() throws IOException{
        SqlSession session = sessionFactory.openSession();
        User user = new User(null, "dada", 33, "dd");
        session.insert("test.insertUser", user);
        System.out.println(user);
        session.commit();
        session.close();
    }
    //插入返回主键
    @Test
    public void test10() throws IOException{
        SqlSession session = sessionFactory.openSession();
        User user = new User(null, "dada", 33, "dd");
        session.insert("test.insertUser1", user);
        System.out.println(user);
        session.commit();
        session.close();
    }

}
