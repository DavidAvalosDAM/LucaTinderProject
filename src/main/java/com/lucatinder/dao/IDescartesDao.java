package com.lucatinder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucatinder.model.Descartes;
/**
 * Esta interface hereda de JpaRepository, que nos ayuda con el trato con la bbdd
 * @author Yolanda
 * @version 1.0
 * @date 21/10/2019 
  */


public interface IDescartesDao extends JpaRepository<Descartes, Integer>  {
	
	

}