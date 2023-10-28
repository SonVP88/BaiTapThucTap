package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "PhieuGiaoHang")
public class PhieuGiaoHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MaPhieuGiao")
    private UUID maPhieuGiao;

    @Column(name = "SdtNhan")
    private String sdtNhan;

    @Column(name = "PhiGiaoHang")
    private BigDecimal phiGiaoHang;

    @Column(name = "DiaChiGiao")
    private UUID diaChiGiao;

    @ManyToOne
    @JoinColumn(name = "HoaDonGiao")
    private HoaDon hoaDon;
}
