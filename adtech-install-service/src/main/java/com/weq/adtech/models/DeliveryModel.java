package com.weq.adtech.models;

import lombok.Data;

import java.util.Date;

@Data
public class DeliveryModel {

	public Long advertisementId;
	public String deliveryId;
	public String browser;
	public String os;
	public String site;
	public Date time;

}
