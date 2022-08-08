package com.maping.MappingDataModel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/featuremapping")
	public ResponseEntity<String> addFeatureMapping(@RequestBody FeatureMapping featureMapping){
		
		featureService.saveFeatureMappingWithAttributeMapping(featureMapping);
		return new ResponseEntity<String>("Mapping Saved",HttpStatus.OK);
	}
	
	@DeleteMapping("/deletefeaturemapping")
	public ResponseEntity<String> deleteFeatureMapping(@RequestParam("fmId") Long fmId){
		featureService.deleteFeatureMappingById(fmId);
		return new ResponseEntity<String>("Feature Mapping Removed",HttpStatus.OK);
	}
	
	@PutMapping("/featuremapping/{fmId}")
	public ResponseEntity<String> updateFeatureMapping(@PathVariable("fmId") Long fmId, @RequestBody FeatureMapping featureMapping){
		
		featureService.updateFeatureMapping(fmId, featureMapping);
		return new ResponseEntity<String>("Updated",HttpStatus.OK); 
	}
}
