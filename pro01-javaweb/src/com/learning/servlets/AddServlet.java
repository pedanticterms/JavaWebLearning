package com.learning.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get parameters from client
        // post 方式下,设置编码,防止中文乱码
        request.setCharacterEncoding("UTF-8");
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = request.getParameter("fcount");
        int fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");

        // print value of parameter
        System.out.println("fname = " + fname + ", price = " + price +
                ", fcount = " + fcount + ", remark = " + remark);
    }
}
