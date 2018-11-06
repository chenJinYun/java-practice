package servlet;

import bean.User;
import manager.UserManager;
import manager.UserManagerImpl;
import util.UserUtil;

import javax.rmi.CORBA.Util;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Create by UserServlet on 7/11/2018
 */
@WebServlet(value = "/user", initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})
public class UserServlet extends HttpServlet {

    private String encoding;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        encoding = config.getInitParameter("encoding");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(encoding);
        String name = req.getParameter("name");
        String passWord = req.getParameter("passWord");
        String birthString = req.getParameter("birth");
        String major = req.getParameter("major");
        if (name != null && passWord != null && birthString != null && major != null) {
            Date birth = null;
            try {
                birth = UserUtil.format.parse(birthString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            User user = new User(name, passWord, birth, major);
            UserManager manager = new UserManagerImpl();
            manager.addUser(user);
            req.getRequestDispatcher("/userforward").forward(req, resp);
        } else {
            resp.getWriter().write("参数错误");
        }
    }

}
