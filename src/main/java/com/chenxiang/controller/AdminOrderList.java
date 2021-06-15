package com.chenxiang.controller;

import com.chenxiang.dao.OrderDao;
import com.chenxiang.model.Order;
import com.chenxiang.model.Payment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/admin/orderList")
public class AdminOrderList extends HttpServlet {
    private Connection con = null;
    public void destroy() {
        super.destroy();
    }

    public void init() throws ServletException {
         con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Payment> paymentTypetList=Payment.findAllPayment(con);
        request.setAttribute("paymentTypeList",paymentTypetList);
        OrderDao orderDao=new OrderDao();
        List<Order> orderList=orderDao.findAll(con);
        request.setAttribute("orderList",orderList);
        String path="/WEB-INF/views/admin/orderList.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
