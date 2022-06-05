package com.stulsoft.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SomeService {
    private static final Logger logger = LoggerFactory.getLogger(SomeService.class);
    private DomainSourceMappingRepository domainSourceMappingRepository;

    public SomeService(DomainSourceMappingRepository domainSourceMappingRepository) {
        this.domainSourceMappingRepository = domainSourceMappingRepository;
    }

    public Map<String, Collection<SourceLibrary>> findSourceLibraries(Collection<String> types){
        Map<String, Collection<SourceLibrary>> result = new HashMap<>();
        for(Object row: domainSourceMappingRepository.findSpecial(types)){
            Object[] objects = (Object[]) row;
            String key = (String)objects[0];
            SourceLibrary sourceLibrary = (SourceLibrary) objects[1];
            Collection<SourceLibrary> collection = result.computeIfAbsent(key, k -> new ArrayList<>());
            collection.add(sourceLibrary);
        }
        return result;
    }
}
