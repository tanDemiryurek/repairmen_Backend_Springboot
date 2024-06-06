package com.group21.repairmenService.controller;

import com.group21.repairmenService.dto.ReservationDTO;
import com.group21.repairmenService.dto.ReviewDTO;
import com.group21.repairmenService.entity.Review;
import com.group21.repairmenService.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping("/ads")
    public ResponseEntity<?> getAllAds(){
        return ResponseEntity.ok(clientService.getAllAds());
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchAdByService(@PathVariable String name){
        return ResponseEntity.ok(clientService.searchAdByName(name));
    }

    @PostMapping("/book-service")
    public ResponseEntity<?> bookService(@RequestBody ReservationDTO reservationDTO){
        boolean success = clientService.bookService(reservationDTO);
        if (success){
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/ad/{adId}")
    public ResponseEntity<?> getAdDetailsByAdId(@PathVariable Long adId){
        return ResponseEntity.ok(clientService.getAdDetailsByAdId(adId));
    }

    @GetMapping("/my-bookings/{userId}")
    public ResponseEntity<?> getAllBookingByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(clientService.getAllBookingByUserId(userId));
    }

    @PostMapping("/review")
    public ResponseEntity<?> giveReview(@RequestBody ReviewDTO reviewDTO){
        Boolean success = clientService.giveReview(reviewDTO);
        if (success){
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
