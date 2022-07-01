package com.stulsoft.sql.jpa3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestAutoRepository  extends JpaRepository<TestAuto, Long> {
    @Query(nativeQuery = true,
            value = "SELECT COUNT(*) FROM test_autos"
    )
    Integer findCount();

    @Query(nativeQuery = true,
            value = "SELECT MIN(name), MAX(name) FROM test_autos"
    )
    List<List<String>> findMinMaxNames();
    @Query(nativeQuery = true,
            value = "SELECT MIN(name), MAX(name) FROM test_autos WHERE 3 = 4"
    )
    List<List<String>> findMinMaxNamesWrong();
}
