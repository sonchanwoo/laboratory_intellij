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
@Transactional
@Rollback(value = false)
@Slf4j
public class EntityTests1 {

	@PersistenceContext
	EntityManager em;

	@Test
	void test(){
		Team teamA = new Team("teamA");
		Team teamB = new Team("teamB");

		em.persist(teamA);//buffer.write처럼 이해하자
		em.persist(teamB);

		Member member1 = new Member("member1", 10, teamA);
		Member member2 = new Member("member2", 20, teamA);
		Member member3 = new Member("member3", 30, teamB);

		em.persist(member1);
		em.persist(member2);
		em.persist(member3);

		em.flush();//영속성 컨텍스트와 DB 동기화(차이점 적용)
		em.clear();//em 비우기
	}
	@Test
	void test1(){
		Team teamA = new Team("teamA");

		em.persist(teamA);

		Member member1 = new Member("member1", 10, teamA);

		em.persist(member1);

		em.flush();
		em.clear();
	}
}
