package com.example.demo.controller;

import com.example.demo.dao.HistoryDao;


import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/history.do")
public class HistoryController extends HttpServlet {
    public void service (HttpServletRequest request, HttpServletResponse response) {
        HistoryDao historyDao = new HistoryDao();
        historyDao.save();

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/history.jsp");

    }
}
