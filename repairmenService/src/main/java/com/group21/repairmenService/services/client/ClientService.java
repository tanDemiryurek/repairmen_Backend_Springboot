package com.group21.repairmenService.services.client;

import com.group21.repairmenService.dto.AdDTO;
import com.group21.repairmenService.dto.AdDetailsForClientDTO;
import com.group21.repairmenService.dto.ReservationDTO;
import com.group21.repairmenService.dto.ReviewDTO;

import java.util.List;

public interface ClientService {

    List<AdDTO> getAllAds();
    List<AdDTO> searchAdByName(String name);

    boolean bookService(ReservationDTO reservationDTO);

    AdDetailsForClientDTO getAdDetailsByAdId(Long adId);

    List<ReservationDTO> getAllBookingByUserId(Long userId);

    Boolean giveReview(ReviewDTO reviewDTO);
}
