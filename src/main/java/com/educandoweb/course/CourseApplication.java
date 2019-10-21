package com.educandoweb.course;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.educandoweb.course.entities.Order;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);	
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM tb_order");
		List<Object[]> list = new ArrayList<>();
		list = q.getResultList();
		
		for(Object[] o : list) {
			System.out.println("Id: " + o[0] + " Moment: "+o[1] + "Status: " + o[2] + " Cliente: " +o[3]);
		}
		em.close();
		emf.close();
	}

}
