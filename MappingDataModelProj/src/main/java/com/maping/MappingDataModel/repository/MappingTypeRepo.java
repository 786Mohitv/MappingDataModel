package com.maping.MappingDataModel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.maping.MappingDataModel.entity.MappingType;

public interface MappingTypeRepo extends JpaRepository<MappingType, String>,CrudRepository<MappingType, String> {

}
