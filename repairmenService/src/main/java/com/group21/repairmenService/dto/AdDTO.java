package com.group21.repairmenService.dto;


import com.group21.repairmenService.enums.AdStatus;
import com.group21.repairmenService.enums.ReviewStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AdDTO {

    private Long id;

    private String serviceName;

    private String description;

    private Double price;

    private MultipartFile img;

    private byte[] returnedImg;

    private Long userId;

    private String companyName;

    private AdStatus adStatus;

}
