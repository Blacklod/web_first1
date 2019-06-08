package com.ystu.web_first.servlets;

import com.ystu.web_first.entities.Order;
import com.ystu.web_first.model.Model;
import com.ystu.web_first.spring.SpringConfigContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopServlet extends HttpServlet {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigContext.class);
    List<Long> ArrayIdCar = new ArrayList<Long>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List list = context.getBean(List.class);
        req.setAttribute("list", list);

        Long id =  (Long) req.getSession().getAttribute("idUser");

        if (id == null) {
            resp.sendRedirect("/hello");
        }
        else {
            ArrayList<Order> or = new ArrayList<Order>();
            if (req.getSession().getAttribute("ArrayIdCar2") == null){
                req.getRequestDispatcher("/jsp/shop.jsp").forward(req, resp);
            }
            else{
                List<Long> KorzAdd=  (List) req.getSession().getAttribute("ArrayIdCar2");
                req.getSession().setAttribute("ArrayIdCar2",KorzAdd);
                long id2 = id;
                or.add(new Order(1,id2,KorzAdd));
                Model.getInstance().setOrders(or);
                req.getRequestDispatcher("jsp/shop.jsp").forward(req, resp);
            }
        }

    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //resp.sendRedirect("/shop");
        List list = context.getBean(List.class);
        req.setAttribute("list", list);

        ArrayList<Order> or = new ArrayList<Order>();
        List<Long> Korz = new ArrayList<Long>();

        Long id =  (Long) req.getSession().getAttribute("idUser");
        long id2 = id;

        //if(!ref) {

            Korz = Model.getInstance().getOrderByUser(id).getCars();

            if (req.getSession().getAttribute("ArrayIdCar2") == null && Korz.size()==0){
                List<Long> KorzPust = new ArrayList<Long>();
                String name = req.getParameter("button");
                KorzPust.add(Long.parseLong(name));
                req.getSession().setAttribute("ArrayIdCar2",KorzPust);
                Korz = KorzPust;
            }
            else{
                if (req.getSession().getAttribute("ArrayIdCar2") == null) {
                    List<Long> KorzAdd=Korz;
                    String name = req.getParameter("button");
                    KorzAdd.add(Long.parseLong(name));
                    req.getSession().setAttribute("ArrayIdCar2",KorzAdd);
                    Korz = KorzAdd;
                }
                else{
                    List<Long> KorzAdd=  (List) req.getSession().getAttribute("ArrayIdCar2");
                    String name = req.getParameter("button");
                    KorzAdd.add(Long.parseLong(name));
                    req.getSession().setAttribute("ArrayIdCar2",KorzAdd);
                    Korz = KorzAdd;
                }
            }

            or.add(new Order(1,id2,Korz));
            Model.getInstance().setOrders(or);
            resp.sendRedirect("/shop");
            //req.getRequestDispatcher("jsp/shop.jsp").forward(req, resp);

    }
}
