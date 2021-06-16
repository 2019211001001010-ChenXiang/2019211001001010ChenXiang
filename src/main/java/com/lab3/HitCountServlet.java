package com.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HitCountServlet", value = "/HitCountServlet")
public class HitCountServlet extends HttpServlet {
    private int Count;
    @Override
    public void init() throws ServletException {
        Count = 0;
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Count++;
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<center><h1> Total Number of Hits </h1>");
        out.println("<h1>"+Count+"</h1></center>");
        out.println("</html></body>");
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
