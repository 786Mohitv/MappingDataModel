package com.maping.MappingDataModel.entity;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class FeatureMapping {

	@Id
	private String fmId;
	private String sourceFeature;
	private String targetFeature;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private MappingType mappingType;
	
	public MappingType getMappingType() {
		return mappingType;
	}

	public void setMappingType(MappingType mappingType) {
		this.mappingType = mappingType;
	}



	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			
			name = "Feature_Attribute_Mapping",
			joinColumns = @JoinColumn(
					
					name = "fm_Id",
					referencedColumnName = "fmId" 
			),
			inverseJoinColumns = @JoinColumn(
					
					name = "at_Id",
					referencedColumnName = "atId"
			)
	)	
	private List<AttributeMapping> attributesList = new ArrayList<>();
	
	@Override
	public String toString() {
		return "FeatureMapping [fmId=" + fmId + ", sourceFeature=" + sourceFeature + ", targetFeature=" + targetFeature
				+ ", attributesList="; //+ attributesList+"]";
	}

	

	public FeatureMapping(String sourceFeature, String targetFeature) {
		super();
		this.sourceFeature = sourceFeature;
		this.targetFeature = targetFeature;
		
	}



	public FeatureMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFmId() {
		return fmId;
	}

	public void setFmId(String fmId) {
		this.fmId = fmId;
	}

	public String getSourceFeature() {
		return sourceFeature;
	}

	public void setSourceFeature(String sourceFeature) {
		this.sourceFeature = sourceFeature;
	}

	public String getTargetFeature() {
		return targetFeature;
	}

	public void setTargetFeature(String targetFeature) {
		this.targetFeature = targetFeature;
	}

	public List<AttributeMapping> getAttributesList() {
		return attributesList;
	}

	public void setAttributesList(List<AttributeMapping> attributesList) {
		this.attributesList = attributesList;
	}

	
	
	public void addAttributes(AttributeMapping attributeMapping) {
		
		if(attributesList==null)
			attributesList = new ArrayList<>();		
		attributesList.add(attributeMapping);
		
	}
	
	
	
}
