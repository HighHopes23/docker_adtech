package com.weq.adtech.services;

import com.weq.adtech.domain.Delivery;
import com.weq.adtech.models.ClickModel;
import com.weq.adtech.models.DeliveryModel;
import com.weq.adtech.models.InstallModel;

import java.util.List;

public interface AdTechService {

	boolean saveAdDelivery(DeliveryModel deliveryModel);
	List<Delivery> getDeliveries(Long deliveryId);
	boolean saveAdClick(ClickModel clickModel);
	boolean saveAdInstall(InstallModel installModel);

}
