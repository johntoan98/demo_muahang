package com.demomuahang.service;

import com.demomuahang.models.SanPham;

import java.util.List;

public interface ICrudService<E> {
    List<E> getAll();
    void save(E e);
    void edit(E e);
    void delete(E e);
}
