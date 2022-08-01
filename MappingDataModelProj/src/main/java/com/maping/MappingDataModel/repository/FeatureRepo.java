package com.maping.MappingDataModel.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maping.MappingDataModel.entity.FeatureMapping;

@Repository
public interface FeatureRepo extends JpaRepository<FeatureMapping, Long>{

	
	public FeatureMapping findByFmId(long fmId);
	
//	public List<FeatureMapping> findAll();
	
	
}
