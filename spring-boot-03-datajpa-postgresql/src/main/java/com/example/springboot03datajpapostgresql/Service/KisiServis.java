package com.example.springboot03datajpapostgresql.Service;

import com.example.springboot03datajpapostgresql.dto.KisiDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KisiServis {
    KisiDto save(KisiDto kisiDto);

    void delete(long id);

    List<KisiDto> getAll();
    Page<KisiDto> getAll(Pageable pageable);

}
