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
public interface FeatureRepo extends JpaRepository<FeatureMapping, Long>, CrudRepository<FeatureMapping, Long>{

	@Transactional
	@Modifying
	public FeatureMapping save(FeatureMapping featureMapping);
	
	@Query(value = "select mappingmodel.feature_mapping.fm_id,source_feature, target_feature ,mappingmodel.attribute_mapping.at_id ,source_attribute, target_attribute  from mappingmodel.feature_mapping join mappingmodel.feature_attribute_mapping on mappingmodel.feature_mapping.fm_id = mappingmodel.feature_attribute_mapping.fm_id join mappingmodel.attribute_mapping on mappingmodel.feature_attribute_mapping.at_id = mappingmodel.attribute_mapping.at_id where mappingmodel.feature_mapping.fm_id = ?1",nativeQuery = true)
	public FeatureMapping findByFmIdnative(long fmId);	
	
}
