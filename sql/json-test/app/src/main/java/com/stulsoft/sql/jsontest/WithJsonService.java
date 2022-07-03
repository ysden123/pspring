package com.stulsoft.sql.jsontest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

@Service
public class WithJsonService {
    private static final Logger logger = LoggerFactory.getLogger(WithJsonService.class);

    public static class TripleCount {
        private final Integer c1;
        private final Integer c2;
        private final Integer c3;

        public TripleCount(Integer c1, Integer c2, Integer c3) {
            this.c1 = c1 == null ? 0 : c1;
            this.c2 = c2 == null ? 0 : c2;
            this.c3 = c3 == null ? 0 : c3;
        }

        public Integer getC1() {
            return c1;
        }

        public Integer getC2() {
            return c2;
        }

        public Integer getC3() {
            return c3;
        }

        @Override
        public String toString() {
            return "TripleCount{" +
                    "c1=" + c1 +
                    ", c2=" + c2 +
                    ", c3=" + c3 +
                    '}';
        }
    }

    private final WithJsonRepository withJsonRepository;

    public WithJsonService(WithJsonRepository withJsonRepository) {
        this.withJsonRepository = withJsonRepository;
    }

    public List<WithJson> findAll() {
        try {
            List<WithJson> result = withJsonRepository.findAll();
            logger.info("result.size={}", result.size());
            return result;
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            return Collections.emptyList();
        }
    }

    public Integer findCountTest() {
        return withJsonRepository.countTest();
    }

    public TripleCount findCountTriple() {
        try {
            Long start = System.currentTimeMillis();
            List<List<Integer>> resultFromDB = withJsonRepository.countTriple();
            Long finish = System.currentTimeMillis();
            logger.info("Duration is {}", Duration.ofMillis(finish - start));
            if (resultFromDB.isEmpty()) {
                return new TripleCount(0, 0, 0);
            }
            List<Integer> counts = resultFromDB.get(0);
            return new TripleCount(counts.get(0), counts.get(1), counts.get(2));
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            return new TripleCount(0, 0, 0);
        }
    }

    public void clear() {
        withJsonRepository.deleteAll();
    }

    public void add(List<WithJson> withJsons) {
        withJsonRepository.saveAll(withJsons);
    }
}
