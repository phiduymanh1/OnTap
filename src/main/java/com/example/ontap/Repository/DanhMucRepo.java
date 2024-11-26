package com.example.ontap.Repository;

import com.example.ontap.Entity.DanhMuc;
import com.example.ontap.Services.IcomeServices;
import com.example.ontap.Ultils.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class DanhMucRepo implements IcomeServices<DanhMuc> {
    @Override
    public List<DanhMuc> getAll() {
        Session session = Hibernate.getFACTORY().openSession();
        return session.createQuery("FROM DanhMuc ").list();
    }

    @Override
    public DanhMuc detail(Integer id) {
        return null;
    }

    @Override
    public void addorUpdate(DanhMuc object) {

    }

    @Override
    public void remove(DanhMuc object) {

    }


}
