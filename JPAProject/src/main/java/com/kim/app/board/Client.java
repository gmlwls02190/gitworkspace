package com.kim.app.board;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Client {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em=emf.createEntityManager(); // DAO클래스 생성파트
		
		EntityTransaction et=em.getTransaction();
		
		try {
			et.begin(); // 트랜잭션 단위 시작
			
			Gallery gallery=new Gallery();
			gallery.setId("tester");
			gallery.setTitle("title");
			gallery.setArtist("test");
			gallery.setInfo("gallery test");
			gallery.setGallery("gallery");
			gallery.setWdate(new Date());
			
			em.persist(gallery); // insert문을 생성
			
			et.commit(); // 트랜잭션 처리가 끝나면 커밋
			
			// JPQL: sql문들의 표준.JPA구현체가 읽어들여서 해당DBMS의 sql문으로 처리
			String jpql="select g from Gallery g";
			List<Gallery> datas=em.createQuery(jpql,Gallery.class).getResultList();
			for(Gallery v:datas) {
				System.out.println("JPA: "+v);
			}
			
		}catch(Exception e) {
			et.rollback(); // 트랜잭션 작업중 오류 발생시 롤백
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
		
	}
}
