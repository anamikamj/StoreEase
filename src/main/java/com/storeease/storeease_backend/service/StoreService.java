package com.storeease.storeease_backend.service;

import com.storeease.storeease_backend.dao.StoreDAO;
import com.storeease.storeease_backend.model.StoreTiming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreDAO storeDAO;

    // Fetch all timings (all days of week)
    public List<StoreTiming> getAllTimings() {
        return storeDAO.getAllTimings();
    }

    // Fetch timing for a specific day
    public StoreTiming getTimingByDay(String dayOfWeek) {
        return storeDAO.getTimingByDay(dayOfWeek);
    }

    // Update timing for a specific day
    public void updateTiming(StoreTiming timing) {
        storeDAO.updateTiming(timing);
    }

    // Insert new timing if it doesn’t exist yet
    public void insertTiming(StoreTiming timing) {
        storeDAO.insertTiming(timing);
    }
}
