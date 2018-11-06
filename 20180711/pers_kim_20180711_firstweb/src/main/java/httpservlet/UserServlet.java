package httpservlet;

import datalist.User;
import usermanager.UserManager;
import usermanager.UserManagerImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserServlet extends javax.servlet.http.HttpServlet {
    private String encoding;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        encoding=config.getInitParameter("encoding");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.getWriter().write(encoding);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding(encoding);
        resp.setHeader("Content-Type","text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        String username= req.getParameter("username");
        String pwd= req.getParameter("pwd");
        String major= req.getParameter("major");
        String birth= req.getParameter("birth");
        HttpSession session=req.getSession();//维持会话
        System.out.println(req.getAttribute("username")!=null && req.getParameter("birth")==null);
        if((String) session.getAttribute("uname")==null){ //维持会话)
            session.setAttribute("username",username);
            session.setAttribute("pwd",pwd);
            session.setAttribute("major",major);
            session.setAttribute("birth",birth);
            resp.sendRedirect("login.html");
            return;
        } else if(req.getAttribute("username")!=null && req.getParameter("birth")==null) {
            username= (String) req.getAttribute("username");
            pwd= (String) req.getAttribute("pwd");
            major= (String) req.getAttribute("major");
            birth= (String) req.getAttribute("birth");
        }
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        if(username!=null&&pwd!=null&&major!=null&&birth!=null){
            UserManager dp=new UserManagerImpl();
            User u=null;
            try {
                u=new User(username,pwd,major,format.parse(birth));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            dp.addUser(u);
            req.getRequestDispatcher("userforward").forward(req,resp);
        }else{
            resp.getWriter().write("请求参数错误！");
        }

    }
}
