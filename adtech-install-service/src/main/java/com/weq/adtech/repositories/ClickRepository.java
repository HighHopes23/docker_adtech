package com.weq.adtech.repositories;

import com.weq.adtech.domain.Click;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClickRepository extends MongoRepository<Click, Long> {

	Optional<Click> findByClickId(String clickId);
}
