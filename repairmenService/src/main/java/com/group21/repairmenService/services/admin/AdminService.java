package com.group21.repairmenService.services.admin;

import com.group21.repairmenService.dto.AdDTO;
import com.group21.repairmenService.entity.Ad;
import com.group21.repairmenService.enums.AdStatus;

import java.util.List;

public interface AdminService {

    List<AdDTO> getAllAds();
    void approveAd(Long adId);
    void rejectAd(Long adId);

}
