package com.example.ontap.Servlet;

import com.example.ontap.Entity.DanhMuc;
import com.example.ontap.Entity.SanPham;
import com.example.ontap.Repository.DanhMucRepo;
import com.example.ontap.Repository.SanPhamRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = {
        "/sanpham/load",
        "/sanpham/detail",
        "/sanpham/add",
        "/sanpham/update",
        "/sanpham/delete",

})
public class SanPhamServlet extends HttpServlet {
    SanPhamRepo sanPhamRepo= new SanPhamRepo();
    DanhMucRepo danhMucRepo= new DanhMucRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/sanpham/load")){
            this.load(request,response);
        } else if (uri.equals("/sanpham/detail")) {
            this.detail(request,response);
        } else if (uri.equals("/sanpham/delete")) {
            this.delete(request,response);
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/sanpham/add")){
            this.add(request,response);
        } else if (uri.equals("/sanpham/update")) {
            this.update(request,response);
        }
    }



    private void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SanPham> listsp = sanPhamRepo.getAll();
        request.setAttribute("listsp",listsp);
        List<DanhMuc> listdm = danhMucRepo.getAll();
        request.setAttribute("listdm",listdm);
        request.getRequestDispatcher("/SanPham.jsp").forward(request,response);
    }
    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DanhMuc> listdm = danhMucRepo.getAll();
        request.setAttribute("listdm",listdm);
        Integer id = Integer.parseInt(request.getParameter("sanPhamId"));
        SanPham sanPham = sanPhamRepo.detail(id);
        request.setAttribute("sp",sanPham);
        request.getRequestDispatcher("/DetailSp.jsp").forward(request,response);
    }
    @SneakyThrows
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer id = Integer.parseInt(request.getParameter("sanPhamId"));
        String tenSanPham = request.getParameter("tenSanPham");
        String gia = request.getParameter("gia");
        String soLuong = request.getParameter("soLuong");
        String danhMucId = request.getParameter("danhMuc");

        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setDanhMucId(Integer.parseInt(danhMucId));

        SanPham sanPham = new SanPham();
        sanPham.setSanPhamId(id);
        sanPham.setTenSanPham(tenSanPham);
        sanPham.setGia(Double.parseDouble(gia));
        sanPham.setSoLuong(Integer.parseInt(soLuong));
        sanPham.setDanhMuc(danhMuc);
        sanPhamRepo.addorUpdate(sanPham);
        load(request, response);
    }
    @SneakyThrows
    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("da vao day");
//        SanPham sanPham = new SanPham();
//        BeanUtils.populate(sanPham,request.getParameterMap());
//        sanPhamRepo.addorUpdate(sanPham);
//        load(request, response);
        String tenSanPham = request.getParameter("tenSanPham");
        String gia = request.getParameter("gia");
        String soLuong = request.getParameter("soLuong");
        String danhMucId = request.getParameter("danhMuc");

        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setDanhMucId(Integer.parseInt(danhMucId));

        SanPham sanPham = new SanPham();
        sanPham.setTenSanPham(tenSanPham);
        sanPham.setGia(Double.parseDouble(gia));
        sanPham.setSoLuong(Integer.parseInt(soLuong));
        sanPham.setDanhMuc(danhMuc);
        sanPhamRepo.addorUpdate(sanPham);
        load(request, response);
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("sanPhamId"));



        SanPham sanPham = new SanPham();
        sanPham.setSanPhamId(id);

        sanPhamRepo.remove(sanPham);
        load(request, response);
    }


}
