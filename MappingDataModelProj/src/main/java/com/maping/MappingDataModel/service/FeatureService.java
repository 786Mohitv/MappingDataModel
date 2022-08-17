package com.maping.MappingDataModel.service;

import java.util.ArrayList;
import java.util.List;

import javax.management.AttributeList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maping.MappingDataModel.entity.AttributeMapping;
import com.maping.MappingDataModel.entity.FeatureMapping;
import com.maping.MappingDataModel.entity.MappingType;
import com.maping.MappingDataModel.repository.AttributeRepo;
import com.maping.MappingDataModel.repository.FeatureRepo;
import com.maping.MappingDataModel.repository.MappingTypeRepo;

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

	@Autowired
	MappingTypeRepo mappingTypeRepo;

	public List<FeatureMapping> getAllFeatureMapp() {
		return featureRepo.findAll();

	}

	public void saveFeatureMappingWithAttributeMapping(FeatureMapping featureMapping) {
		List<AttributeMapping> attributeList = featureMapping.getAttributesList();
		System.out.println(featureMapping.getMappingType().getTypeId());
		String fmIdString = generateFmID(featureMapping.getMappingType().getTypeId());
		featureMapping.setFmId(fmIdString);
		featureRepo.save(featureMapping);
	}

	public void deleteFeatureMappingById(String fmId) {
		featureRepo.deleteById(fmId);
	}

	public void updateFeatureMapping(String fmId, FeatureMapping featureMapping) {

		FeatureMapping featureMappingOld = featureRepo.findByFmIdnative(fmId);

		List<AttributeMapping> temp = new ArrayList(featureMappingOld.getAttributesList());
		featureMappingOld.setSourceFeature(featureMapping.getSourceFeature());
		featureMappingOld.setTargetFeature(featureMapping.getTargetFeature());
		featureMappingOld.setAttributesList(featureMapping.getAttributesList());
		featureRepo.save(featureMappingOld);

		List<Long> idsIntegers = new ArrayList<>();
		for (AttributeMapping attributeMapping : temp) {
			idsIntegers.add(attributeMapping.getAtId());
		}
		attributeRepo.deleteAllById(idsIntegers);
	}

	public void saveMappingType(MappingType mappingType) {
		mappingTypeRepo.save(mappingType);
	}

	public List<MappingType> getAllMappingType() {
		return mappingTypeRepo.findAll();
	}

	public String generateFmID(String prefixId) {
		String fmIdString = prefixId;
		FeatureMapping featureMapping = featureRepo.getAllSortedByTypeId(prefixId);
		if (featureMapping == null) {
			fmIdString = prefixId + "_001";
		} else {

			String num = featureMapping.getFmId();
			num = num.substring(num.length() - 3, num.length());
			num = Integer.toString(Integer.parseInt(num) + 1);
			if (num.length() == 1)
				num = "00" + num;
			else if (num.length() == 2)
				num = "0" + num;

			fmIdString = prefixId + "_" + num;
		}

		return fmIdString;
	}
}
