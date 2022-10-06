package com.example.demo.controller;

import com.example.demo.dao.HistoryDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;

@WebServlet("/history.do")
public class HistoryController extends HttpServlet {
    public void service (HttpServletRequest request, HttpServletResponse response) {
        HistoryDao historyDao = new HistoryDao();
        historyDao.save();

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/history.jsp");

    }
}
