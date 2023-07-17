package com.demomuahang.service.impl;

import com.demomuahang.models.HoaDon;
import com.demomuahang.repository.IHoaDonRepo;
import com.demomuahang.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HoaDonServiceImpl implements ICrudService<HoaDon> {
    @Autowired
    IHoaDonRepo iHoaDonRepo;

    @Override
    public List<HoaDon> getAll() {
        return (List<HoaDon>) iHoaDonRepo.findAll();
    }

    @Override
    public void save(HoaDon hoaDon) {
        iHoaDonRepo.save(hoaDon);
    }

    @Override
    public void edit(HoaDon hoaDon) {
        iHoaDonRepo.save(hoaDon);
    }

    @Override
    public void delete(HoaDon hoaDon) {
        iHoaDonRepo.deleteById(hoaDon.getId());
    }
}
