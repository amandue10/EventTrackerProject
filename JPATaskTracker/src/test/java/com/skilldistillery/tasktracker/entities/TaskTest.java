package com.skilldistillery.tasktracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Task task;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPATaskTracker");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		task = em.find(Task.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		task = null;
	}

	@Test
	void test_Task_entity_mapping() {
		assertNotNull(task);
		assertEquals("Go to store", task.getName());
		assertEquals("List: Apples, Eggs, Milk", task.getDetails());
		assertEquals("1155 S. Havana Rd Aurora, CO 80247", task.getLocation());
//		assertEquals(2021-12-12, task.getDate());
		assertEquals("00:00:00", task.getTime());
		assertEquals("Shopping", task.getCategory());
		assertEquals("Low", task.getPriorityLevel());
		assertEquals("20$ budget", task.getNotes());
		assertEquals("Not complete", task.getStatus());
	}




}
