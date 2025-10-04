package com.storeease.storeease_backend.dao;

import com.storeease.storeease_backend.model.StoreTiming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get all timings for all days (Monday → Sunday order)
    public List<StoreTiming> getAllTimings() {
        String sql = "SELECT * FROM store_timings " +
                "ORDER BY FIELD(day_of_week, 'Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday')";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new StoreTiming(
                        rs.getInt("timing_id"),
                        rs.getString("day_of_week"),
                        rs.getTime("open_time"),
                        rs.getTime("close_time"),
                        rs.getBoolean("is_open")
                )
        );
    }

    // Get timing for a specific day
    public StoreTiming getTimingByDay(String dayOfWeek) {
        String sql = "SELECT * FROM store_timings WHERE day_of_week = ?";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{dayOfWeek},
                (rs, rowNum) ->
                        new StoreTiming(
                                rs.getInt("timing_id"),
                                rs.getString("day_of_week"),
                                rs.getTime("open_time"),
                                rs.getTime("close_time"),
                                rs.getBoolean("is_open")
                        )
        );
    }

    // Update timing for a specific day
    public void updateTiming(StoreTiming timing) {
        String sql = "UPDATE store_timings SET open_time = ?, close_time = ?, is_open = ? WHERE day_of_week = ?";
        jdbcTemplate.update(sql,
                timing.getOpenTime(),
                timing.getCloseTime(),
                timing.getIsOpen(),
                timing.getDayOfWeek()
        );
    }

    // Insert new timing (if a record for that day does not exist yet)
    public void insertTiming(StoreTiming timing) {
        String sql = "INSERT INTO store_timings(day_of_week, open_time, close_time, is_open) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                timing.getDayOfWeek(),
                timing.getOpenTime(),
                timing.getCloseTime(),
                timing.getIsOpen()
        );
    }
}
