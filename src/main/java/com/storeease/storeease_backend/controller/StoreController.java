package com.storeease.storeease_backend.controller;

import com.storeease.storeease_backend.model.StoreTiming;
import com.storeease.storeease_backend.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    // ✅ Get all timings (full weekly schedule)
    @GetMapping("/timings")
    public List<StoreTiming> getAllTimings() {
        return storeService.getAllTimings();
    }

    // ✅ Get timing for specific day
    @GetMapping("/timings/{day}")
    public StoreTiming getTimingByDay(@PathVariable String day) {
        return storeService.getTimingByDay(day);
    }

    // ✅ Update timing for a specific day
    @PutMapping("/timings")
    public String updateTiming(@RequestBody StoreTiming timing) {
        storeService.updateTiming(timing);
        return "⏰ Store timing updated for " + timing.getDayOfWeek();
    }

    // ✅ Insert timing (useful when DB is empty or adding new day)
    @PostMapping("/timings")
    public String insertTiming(@RequestBody StoreTiming timing) {
        storeService.insertTiming(timing);
        return "✅ Store timing inserted for " + timing.getDayOfWeek();
    }
}
