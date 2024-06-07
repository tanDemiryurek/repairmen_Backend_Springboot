package com.group21.repairmenService.controller;

import com.group21.repairmenService.dto.ReservationDTO;
import com.group21.repairmenService.dto.ReviewDTO;
import com.group21.repairmenService.dto.UserDto;
import com.group21.repairmenService.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/home-detailedAd/{adId}")
    public ResponseEntity<?> getAdDetailsByAdIdHome(@PathVariable Long adId) {
        return ResponseEntity.ok(clientService.getAdDetailsByAdIdHome(adId));
    }
    @GetMapping("/client/ads")
    public ResponseEntity<?> getAllAds(){
        return ResponseEntity.ok(clientService.getAllAds());
    }

    @GetMapping("/home")
    public ResponseEntity<?> getAllAdsHomePage(){
        return ResponseEntity.ok(clientService.getAllAdsHomePage());
    }

    @GetMapping("/client/search/{name}")
    public ResponseEntity<?> searchAdByService(@PathVariable String name){
        return ResponseEntity.ok(clientService.searchAdByName(name));
    }

    @GetMapping("/client/profile/{userId}")
    public ResponseEntity<?> getUserInfoById(@PathVariable Long userId){
        UserDto userDto = clientService.getUserInfoById(userId);
        if (userDto != null){
            return ResponseEntity.ok(userDto);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/client/profile/{userId}")
    public ResponseEntity<?> updateUserInfo(@PathVariable Long userId, @ModelAttribute UserDto userDTO) throws IOException {
        boolean success = clientService.updateUserInfo(userId, userDTO);
        if (success){
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/home/{name}")
    public ResponseEntity<?> searchAdByServiceHomePage(@PathVariable String name){
        return ResponseEntity.ok(clientService.searchAdByNameHomePage(name));
    }

    @PostMapping("/client/book-service")
    public ResponseEntity<?> bookService(@RequestBody ReservationDTO reservationDTO){
        boolean success = clientService.bookService(reservationDTO);
        if (success){
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/client/ad/{adId}")
    public ResponseEntity<?> getAdDetailsByAdId(@PathVariable Long adId){
        return ResponseEntity.ok(clientService.getAdDetailsByAdId(adId));
    }

    @GetMapping("/client/my-bookings/{userId}")
    public ResponseEntity<?> getAllBookingByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(clientService.getAllBookingByUserId(userId));
    }

    @PostMapping("/client/review")
    public ResponseEntity<?> giveReview(@RequestBody ReviewDTO reviewDTO){
        Boolean success = clientService.giveReview(reviewDTO);
        if (success){
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
