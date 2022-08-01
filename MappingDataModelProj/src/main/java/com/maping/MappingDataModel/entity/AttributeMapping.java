package com.maping.MappingDataModel.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class AttributeMapping {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long atId;
	private String sourceAttribute;
	private String targetAttribute;
	
	
	@ManyToMany(
			mappedBy = "attributesList",
			cascade = CascadeType.ALL	
			
	)	
	private List<FeatureMapping> featuresList;

	
	@Override
	public String toString() {
		return "AttributeMapping [atId=" + atId + ", sourceAttribute=" + sourceAttribute + ", targetAttribute="
				+ targetAttribute + ", featuresList=" + featuresList + "]";
	}

	public AttributeMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttributeMapping(String sourceAttribute, String targetAttribute) {
		super();
		this.sourceAttribute = sourceAttribute;
		this.targetAttribute = targetAttribute;
	}

	public long getAtId() {
		return atId;
	}

	public void setAtId(long atId) {
		this.atId = atId;
	}

	public String getSourceAttribute() {
		return sourceAttribute;
	}

	public void setSourceAttribute(String sourceAttribute) {
		this.sourceAttribute = sourceAttribute;
	}

	public String getTargetAttribute() {
		return targetAttribute;
	}

	public void setTargetAttribute(String targetAttribute) {
		this.targetAttribute = targetAttribute;
	}

	public List<FeatureMapping> getFeaturesList() {
		return featuresList;
	}

	public void setFeaturesList(List<FeatureMapping> featuresList) {
		this.featuresList = featuresList;
	}

	
//	public void addAttributes(FeatureMapping featureMapping) {
//		
//		if(featuresList==null)
//			featuresList = new ArrayList<>();
//		else
//			featuresList.add(featureMapping);
//		
//	}
	
}