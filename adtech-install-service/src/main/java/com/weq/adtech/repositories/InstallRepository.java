package com.weq.adtech.repositories;

import com.weq.adtech.domain.Install;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstallRepository extends MongoRepository<Install, Long> {
}
