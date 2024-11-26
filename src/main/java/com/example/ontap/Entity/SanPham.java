package com.example.ontap.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SanPham", schema = "dbo", catalog = "QuanLySanPham")
public class SanPham {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SanPhamID")
    private Integer sanPhamId;
    @Basic
    @Column(name = "TenSanPham")
    private String tenSanPham;
    @Basic
    @Column(name = "Gia")
    private Double gia;
    @Basic
    @Column(name = "SoLuong")
    private Integer soLuong;

    @ManyToOne
    @JoinColumn(name = "DanhMucID")
    private DanhMuc danhMuc;


}
