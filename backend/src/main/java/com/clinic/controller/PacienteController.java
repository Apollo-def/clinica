package com.clinic.controller;
import com.clinic.model.Paciente;
import com.clinic.service.PacienteService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {
    private final PacienteService service;
    public PacienteController(PacienteService service){ this.service = service; }

    @GetMapping
    public List<Paciente> all(){ return service.findAll(); }

    @GetMapping("/{id}")
    public Paciente get(@PathVariable Long id){ return service.findById(id); }

    @PostMapping
    public Paciente create(@Valid @RequestBody Paciente p){ return service.save(p); }

    @PutMapping("/{id}")
    public Paciente update(@PathVariable Long id, @Valid @RequestBody Paciente p){ return service.update(id, p); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){ service.delete(id); }
}
