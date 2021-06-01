package com.chenxiang.controller;

import com.chenxiang.dao.ProductDao;
import com.chenxiang.model.Item;
import com.chenxiang.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);//get existing session,not create a new one
        if (session != null && session.getAttribute("user") != null) {
            {
            if (request.getParameter("action") == null) {
                displayCart(request, response);
            } else if (request.getParameter("action").equals("add")) {
                try {
                    buy(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } else if (request.getParameter("action").equals("remove")) {
                remove(request, response);
            }
        }
        } else {
            response.sendRedirect("login");
        }
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session =request.getSession();
        List<Item> cart= (List<Item>) request.getSession().getAttribute("cart");
        int id=0;
        if(request.getParameter("productId")!=null){
            id=Integer.parseInt(request.getParameter("productId"));
        }
        int index=isExisting(id,cart);
        cart.remove(index);
        request.getSession().setAttribute("cart",cart);
        response.sendRedirect(request.getContextPath()+"/cart");
    }

    private void buy(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        HttpSession session = request.getSession();
        int id = request.getParameter("productId") != null ? Integer.parseInt(request.getParameter("productId")) : 0;
        int quantity = request.getParameter("quantity") != null ? Integer.parseInt(request.getParameter("quantity")) : 0;
        ProductDao productDao = new ProductDao();
        if (session.getAttribute("cart") == null) {
            List<Item> cart = new ArrayList<Item>();
            Product p = productDao.findById(id,con);
            cart.add(new Item(p,quantity));
            session.setAttribute("cart",cart);
        }else{
            List<Item> cart=(List<Item>) request.getSession().getAttribute("cart");
            int index = isExisting(id,cart);
            if(index == -1){
                Product p=productDao.findById(id,con);
                cart.add(new Item(p,1));
            }else{
                int Quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(Quantity);
            }
            session.setAttribute("cart",cart);
        }
        response.sendRedirect(request.getContextPath()+"/cart");//update-add
    }

    private int isExisting(int id, List<Item> cart) {
        for(int i=0;i<cart.size();i++){
            if(cart.get(i).getProduct().getProductId()==id)
            {
                return i;
            }
        }
        return -1;
    }

    private void displayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message","Your Cart");
        request.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
