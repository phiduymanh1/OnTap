package com.example.ontap.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DanhMuc", schema = "dbo", catalog = "QuanLySanPham")
public class DanhMuc {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "DanhMucID")
    private Integer danhMucId;
    @Basic
    @Column(name = "TenDanhMuc")
    private String tenDanhMuc;
    @Basic
    @Column(name = "MoTa")
    private String moTa;


}
