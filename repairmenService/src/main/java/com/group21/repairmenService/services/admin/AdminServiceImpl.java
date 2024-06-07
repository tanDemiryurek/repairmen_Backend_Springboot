package com.group21.repairmenService.services.admin;

import com.group21.repairmenService.dto.AdDTO;
import com.group21.repairmenService.entity.Ad;
import com.group21.repairmenService.enums.AdStatus;
import com.group21.repairmenService.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdRepository adRepository;

    @Override
    public List<AdDTO> getPendingAds() {
        List<Ad> ads = adRepository.findByStatus(AdStatus.PENDING);
        return ads.stream().map(Ad::getAdDto).collect(Collectors.toList());
    }

    @Override
    public void approveAd(Long adId) {
        Ad ad = adRepository.findById(adId).orElseThrow(() -> new RuntimeException("Ad not found"));
        ad.setStatus(AdStatus.APPROVED);
        adRepository.save(ad);
    }

    @Override
    public void rejectAd(Long adId) {
        Ad ad = adRepository.findById(adId).orElseThrow(() -> new RuntimeException("Ad not found"));
        ad.setStatus(AdStatus.REJECTED);
        adRepository.save(ad);
    }
}
