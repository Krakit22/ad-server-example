package com.cot.controller;

import com.cot.inmemory.service.AdvertisingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AdvertisingController {

    private final AdvertisingService advertisingService;

    @GetMapping(value = "/imp")
    public ResponseEntity<String> getAdvertisingPhrase(@RequestParam("pl") Long placementId) {
        return ResponseEntity.ok(advertisingService.getAdvertisingPhrase(placementId));
    }
}