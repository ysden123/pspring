package com.stulsoft.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SomeService {
    private static final Logger logger = LoggerFactory.getLogger(SomeService.class);
    private ContainerRepository containerRepository;

    public SomeService(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    public Map<String, Collection<Nested2>> findNested2(Collection<String> types){
        Map<String, Collection<Nested2>> result = new HashMap<>();
        for(Object row: containerRepository.findSpecial(types)){
            Object[] objects = (Object[]) row;
            String key = (String)objects[0];
            Nested2 nested2 = (Nested2) objects[1];
            Collection<Nested2> collection = result.computeIfAbsent(key, k -> new ArrayList<>());
            collection.add(nested2);
        }
        return result;
    }
}
