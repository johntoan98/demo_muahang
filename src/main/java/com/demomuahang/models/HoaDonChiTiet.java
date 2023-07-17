package com.demomuahang.models;

import javax.persistence.*;

@Entity
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    @ManyToOne
    private SanPham sanPham;
    @ManyToOne
    private HoaDon hoaDon;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int id, int quantity, SanPham sanPham, HoaDon hoaDon) {
        this.id = id;
        this.quantity = quantity;
        this.sanPham = sanPham;
        this.hoaDon = hoaDon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }
}
