package com.weq.adtech.controllers;

import com.weq.adtech.domain.Delivery;
import com.weq.adtech.models.ClickModel;
import com.weq.adtech.models.DeliveryModel;
import com.weq.adtech.models.InstallModel;
import com.weq.adtech.services.AdTechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/ads")
public class AdTechController {

	@Autowired
	public AdTechService adTechService;

	@RequestMapping(value="/test", method = RequestMethod.GET)
	public ResponseEntity<?> testEndPoint(){
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@RequestMapping(value = "/delivery", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addDelivery(@RequestBody DeliveryModel deliveryModel) {
		if(this.adTechService.saveAdDelivery(deliveryModel)){
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}else{
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/{advertisementId}", method = RequestMethod.GET)
	public ResponseEntity<List<Delivery>> addDelivery(@PathVariable Long advertisementId) {
		return new ResponseEntity<List<Delivery>>(this.adTechService.getDeliveries(advertisementId), HttpStatus.OK);
	}

	@RequestMapping(value = "/click", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addClicks(@RequestBody ClickModel clickModel) {
		if(this.adTechService.saveAdClick(clickModel)){
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}else{
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/install", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addInstalls(@RequestBody InstallModel installModel) {
		if(this.adTechService.saveAdInstall(installModel)){
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}else{
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
	}
}
