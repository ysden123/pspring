package com.stulsoft.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface DomainSourceMappingRepository extends CrudRepository<DomainSourceMapping, Long> {

    @Query("SELECT m.sourceFile.sha1, l FROM DomainSourceMapping m JOIN m.sourceLibrary l WHERE m.sourceFile.sha1 IN ?1")
    List findSpecial(Collection<String> sha1s);
}
