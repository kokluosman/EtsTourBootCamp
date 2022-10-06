package com.example.springboot03datajpapostgresql.controller;

import com.example.springboot03datajpapostgresql.Service.KisiServis;
import com.example.springboot03datajpapostgresql.dto.KisiDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kisi")
public class KisiController {
    private final KisiServis kisiServis;

    @PostMapping
    public ResponseEntity<KisiDto> kaydet(@Valid @RequestBody KisiDto kisiDto){
        return ResponseEntity.ok(kisiServis.save(kisiDto));
    }

    @GetMapping
    public ResponseEntity<List<KisiDto >> tumunulistele(){
        return ResponseEntity.ok(kisiServis.getAll());
    }

}
