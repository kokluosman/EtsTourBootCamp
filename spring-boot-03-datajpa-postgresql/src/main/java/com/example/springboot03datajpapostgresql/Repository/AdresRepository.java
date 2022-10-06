package com.example.springboot03datajpapostgresql.Repository;

import com.example.springboot03datajpapostgresql.Entity.Adres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresRepository extends JpaRepository<Adres,Long> {

}
