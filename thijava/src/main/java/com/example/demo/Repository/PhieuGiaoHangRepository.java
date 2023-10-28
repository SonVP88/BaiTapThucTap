package com.example.demo.Repository;

import com.example.demo.Entity.PhieuGiaoHang;
import com.example.demo.dbo.PhieuGiaoHangCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PhieuGiaoHangRepository extends JpaRepository<PhieuGiaoHang, UUID> {


    @Query(value = "select pgh.DiaChiGiao,pgh.PhiGiaoHang,pgh.SdtNhan,hd.MaHoaDon,hd.NguoiLap from phieugiaohang pgh \n" +
            "join HoaDon hd on hd.MaHoaDon=pgh.HoaDonGiao\n" +
            "join DiaChi dc on dc.maDiachi= pgh.diachigiao",nativeQuery = true)
    List<PhieuGiaoHangCustom> getPGHall();
}
