package com.clinic.repository;


import com.clinic.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
List<Consulta> findByPacienteId(Long pacienteId);
}