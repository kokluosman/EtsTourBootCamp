package com.example.springboot03datajpapostgresql.Repository;

import com.example.springboot03datajpapostgresql.Entity.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KisiRepository extends JpaRepository<Kisi,Long> {
}
