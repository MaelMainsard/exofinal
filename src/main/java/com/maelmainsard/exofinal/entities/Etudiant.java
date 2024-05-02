package com.maelmainsard.exofinal.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Etudiant")
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private Integer age;
	 
	public Etudiant(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public Etudiant() {
	}
	
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	} 


}
