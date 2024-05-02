package com.maelmainsard.exofinal.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maelmainsard.exofinal.entities.Etudiant;


@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> {
 
 public Etudiant findByName(String name);
}