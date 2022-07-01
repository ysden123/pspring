package com.stulsoft.sql.jpa3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class TestAutoService {
    private static final Logger logger = LoggerFactory.getLogger(TestAutoService.class);

    @PersistenceContext
    private final EntityManager entityManager;

    private final TestAutoRepository testAutoRepository;

    public TestAutoService(EntityManager entityManager, TestAutoRepository testAutoRepository) {
        this.entityManager = entityManager;
        this.testAutoRepository = testAutoRepository;
    }

    public Integer findCount() {
        return testAutoRepository.findCount();
    }

    public MinMaxTestAuto findMinMaxNames() {
        List<List<String>> minMaxNames = testAutoRepository.findMinMaxNames();
        return new MinMaxTestAuto(minMaxNames.get(0));
    }

    public MinMaxTestAuto findMinMaxNamesWrong() {
        List<List<String>> minMaxNames = testAutoRepository.findMinMaxNamesWrong();
        return new MinMaxTestAuto(minMaxNames.get(0));
    }

    public void findMinMaxNames2() {
        assert entityManager != null;
        Object[] result = (Object[]) entityManager.createNativeQuery("SELECT MIN(name) as minName, MAX(name) as maxName FROM test_autos")
                .getSingleResult();
        logger.info("result.getClass().getName(): {}", result.getClass().getName());
        logger.info("result.length={}", result.length);
        logger.info("result={}", result);

        MinMaxTestAuto minMaxTestAuto = new MinMaxTestAuto((result));
        logger.info("minMaxTestAuto: {}", minMaxTestAuto);
    }
}
