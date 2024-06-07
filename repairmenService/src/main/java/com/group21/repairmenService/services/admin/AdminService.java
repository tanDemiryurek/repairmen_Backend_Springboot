package com.group21.repairmenService.services.admin;

import com.group21.repairmenService.dto.AdDTO;
import com.group21.repairmenService.entity.Ad;

import java.util.List;

public interface AdminService {

    List<AdDTO> getPendingAds();
    void approveAd(Long adId);
    void rejectAd(Long adId);
}
