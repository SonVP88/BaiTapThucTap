package com.example.demo.dbo;

import java.math.BigDecimal;
import java.util.UUID;

public interface PhieuGiaoHangCustom {
    Long getMaHoaDon();
    String getSdtNhan();
    String getNguoiLap();
    BigDecimal getPhiGiaoHang();
    UUID getDiaChiGiao();
}
