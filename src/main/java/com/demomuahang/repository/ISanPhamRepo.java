package com.demomuahang.repository;

import com.demomuahang.models.SanPham;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISanPhamRepo extends PagingAndSortingRepository<SanPham, Integer> {
//    List<SanPham> findAllByContentContaining(String content);
//    @Query(nativeQuery = true, value = "select * from sanpham  where sanpham.content like concat('%',:content,'%')")
//    List<SanPham> findAllByContent(@Param("content") String content);
}
