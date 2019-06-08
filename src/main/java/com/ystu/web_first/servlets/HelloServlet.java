package com.ystu.web_first.servlets;

import com.ystu.web_first.entities.User;
import com.ystu.web_first.model.Model;
import com.ystu.web_first.spring.SpringConfigContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jerde on 07.04.2017.
 */
public class HelloServlet extends HttpServlet {

    //ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigContext.class);
    Long idUs = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("login");
        String pass = req.getParameter("pass");

        idUs = Model.getInstance().getIdUserByLogPas(name,pass);
        Long id =  (Long) req.getSession().getAttribute("idUser");

        if (id != null) {
            resp.sendRedirect("hello");
        } else {
        if (!Model.getInstance().getLogin(name, pass)) {
            req.getSession().setAttribute("idUser",idUs);
            req.getSession().setAttribute("userName",name);
            getServletContext().getRequestDispatcher("/jsp/shop.jsp").forward(req,resp);
        }
        else {
            if (name != null && pass != null){
                req.setAttribute("msgAut","Неверный логин или пароль");
            }
            req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
        }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
