package com.example.demo.dbo;

import com.example.demo.Entity.HoaDon;
import com.example.demo.Entity.PhieuGiaoHang;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PhieuGiaoHangRequest {
    String sdtNhan;
    BigDecimal phiGiaoHang;
    String nguoiLap;
    Long maHoaDon;

    public PhieuGiaoHang map(PhieuGiaoHang phieuGiaoHang){
        phieuGiaoHang.setPhiGiaoHang(phiGiaoHang);
        phieuGiaoHang.setSdtNhan(sdtNhan);
        phieuGiaoHang.setHoaDon(HoaDon.builder().maHoaDon(maHoaDon).nguoiLap(nguoiLap).build());
        return phieuGiaoHang;
    }
}
