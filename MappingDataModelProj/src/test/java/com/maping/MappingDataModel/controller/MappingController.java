package com.maping.MappingDataModel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import com.maping.MappingDataModel.entity.FeatureMapping;
import com.maping.MappingDataModel.service.FeatureService;

@RestController
public class MappingController {

	@Autowired
	FeatureService featureService;
	
	@GetMapping("/featuremappings")
	public ResponseEntity<List<FeatureMapping>> getAllFeatureMapping(){				
		return new ResponseEntity<List<FeatureMapping>>(featureService.getAllFeatureMapp(),HttpStatus.OK);
	}
}
