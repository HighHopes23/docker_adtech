package com.weq.adtech.repositories;

import com.weq.adtech.domain.Delivery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryRepository extends MongoRepository<Delivery, Long> {

	List<Delivery> findAllByAdvertisementId(Long advertisementId);
	Optional<Delivery> findByDeliveryId(String deliveryId);
}
