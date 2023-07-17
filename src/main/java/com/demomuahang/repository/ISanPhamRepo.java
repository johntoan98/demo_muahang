package com.demomuahang.repository;

import com.demomuahang.models.SanPham;
import org.springframework.data.repository.CrudRepository;

public interface ISanPhamRepo extends CrudRepository<SanPham, Integer> {
}
