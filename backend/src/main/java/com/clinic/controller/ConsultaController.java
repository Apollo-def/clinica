package com.clinic.controller;
import com.clinic.model.Consulta;
import com.clinic.service.ConsultaService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/consultas")
@CrossOrigin(origins = "*")
public class ConsultaController {
    private final ConsultaService service;
    public ConsultaController(ConsultaService service){ this.service = service; }

    @GetMapping
    public List<Consulta> all(){ return service.findAll(); }

    @GetMapping("/{id}")
    public Consulta get(@PathVariable Long id){ return service.findById(id); }

    @PostMapping
    public Consulta create(@Valid @RequestBody Consulta c){ return service.create(c); }

    @PutMapping("/{id}")
    public Consulta update(@PathVariable Long id, @Valid @RequestBody Consulta c){ return service.update(id, c); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){ service.delete(id); }
}
