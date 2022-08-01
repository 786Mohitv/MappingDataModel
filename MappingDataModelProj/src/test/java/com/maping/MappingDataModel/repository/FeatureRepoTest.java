package com.maping.MappingDataModel.repository;


import java.util.List;

import javax.sound.midi.VoiceStatus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.maping.MappingDataModel.entity.AttributeMapping;
import com.maping.MappingDataModel.entity.FeatureMapping;

@SpringBootTest
public class FeatureRepoTest {

	@Autowired
	private FeatureRepo featureRepo;	
	
	@Test		
	public void saveFeatureMappingWithAttributeMapping() {
		AttributeMapping attributeMapping = new AttributeMapping(
				"attr1",
				"1attr"
				);		
		 
		FeatureMapping featureMapping = new FeatureMapping(					
				"c",
				"d"				
				);
		featureMapping.addAttributes(attributeMapping);
		featureRepo.save(featureMapping);
	}
	@Test
	public void printgetFeatureMappingByFmId() {
		FeatureMapping featureMapping2 = featureRepo.findByFmId(1);
		System.out.println(featureMapping2);	
	}
	
	@Test
	public void printAllFeatureMappings() {
		System.out.println(featureRepo.findAll());
	}
	
	
		
	
	
	
}
