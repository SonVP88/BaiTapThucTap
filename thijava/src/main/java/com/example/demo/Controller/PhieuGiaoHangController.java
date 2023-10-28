package com.example.demo.Controller;

import com.example.demo.Entity.PhieuGiaoHang;
import com.example.demo.Service.PhieuGiaoHangService;
import com.example.demo.dbo.PhieuGiaoHangRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("phieugiaohang")
public class PhieuGiaoHangController {
    @Autowired
    private PhieuGiaoHangService service;

    @GetMapping()
    public ResponseEntity<?> getall(){
        return  ResponseEntity.ok(service.getPGHall());
    }
    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam(defaultValue = "0",name = "page")Integer page){
        return ResponseEntity.ok(service.getALL(page));
    }
    @DeleteMapping("/delete/{maPhieuGiao}")
      public ResponseEntity<?> delete(@PathVariable UUID maPhieuGiao){
        return ResponseEntity.ok(service.delete(maPhieuGiao));
    }
    @PutMapping("/update/{maPhieuGiao}")
    public ResponseEntity<?> update(@RequestBody PhieuGiaoHangRequest request,@PathVariable UUID maPhieuGiao){
        return ResponseEntity.ok(service.update(request,maPhieuGiao));
    }

}
