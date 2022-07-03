package com.stulsoft.sql.jsontest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WithJsonRepository extends JpaRepository<WithJson, Long> {
    @Query(nativeQuery = true,
            value = "SELECT SUM(JSON_EXTRACT(data, '$.c1')) FROM with_jsons WHERE type='test'")
    Integer countTest();

    @Query(nativeQuery = true,
            value = "SELECT SUM(JSON_EXTRACT(data, '$.c1')), " +
                    "SUM(JSON_EXTRACT(data, '$.c2')), "+
                    "SUM(JSON_EXTRACT(data, '$.c3')) "+
                    "FROM with_jsons WHERE type='triple'")
    List<List<Integer>> countTriple();
}
