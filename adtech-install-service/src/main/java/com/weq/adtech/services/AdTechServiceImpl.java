package com.weq.adtech.services;

import com.weq.adtech.domain.Click;
import com.weq.adtech.domain.Delivery;
import com.weq.adtech.domain.Install;
import com.weq.adtech.models.ClickModel;
import com.weq.adtech.models.DeliveryModel;
import com.weq.adtech.models.InstallModel;
import com.weq.adtech.repositories.ClickRepository;
import com.weq.adtech.repositories.DeliveryRepository;
import com.weq.adtech.repositories.InstallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdTechServiceImpl implements AdTechService {

	@Autowired
	public DeliveryRepository deliveryRepository;

	@Autowired
	public ClickRepository clickRepository;

	@Autowired
	public InstallRepository installRepository;

	@Override
	public boolean saveAdDelivery(DeliveryModel deliveryModel){
		deliveryRepository.save(convertDeliverModelToEntity(deliveryModel));
		return true;
	}

	public List<Delivery> getDeliveries(Long advertisementId){
		return deliveryRepository.findAllByAdvertisementId(advertisementId);
	}

	@Override
	public boolean saveAdClick(ClickModel clickModel) {
		Optional<Delivery> deliveryOptional = deliveryRepository.findByDeliveryId(clickModel.getDeliveryId());
		if(deliveryOptional.isPresent()){
			clickRepository.save(convertClickModelToEntity(clickModel, deliveryOptional.get()));
			return true;
		}
		return false;
	}

	@Override
	public boolean saveAdInstall(InstallModel installModel) {
		Optional<Click> clickOptional = clickRepository.findByClickId(installModel.getClickId());
		if(clickOptional.isPresent()){
			installRepository.save(convertInstallModelToEntity(installModel, clickOptional.get()));
			return true;
		}
		return false;
	}

	private Delivery convertDeliverModelToEntity(DeliveryModel deliveryModel){
		Delivery delivery = new Delivery();
		delivery.setAdvertisementId(deliveryModel.getAdvertisementId());
		delivery.setBrowser(deliveryModel.getBrowser());
		delivery.setOs(deliveryModel.getOs());
		delivery.setDeliveryId(deliveryModel.getDeliveryId());
		delivery.setSite(deliveryModel.getSite());
		delivery.setTime(deliveryModel.getTime());
		return delivery;
	}

	private Click convertClickModelToEntity(ClickModel clickModel, Delivery delivery){
		Click click = new Click();
		click.setClickId(clickModel.getClickId());
		click.setDeliveryId(clickModel.getDeliveryId());
		click.setTime(clickModel.getTime());
		click.setAdvertisementId(delivery.getAdvertisementId());
		click.setBrowser(delivery.getBrowser());
		click.setOs(delivery.getOs());
		click.setSite(delivery.getSite());
		return click;
	}

	private Install convertInstallModelToEntity(InstallModel installModel, Click click){
		Install install = new Install();
		install.setInstallId(installModel.getInstallId());
		install.setClickId(installModel.getClickId());
		install.setTime(installModel.getTime());
		install.setDeliveryId(click.getDeliveryId());
		install.setAdvertisementId(click.getAdvertisementId());
		install.setBrowser(click.getBrowser());
		install.setOs(click.getOs());
		install.setSite(click.getSite());
		return install;
	}
}
