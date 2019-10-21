package com.lucatinder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lucatinder.model.Contactos;

public interface IContactoDao extends JpaRepository<Contactos, Integer> {

}
