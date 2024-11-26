package com.example.ontap.Servlet;

import com.example.ontap.Entity.SanPham;
import com.example.ontap.Repository.SanPhamRepo;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxServlet", value = "/AjaxServlet")
public class AjaxServlet extends HttpServlet {
    SanPhamRepo sanPhamRepo = new SanPhamRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("da chay vao api");
        Integer id = Integer.parseInt(request.getParameter("id"));
        SanPham sanPham = sanPhamRepo.detail(id);
        Gson gson= new Gson();
        response.setContentType("application/json");
        String Spjson = gson.toJson(sanPham);
        PrintWriter result = response.getWriter();
        result.print(Spjson);
        result.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
