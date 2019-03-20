package controller;

import com.alibaba.fastjson.JSON;
import model.User;
import service.UserService;
import utils.JDBCUtils;
import utils.PageUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class UserController extends HttpServlet {
    private UserService userService = new UserService();
    /**
     * @deprecated servlet初始化：
     * 1.web.xml中的servlet标签里有个元素load-on-startup,它标记容器是否应该在web应用程序启动时就加载这个servlet，（实例化并调用其init()方法）
     * 2.它的值必须是一个整数，表示servlet被夹在的先后顺序
     * 3.如果该元素的值为负数或者没有设置，则容器会当servlet被请求时再加载
     * 4.如果值为正数或者为0时，表示容器在应用启动时就加载并处世华这个servlet，值越小，servlet的优先级越高，就越先被加载。值相同时，容器就会自己选择顺序来加载
     * 注：每个servlet只初始化一次
     * @param
     * @throws ServletException
     */
    /*@Override
    public void init(ServletConfig request) throws ServletException {
        System.out.println("1  testservelet init .........");
    }*/

    /*@Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        HttpServletRequest hsr = (HttpServletRequest) request;
        String servletPath = hsr.getServletPath();
        System.out.println("TestServlet service ...|| servletPath:" + servletPath);
    }*/
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }

    /**
     * @deprecated HttpServlet在实现Servlet接口时，覆写了service方法，该方法体内的代码会自动判断用户的请求方式，如为GET请求，则调用HttpServlet的doGet方法，如为Post请求，则调用doPost方法。因此，开发人员在编写Servlet时，通常只需要覆写doGet或doPost方法，而不要去覆写service方法。
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String method = req.getParameter("method");
        if("getList".equals(method)){
            getList(req, res);
        }else if("queryLimitData".equals(method)) {
            queryLimitData(req, res);
        }else if("queryPageTurning".equals(method)) {}

    }

    /**
     * @description limit
     * @param request
     * @param response
     */
    public void queryLimitData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("Utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<User> list = userService.queryLimitData(10, 5);
        String str = JSON.toJSONString(list);
        response.getWriter().write(str);
    }

    /**
     * @description 翻页
     * @param req
     * @param res
     */
    public void queryPageTurning(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String page = req.getParameter("page");
        int count=userService.getTableCount();
        int pageSize=2;
        PageUtils pageUtils = new PageUtils(page, count, pageSize);
        List<User> list = userService.queryLimitData((pageUtils.getCurrentPage()-1)*pageSize, pageSize);
        //存放作用域
        HashMap<String, Object> map = new HashMap<>();
        map.put("pageUtils", pageUtils);
        map.put("t_newsList", list);
        res.getWriter().write(JSON.toJSONString(map));

    }

    private void getList(HttpServletRequest req, HttpServletResponse res) {
        res.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");
        PreparedStatement pre=null;
        ResultSet rs=null;
        try {
            PrintWriter out = res.getWriter();
            Connection connection = JDBCUtils.getConnection();
            pre = connection.prepareStatement("select * from sfpt_zc_wjsb");
            rs=pre.executeQuery();
            out.print("<table border='1'>");
            while(rs.next()){
                out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td></tr>");
            }
            out.print("</table");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
