package com.example.laboratoryidea.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
//@Transactional
//@Rollback(value = false)
@Slf4j
public class EntityTests1 {

	@PersistenceContext
	EntityManager em;

	@Test
	void testExist(){

	}

	@Test
	@DisplayName("일단 관계 제외한 임시 클래스 만들어서, BaseEntity 잘 동작하나 확인겸, sql로그 확인겸, em사용법 숙지겸")
	void test1(){
		MemberTMP tmp = new MemberTMP();
		tmp.setUsername("chanwoo");
		tmp.setAge(30);

		em.persist(tmp);
	}

}
