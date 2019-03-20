package controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AnotherServletController extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException{
        System.out.println("2 servlet初始化。。。。。。。。。。。");
    }
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        HttpServletRequest hsr = (HttpServletRequest) request;
        String servletPath = hsr.getServletPath();
        System.out.println("TestServlet service ...|| servletPath:" + servletPath);
    }
}
