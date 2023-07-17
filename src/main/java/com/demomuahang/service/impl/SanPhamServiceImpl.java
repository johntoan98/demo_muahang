package com.demomuahang.service.impl;

import com.demomuahang.models.SanPham;
import com.demomuahang.repository.ISanPhamRepo;
import com.demomuahang.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceImpl implements ICrudService<SanPham> {
    @Autowired
    ISanPhamRepo iSanPhamRepo;


    @Override
    public List<SanPham> getAll() {
        return (List<SanPham>) iSanPhamRepo.findAll();
    }

    @Override
    public void save(SanPham sanPham) {
        iSanPhamRepo.save(sanPham);
    }

    @Override
    public void edit(SanPham sanPham) {
        iSanPhamRepo.save(sanPham);

    }

    public SanPham findById(int id){
        return iSanPhamRepo.findById(id).get();
    }

    @Override
    public void delete(SanPham sanPham) {
        iSanPhamRepo.deleteById(sanPham.getId());
    }
}
