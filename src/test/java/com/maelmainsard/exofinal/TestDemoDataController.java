package com.maelmainsard.exofinal;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.maelmainsard.exofinal.entities.Etudiant;
import com.maelmainsard.exofinal.repositories.EtudiantRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class TestDemoDataController {
	 @Autowired
	 private EtudiantRepository repo;
	 
	 @Test
	 @Rollback(false)
	 @Order(1)
	 public void testCreateStudent() {
		 Etudiant savedStudent = repo.save(new Etudiant("Maël Mainsard", 22));
		 assertThat(savedStudent.getId()).isGreaterThan(0);
	 }
	 
	 @Test
	 @Order(2)
	 public void testFindStudentByName() {
		 Etudiant student = repo.findByName("Maël Mainsard"); 
	 	 assertThat(student.getName()).isEqualTo("Maël Mainsard");
	 }

	 @Test
	 @Rollback(true)
	 @Order(3)
	 public void testUpdateStudent() {
		 Etudiant student = repo.findByName("Maël Mainsard");
		 student.setAge(26);
		 
		 repo.save(student);
		 
		 Etudiant updatedStudent = repo.findByName("Maël Mainsard");
		 
		 assertThat(updatedStudent.getAge()).isEqualTo(26);
	 }
	 
	 @Test
	 @Rollback(false)
	 @Order(4)
	 public void testDeleteStudent() {
		 Etudiant student = repo.findByName("Maël Mainsard");
		 
		 repo.deleteById(student.getId());
		 
		 Etudiant deletedStudent = repo.findByName("Maël Mainsard");
		 
		 assertThat(deletedStudent).isNull(); 
	 
	 }
}
