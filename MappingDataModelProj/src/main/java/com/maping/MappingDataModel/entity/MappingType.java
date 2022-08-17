package com.maping.MappingDataModel.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MappingType {

	@Id
	private String typeId;	
	@Override
	public String toString() {
		return "MappingType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public MappingType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MappingType(String typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}
	private String typeName;
	
	
}
