package com.storeease.storeease_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.storeease.storeease_backend.model.StoreTiming;
import com.storeease.storeease_backend.service.StoreService;


@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/timings")
    public StoreTiming getTimings() {
        return storeService.getTimings();
    }

    @PutMapping("/timings")
    public String updateTimings(@RequestBody StoreTiming timing) {
        storeService.updateTimings(timing);
        return "Store timings updated!";
    }
}
