package com.group21.repairmenService.services.company;

import com.group21.repairmenService.dto.AdDTO;
import com.group21.repairmenService.dto.ReservationDTO;

import java.io.IOException;
import java.util.List;

public interface CompanyService {


    boolean postAd(Long userId, AdDTO adDTO) throws IOException;

    List<AdDTO> getAllAds(Long userId);

    AdDTO getAdById(Long adId);

    boolean updateAd(Long adId, AdDTO adDTO) throws IOException;

    boolean deletAd(Long adId);

    List<ReservationDTO> getAllAdBookings(Long companyId);

    boolean changeBookingStatus(Long bookingId, String status);
}
