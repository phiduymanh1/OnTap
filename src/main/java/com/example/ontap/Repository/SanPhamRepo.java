package com.example.ontap.Repository;

import com.example.ontap.Entity.SanPham;
import com.example.ontap.Services.IcomeServices;
import com.example.ontap.Ultils.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SanPhamRepo implements IcomeServices<SanPham> {



    @Override
    public List<SanPham> getAll() {
        Session session = Hibernate.getFACTORY().openSession();
        return session.createQuery("FROM SanPham ").list();
    }

    @Override
    public SanPham detail(Integer id) {
        Session session = Hibernate.getFACTORY().openSession();
        return session.find(SanPham.class,id);
    }

    @Override
    public void addorUpdate(SanPham object) {
        Session session = Hibernate.getFACTORY().openSession();
        try {
            session.getTransaction().begin();
            session.saveOrUpdate(object);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void remove(SanPham sanPham) {
        Session session = Hibernate.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(sanPham);
        transaction.commit();
        session.close();
    }


    public static void main(String[] args) {
        List<SanPham> list = new SanPhamRepo().getAll();
        for (SanPham sanPham:
             list) {
            System.out.println(sanPham);
        }
    }
}
