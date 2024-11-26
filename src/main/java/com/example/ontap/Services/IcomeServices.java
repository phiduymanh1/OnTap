package com.example.ontap.Services;

import com.example.ontap.Entity.SanPham;

import java.util.List;

public interface IcomeServices<T> {
    List<T> getAll();

    T detail(Integer id);

    void addorUpdate(T object);

    void remove(T object);
}
