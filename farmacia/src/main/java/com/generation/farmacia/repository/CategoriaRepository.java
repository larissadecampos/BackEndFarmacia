package com.generation.farmacia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.generation.farmacia.Model.CategoriaModel;

	@Repository
	public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{
		public List<CategoriaModel>findAllByTituloContainingIgnoreCase(String titulo);
		
	}


//No JpaRepository vamos chamar tabela(CategoriaModel) e o tipo de dado(long) da chave primária da tabela.
//List vai pegar a tabela CategoriaModel, trazer uma lista da <tabela> e vai encontrar tudo que contem o que foi buscado.
