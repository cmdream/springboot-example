package controller;

import com.alibaba.fastjson.JSON;
import model.Demo;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OperationServletController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if("xmlHttpRequestJson".equals(method)) {
            xmlHttpRequestJson(request, response);
        }else if("xmlHttpRequestText".equals(method)) {
            xmlHttpRequestText(request, response);
        }

//        response.sendRedirect(request.getContextPath()+"/list.jsp");//重定向
        /**
         * session
         */

        /*ServletContext app = request.getServletContext();//在servlet中拿到application
        app.setAttribute("age", 15);
        app.removeAttribute("age");
        HttpSession session = request.getSession();
        session.setAttribute("name", "花花");
        session.invalidate();//session的销毁，调用了remove方法
//        session.setAttribute("name", "哒哒");
        request.getRequestDispatcher("jsp/form.jsp").forward(request, response);*/

        /**
         * upload 上传
         */
        /*request.setCharacterEncoding("UTF-8");
        //创建磁盘文件工厂
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        //建立servlet上传核心文件
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        upload.setHeaderEncoding("UTF-8");
        try {
            List<FileItem> list = upload.parseRequest(request);
            if(null!=list&&list.size()>0){
                for(FileItem fileItem : list){
                    if(fileItem.isFormField()){
                        System.out.println(fileItem.getFieldName()+"----"+fileItem.getString());
                    }else{
                        String realPath = this.getServletContext().getRealPath("/upload.jsp");
                        String name = fileItem.getName();
                        String randomUUID = UUID.randomUUID().toString().replace("-", "")+name.substring(name.lastIndexOf("."), name.length());
                        File file = new File(realPath);
                        if(file.exists()){
                            file.mkdirs();
                        }
                        try {
                            fileItem.write(new File(file, randomUUID));
                        } catch (Exception e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
//					String name = fileItem.getName();//获得上传文件的名称
//					File file = new File("d:"+File.separator+name);
//					System.out.println(file);
                        try {
                            fileItem.write(file);
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }



                    }
                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }*/

        /**
         * download 下载
         */
        /*String realPath = request.getServletContext().getRealPath("upload");
        FileInputStream fileInputStream = new FileInputStream(new File(realPath,"我.jpg"));
        response.setHeader("content-disposition", "attachment;fileName="+new String("我.jpg".getBytes(),"ISO8859-1"));
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] len=new byte[1024];
        int read = fileInputStream.read();
        while(read!=-1){
            outputStream.write(len,0,read);
            read=fileInputStream.read(len);
        }
        outputStream.close();
        fileInputStream.close();*/


    }
    public void xmlHttpRequestJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        List<User> personList=new ArrayList<>();
        personList.add(new User("小花", 3));
        personList.add(new User("小草", 6));
        personList.add(new User("小胡", 4));
        personList.add(new User("小空", 9));
        personList.add(new User("小偶", 2));
        String str = JSON.toJSONString(personList);
        response.getWriter().write(str);
    }
    public void xmlHttpRequestText(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String name=request.getParameter("text");
        if("小花".equals(name)){
            response.getWriter().write("error");
        }else{
            response.getWriter().write("success");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}
