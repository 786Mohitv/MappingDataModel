package com.maping.MappingDataModel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maping.MappingDataModel.entity.AttributeMapping;

@Repository
public interface AttributeRepo extends JpaRepository<AttributeMapping,Long>{
	
	
	
}
