package com.example.demo.controller;

import com.example.demo.dao.WifiDao;
import com.example.demo.dto.MainDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/data-load.do")
public class DataLoadController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {

        MainDto mainDto = new MainDto();
        WifiDao wifiDao = new WifiDao();
        String totalCount = mainDto.getList_total_count();
        wifiDao.save();
        //request.setAttribute("totalCount", mainDto.getList_total_count());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/dataLoad.jsp");
        requestDispatcher.forward(request, response);
    }
}
