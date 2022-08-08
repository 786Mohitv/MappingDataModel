 package com.maping.MappingDataModel.service;

import java.util.List;

import javax.management.AttributeList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maping.MappingDataModel.entity.AttributeMapping;
import com.maping.MappingDataModel.entity.FeatureMapping;
import com.maping.MappingDataModel.repository.AttributeRepo;
import com.maping.MappingDataModel.repository.FeatureRepo;

@Service
public class FeatureService {

	private List featureMappList;

	public List getFeatureMappList() {
		return featureMappList;
	}

	public void setFeatureMappList(List featureMappList) {
		this.featureMappList = featureMappList;
	}

	

	@Override
	public String toString() {
		return "FeatureService [featureMappList=" + featureMappList + "]";
	}

	public FeatureService() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	@Autowired
	FeatureRepo featureRepo;

	@Autowired
	AttributeRepo attributeRepo;
	
	public List<FeatureMapping> getAllFeatureMapp() {
		return featureRepo.findAll();
		
	}
	
	public void saveFeatureMappingWithAttributeMapping(FeatureMapping featureMapping) {
	    List<AttributeMapping>	attributeList =   featureMapping.getAttributesList();
		featureRepo.save(featureMapping);
	}
	
	public void deleteFeatureMappingById(Long fmId) {
		featureRepo.deleteById(fmId);
	}
	
	public void updateFeatureMapping(Long fmId, FeatureMapping featureMapping) {
		
		FeatureMapping featureMappingOld = featureRepo.findByFmId(fmId);
		List<AttributeMapping> temp = featureMappingOld.getAttributesList();		
		featureMappingOld.setSourceFeature(featureMapping.getSourceFeature());
		featureMappingOld.setTargetFeature(featureMapping.getTargetFeature());
		featureMappingOld.setAttributesList(featureMapping.getAttributesList());
		featureRepo.save(featureMappingOld);
//		for(AttributeMapping attributeMapping: temp) {
//			attributeRepo.deleteById(attributeMapping.getAtId());
//		}
	}
	
}
