package com.group21.repairmenService.controller;

import com.group21.repairmenService.dto.AdDTO;
import com.group21.repairmenService.services.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/dashboard")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/pending-ads")
    public ResponseEntity<List<AdDTO>> getPendingAds() {
        return ResponseEntity.ok(adminService.getPendingAds());
    }

    @PostMapping("/approve-ad/{adId}")
    public ResponseEntity<Void> approveAd(@PathVariable Long adId) {
        adminService.approveAd(adId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reject-ad/{adId}")
    public ResponseEntity<Void> rejectAd(@PathVariable Long adId) {
        adminService.rejectAd(adId);
        return ResponseEntity.ok().build();
    }
}
