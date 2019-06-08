package com.ystu.web_first.servlets;

import com.ystu.web_first.entities.User;
import com.ystu.web_first.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddServlet extends HttpServlet {

    Long id = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //PrintWriter writer = resp.getWriter();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/add.jsp");
        requestDispatcher.forward(req, resp);
        //writer.println("Method GET from AddServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        long id = Model.getInstance().getSizeCustomers();

        id++;
        User user = new User(name, password, id);
        Model model = Model.getInstance();
        model.add(user);

        req.setAttribute("userName", name);
        req.setAttribute("idUser", id);
        doGet(req, resp);
    }
}
