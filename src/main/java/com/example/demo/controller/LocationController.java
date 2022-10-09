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
    public double latname = 37.552128 ;
    public double lntname = 126.9661696;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");

        latname = Double.parseDouble(req.getParameter("latname"));
        System.out.println(latname);

        lntname = Double.parseDouble(req.getParameter("lntname"));
        System.out.println(lntname);

        req.setAttribute("latname", latname);
        req.setAttribute("lntname", lntname);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);

    }

    public static void main(String[] args) {

        LocationController t = new LocationController();
        System.out.println(t.latname);
        System.out.println(t.lntname);
    }
}
