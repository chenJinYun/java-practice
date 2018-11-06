package httpservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type","text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        String name=req.getParameter("username");
        String pwd=req.getParameter("pwd");
        HttpSession session=req.getSession();
        if(name.equals("张三")&&pwd.equals("123")){
            session.setAttribute("uname",name);
            req.setAttribute("username",session.getAttribute("username"));
            req.setAttribute("pwd",session.getAttribute("pwd"));
            req.setAttribute("major",session.getAttribute("major"));
            req.setAttribute("birth",session.getAttribute("birth"));
            req.getRequestDispatcher("user").forward(req,resp);
        } else{
            resp.getWriter().write("账户名或者密码错误！");
        }
    }
}
