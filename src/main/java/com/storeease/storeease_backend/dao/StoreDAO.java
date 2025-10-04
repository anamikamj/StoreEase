

package com.storeease.storeease_backend.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.storeease.storeease_backend.model.StoreTiming;

@Repository
public class StoreDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StoreTiming getTimings() {
        String sql = "SELECT * FROM store_timings ORDER BY id DESC LIMIT 1";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new StoreTiming(rs.getInt("id"), rs.getTime("open_time"), rs.getTime("close_time")));
    }

    public void updateTimings(StoreTiming timing) {
        String sql = "INSERT INTO store_timings(open_time, close_time) VALUES (?, ?)";
        jdbcTemplate.update(sql, timing.getOpenTime(), timing.getCloseTime());
    }
}
