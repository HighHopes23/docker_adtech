package com.weq.adtech.repositories;

import com.weq.adtech.domain.Install;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface InstallRepository extends MongoRepository<Install, String> {
	long countByTimeBetween(Date start, Date end);
	long countByTimeBetweenAndBrowser(Date start, Date end, String browser);
	long countByTimeBetweenAndOs(Date start, Date end, String os);
	long countByTimeBetweenAndBrowserAndOs(Date start, Date end, String browser, String os);
}
