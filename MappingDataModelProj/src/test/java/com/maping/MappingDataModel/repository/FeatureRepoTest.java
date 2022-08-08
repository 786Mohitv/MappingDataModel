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
		AttributeMapping attributeMapping1 = new AttributeMapping(
				"attr2",
				"2attr"
				);
		AttributeMapping attributeMapping2 = new AttributeMapping(
				"attr3",
				"3attr"
				);
		 
		FeatureMapping featureMapping = new FeatureMapping(					
				"c",
				"d"				
				);
		
		
		featureMapping.addAttributes(attributeMapping);
		featureMapping.addAttributes(attributeMapping1);
		featureMapping.addAttributes(attributeMapping2);
		attributeMapping.addFeatures(featureMapping);
		
		featureRepo.save(featureMapping);
		//System.out.println(featureMapping.getAttributesList().get(0));
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
