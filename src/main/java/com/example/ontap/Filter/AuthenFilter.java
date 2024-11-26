package com.example.ontap.Filter;

import com.example.ontap.Entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/sanpham/*")
public class AuthenFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String uri = request.getRequestURI();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null){
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
            response.sendRedirect("/login");

            System.out.println("User in session: " + session.getAttribute("user"));
            return;
        }
        if (user.getRole().equals("admin")){
            System.out.println("khong vao duoc trong nay");
            chain.doFilter(req,res);
        }else{
            if (uri.equals("/sanpham/load")){
                chain.doFilter(req,res);
            }else{
//                request.setAttribute("no","Bạn không có quyền");

                request.getRequestDispatcher("/BanKoCoQuyen.jsp").forward(request,response);
//                response.sendRedirect("/sanpham/load");
            }
        }
    }
}
