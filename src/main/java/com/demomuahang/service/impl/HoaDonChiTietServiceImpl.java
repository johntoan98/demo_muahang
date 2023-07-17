package com.demomuahang.service.impl;

import com.demomuahang.models.HoaDonChiTiet;
import com.demomuahang.repository.IHoaDonChiTietRepo;
import com.demomuahang.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HoaDonChiTietServiceImpl implements ICrudService<HoaDonChiTiet> {
    @Autowired
    IHoaDonChiTietRepo iHoaDonChiTietRepo;
    @Override
    public List<HoaDonChiTiet> getAll() {
        return (List<HoaDonChiTiet>) iHoaDonChiTietRepo.findAll();
    }

    @Override
    public void save(HoaDonChiTiet hoaDonChiTiet) {
        iHoaDonChiTietRepo.save(hoaDonChiTiet);
    }

    @Override
    public void edit(HoaDonChiTiet hoaDonChiTiet) {
        iHoaDonChiTietRepo.save(hoaDonChiTiet);
    }

    @Override
    public void delete(HoaDonChiTiet hoaDonChiTiet) {
        iHoaDonChiTietRepo.deleteById(hoaDonChiTiet.getId());
    }
}
