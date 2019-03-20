package controller;

import model.Demo;
import service.DemoTwoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DemoTwoController extends HttpServlet {

    private DemoTwoService demoService = new DemoTwoService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("request:    "+req.getRealPath("/"));
        String method = req.getParameter("method");
        if("getList1".equals(method)){
            List<Demo> demoList = demoService.getDemoList();
            req.setAttribute("list", demoList);
            req.getRequestDispatcher("jsp/form.jsp").forward(req, res);
        }

    }


}
