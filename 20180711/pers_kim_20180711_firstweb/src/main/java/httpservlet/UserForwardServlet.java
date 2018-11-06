package httpservlet;

import datalist.User;
import readerxml.DomProcessor;
import readerxml.DomProcessorWithDom4j;
import usermanager.UserManager;
import usermanager.UserManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserForwardServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();//维持会话
        if((String) session.getAttribute("uname")==null){ //维持会话)
            session.setAttribute("username",req.getParameter("username"));
            session.setAttribute("pwd",req.getParameter("pwd"));
            session.setAttribute("major",req.getParameter("major"));
            session.setAttribute("birth",req.getParameter("birth"));
            resp.sendRedirect("login.html");
            return;
        }
        resp.setHeader("Content-Type","text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        UserManager user=new UserManagerImpl();
        List<User> useList=user.findAllUser();
        DomProcessor dp=new DomProcessorWithDom4j();
        dp.userToHtml(useList,resp.getWriter());
    }
}
