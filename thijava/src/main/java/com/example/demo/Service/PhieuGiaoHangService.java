package com.example.demo.Service;

import com.example.demo.Entity.HoaDon;
import com.example.demo.Entity.PhieuGiaoHang;
import com.example.demo.Repository.PhieuGiaoHangRepository;
import com.example.demo.dbo.PhieuGiaoHangCustom;
import com.example.demo.dbo.PhieuGiaoHangRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PhieuGiaoHangService {
    @Autowired
    private PhieuGiaoHangRepository repository;

    public List<PhieuGiaoHangCustom> getPGHall(){
        return repository.getPGHall();
    }
    public PhieuGiaoHang delete(UUID maPhieuGiao){
        Optional<PhieuGiaoHang> optional = repository.findById(maPhieuGiao);
        return optional.map(phieuGiaoHang -> {
            repository.delete(phieuGiaoHang);
            return phieuGiaoHang;
        }).orElse(null);
    }
    public Page<PhieuGiaoHang> getALL(Integer page){
        Pageable pageable = PageRequest.of(page,5);
        return repository.findAll(pageable);
    }
    public PhieuGiaoHang update(PhieuGiaoHangRequest request,UUID maPhieuGiao){
        Optional<PhieuGiaoHang>optional = repository.findById(maPhieuGiao);
        return optional.map(phieuGiaoHang -> {
            phieuGiaoHang.setPhiGiaoHang(request.getPhiGiaoHang());
            phieuGiaoHang.setSdtNhan(request.getSdtNhan());
            phieuGiaoHang.setHoaDon(HoaDon.builder().maHoaDon(request.getMaHoaDon()).nguoiLap(request.getNguoiLap()).build());
             repository.save(phieuGiaoHang);
            return phieuGiaoHang;
        }).orElse(null);
    }
}
