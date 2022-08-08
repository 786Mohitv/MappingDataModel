package com.maping.MappingDataModel.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.maping.MappingDataModel.entity.FeatureMapping;

@Repository
public interface FeatureRepo extends JpaRepository<FeatureMapping, Long>{

	
	public FeatureMapping findByFmId(long fmId);	
//	
//	@Transactional
//	@Modifying	
//	@Query(value = "update feature_mapping set source_feature = ?2 , target_feature = ?3 where fm_id= ?1", nativeQuery = true
//	)
//	int updateFeatureMappingById( Long fmId, String  sourceFeature, String targetFeature);
//	
//	@Transactional
//	@Modifying
//	@Query(value = "update attribute_mapping set source_attribute = ?1, target_attribute = ?2 where at_id = ?1", nativeQuery = true)
//	int updateAttributesByFmId(Long atId, String sourceAttribute, String targetAttribute);
//		
	
	
}
