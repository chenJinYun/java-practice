package servlet;

import bean.User;
import manager.UserManager;
import manager.UserManagerImpl;
import xml.DomProcessor;
import xml.DomProcessorWithDom4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Create by UserServlet on 7/11/2018
 */
@WebServlet(value = "/userforward", initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})
public class UserForwardServlet extends HttpServlet {
    private String encoding;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        encoding = config.getInitParameter("encoding");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Content-Type", "text/html;charset=" + encoding);
        resp.setCharacterEncoding(encoding);
        UserManager userManager = new UserManagerImpl();
        List<User> users = userManager.findAllUsers();
        DomProcessor processor = new DomProcessorWithDom4j();
        processor.usersToHtml(users, resp.getWriter());
    }

}
