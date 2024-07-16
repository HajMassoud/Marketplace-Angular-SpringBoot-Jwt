package com.smartnet.projet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smartnet.projet.Model.Lpanier;


@Repository
public interface LpanierRepository extends JpaRepository<Lpanier, Long>{

	List<Lpanier> findAllByNumero(int numero);



}