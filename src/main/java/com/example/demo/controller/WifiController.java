package com.example.demo.controller;

import com.example.demo.dao.WifiDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/wifi.do")
public class WifiController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {

        WifiDao wifiDao = new WifiDao();
        wifiDao.delete();
        String totalCount = wifiDao.save();


        request.setAttribute("totalCount", totalCount);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/dataLoad.jsp");
        requestDispatcher.forward(request, response);
    }


}
