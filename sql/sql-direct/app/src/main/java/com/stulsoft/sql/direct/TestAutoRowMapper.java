package com.stulsoft.sql.direct;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestAutoRowMapper implements RowMapper<TestAuto> {
    @Override
    public TestAuto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TestAuto(rs.getLong("id"),
                rs.getString("name"));
    }
}
