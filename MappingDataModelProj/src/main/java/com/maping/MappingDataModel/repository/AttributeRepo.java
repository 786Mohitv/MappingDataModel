package com.maping.MappingDataModel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maping.MappingDataModel.entity.AttributeMapping;

@Repository
public interface AttributeRepo extends CrudRepository<AttributeMapping,Long>{
	
	@Transactional
	@Modifying
	public void deleteAllById(Iterable<? extends Long> ids);
	
}
