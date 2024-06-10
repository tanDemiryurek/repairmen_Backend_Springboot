package com.group21.repairmenService.services.client;

import com.group21.repairmenService.dto.*;

import java.io.IOException;
import java.util.List;

public interface ClientService {

    List<AdDTO> getAllAdsByStatus();
    List<AdDTO> searchAdByName(String name);

    boolean bookService(ReservationDTO reservationDTO);

    AdDetailsForClientDTO getAdDetailsByAdId(Long adId);

    AdDetailsForClientDTO getAdDetailsByAdIdHome(Long adId);

    List<ReservationDTO> getAllBookingByUserId(Long userId);

    UserDto getUserInfoById(Long userId);

    boolean updateUserInfo(Long userId, UserDto userDto) throws IOException;

    Boolean giveReview(ReviewDTO reviewDTO);

    List<AdDTO> searchAdByNameHomePage(String name);

//    List<AdDTO> getAllAdsHomePage();

    List<AdDTO> getAllAdsHomePagebyStatus();

}
