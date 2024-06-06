package com.group21.repairmenService.dto;

import com.group21.repairmenService.enums.ReservationStatus;
import com.group21.repairmenService.enums.ReviewStatus;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationDTO {

    private Long id;

    private Date bookDate;

    private String serviceName;

    private ReservationStatus reservationStatus;

    private ReviewStatus reviewStatus;

    private Long userId;

    private String userName;

    private Long companyId;

    private Long adId;
}
