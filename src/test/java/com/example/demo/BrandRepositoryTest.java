package com.example.demo;

import java.util.List;

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
			System.out.println("データ投入");
			entityManager.persist(new Brand("STOF", Gender.MAN));
			entityManager.persist(new Brand("ETHOSENS", Gender.MAN));
			entityManager.persist(new Brand("dulcamera", Gender.MAN));
		}

		@Test
		void test1() {
			List<Brand> brands = brandRepository.findByGender(Gender.MAN);

			System.out.println("テスト1");
			System.out.println("brand中身:");
			brands.stream().forEachOrdered(e -> System.out.println(e.getId() + " : " + e.getName()));
		}
		
		@Test
		void test2() {
			List<Brand> brands = brandRepository.findByGender(Gender.MAN);

			System.out.println("テスト2");
			System.out.println("brand中身:");
			brands.stream().forEachOrdered(e -> System.out.println(e.getId() + " : " + e.getName()));
		}
		
		
		@Test
		void test3() {
			List<Brand> brands = brandRepository.findByGender(Gender.MAN);

			System.out.println("テスト3");
			System.out.println("brand中身:");
			System.out.println(brands.stream().count());
			brands.stream().forEachOrdered(e -> System.out.println(e.getId() + " : " + e.getName()));
		}

	
		
		/**
		 * メモ
		 * この書き方だと、連番は増え続ける。
		 * 
		 * 
		 * 
		 */
	}
}
