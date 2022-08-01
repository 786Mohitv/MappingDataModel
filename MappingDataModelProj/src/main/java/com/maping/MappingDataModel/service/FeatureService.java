package com.maping.MappingDataModel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maping.MappingDataModel.entity.FeatureMapping;
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

	public FeatureService(List featureMappList) {
		super();
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
	public List<FeatureMapping> getAllFeatureMapp() {
		return featureRepo.findAll();
	}
	
}
