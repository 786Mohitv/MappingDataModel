package com.maping.MappingDataModel.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AttributeRepoTest {

	@Autowired
	private AttributeRepo attributeRepo;

	@Test
	public void printAllAttributes() {
		System.out.println(attributeRepo.findAll());
	}

}
