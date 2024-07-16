package com.smartnet.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartnet.projet.Model.Fournisseur;



@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long>{

}
