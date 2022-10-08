package com.example.demo.controller;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/location.do")
public class LocationController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");

        double latname = Double.parseDouble(req.getParameter("latname"));
        System.out.println(latname);

        double lntname = Double.parseDouble(req.getParameter("lntname"));
        System.out.println(lntname);

        req.setAttribute("latname", latname);
        req.setAttribute("lntname", lntname);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);

    }
}
