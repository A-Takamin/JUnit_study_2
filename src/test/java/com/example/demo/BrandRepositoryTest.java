package com.example.demo;

import java.util.List;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.Brand.Gender;

@ExtendWith(SpringExtension.class)
public class BrandRepositoryTest {

	@Nested
	@DataJpaTest
	class FindByGender {
		@Autowired
		private TestEntityManager entityManager;
		@Autowired
		private BrandRepository brandRepository;
		
		@BeforeEach
		void beforeEach() {
			// persist()は、オブジェクトをDBに追加するメソッド
			entityManager.persist(new Brand("STOF", Gender.UNISEX));
			entityManager.persist(new Brand("ETHOSENS", Gender.MAN));
			entityManager.persist(new Brand("dulcamera", Gender.UNISEX));
		}
		
		@Test
		void man() {
			List<Brand> brands = brandRepository.findByGender(Gender.MAN);
			org.assertj.core.api.Assertions.assertThat(brands)
	        .extracting(Brand::getName, Brand::getGender)
	        .containsExactly(Tuple.tuple("ETHOSENS", Gender.MAN));
		}
		
		@Test
		void woman() {
	            List<Brand> brands = brandRepository.findByGender(Gender.WOMAN);
		    org.assertj.core.api.Assertions.assertThat(brands)
						.hasSize(0);
		}
	}
}
