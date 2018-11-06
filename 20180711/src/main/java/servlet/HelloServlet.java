package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet(value = "/hello",loadOnStartup = 1,initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})
public class HelloServlet extends HttpServlet {
    private String encoding;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        encoding = config.getInitParameter("encoding");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
//        请求转发
        req.setAttribute("name",name);
        req.setAttribute("price",price);
        req.getRequestDispatcher("servlet/forwardServlet.java").forward(req, resp);
//
//        resp.getOutputStream().write("hello Vic".getBytes());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", "text/html;charset=" + encoding);
        resp.setCharacterEncoding(encoding);
        resp.getWriter().write("你好，Tom");
    }
}
