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
import com.maping.MappingDataModel.entity.MappingType;
import com.maping.MappingDataModel.service.FeatureService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.*;


@RestController
public class MappingController {

	@Autowired
	FeatureService featureService;

	@Operation(summary = "Get all Feature Mappings")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = FeatureMapping.class)) }),			
			@ApiResponse(responseCode = "404", description = "Not found", content = @Content) })
	@GetMapping("/featuremappings")
	public ResponseEntity<List<FeatureMapping>> getAllFeatureMapping() {
		return new ResponseEntity<List<FeatureMapping>>(featureService.getAllFeatureMapp(), HttpStatus.OK);
	}
	
	@Operation(summary = "Save a Feature Mapping")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Mapping Saved", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = FeatureMapping.class)) }),			
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
	@PostMapping("/featuremapping")
	public ResponseEntity<String> addFeatureMapping(@RequestBody FeatureMapping featureMapping) {

		featureService.saveFeatureMappingWithAttributeMapping(featureMapping);
		return new ResponseEntity<String>("Mapping Saved", HttpStatus.OK);
	}

	@Operation(summary = "Delete a Feature Mapping by fmId")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Feature Mapping Removed", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = FeatureMapping.class)) }),			
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
	@DeleteMapping("/deletefeaturemapping")
	public ResponseEntity<String> deleteFeatureMapping(@RequestParam("fmId") String fmId) {
		featureService.deleteFeatureMappingById(fmId);
		return new ResponseEntity<String>("Feature Mapping Removed", HttpStatus.OK);
	}

	@Operation(summary = "Update a Feature Mapping by fmId")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Updated", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = FeatureMapping.class)) }),			
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
	@PutMapping("/featuremapping/{fmId}")
	public ResponseEntity<String> updateFeatureMapping(@PathVariable("fmId") String fmId,
			@RequestBody FeatureMapping featureMapping) {

		featureService.updateFeatureMapping(fmId, featureMapping);
		return new ResponseEntity<String>("Updated", HttpStatus.OK);
	}

	@Operation(summary = "Save a Mapping Type")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Mapping type saved", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = MappingType.class)) }),			
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
	@PostMapping("/mappingtype")
	public ResponseEntity<String> saveMappingType(@RequestBody MappingType mappingType) {
		featureService.saveMappingType(mappingType);
		return new ResponseEntity<String>("mapping type saved", HttpStatus.OK);
	}

	@Operation(summary = "Get all Mapping Types")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = MappingType.class)) }),			
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content) })
	@GetMapping("/mappingtype")
	public ResponseEntity<List<MappingType>> getAllMappingType() {
		return new ResponseEntity<List<MappingType>>(featureService.getAllMappingType(), HttpStatus.OK);
	}
}
