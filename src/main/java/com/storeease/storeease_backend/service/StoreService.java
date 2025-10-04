package com.storeease.storeease_backend.service;

import com.storeease.storeease_backend.dao.StoreDAO;
import com.storeease.storeease_backend.model.StoreTiming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StoreService {

    @Autowired
    private StoreDAO storeDAO;

    public StoreTiming getTimings() {
        return storeDAO.getTimings();
    }

    public void updateTimings(StoreTiming timing) {
        storeDAO.updateTimings(timing);
    }
}
