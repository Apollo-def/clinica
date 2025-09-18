package com.clinic.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "consultas")
public class Consulta {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne(optional = false)
@JoinColumn(name = "paciente_id")
private Paciente paciente;


@NotBlank
private String medico;


@NotNull
private LocalDate dataConsulta;


@NotNull
private LocalTime horario;


@Enumerated(EnumType.STRING)
private Status status = Status.AGENDADO;


public enum Status { AGENDADO, REALIZADO, CANCELADO }


public Consulta() {}


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }


public Paciente getPaciente() { return paciente; }
public void setPaciente(Paciente paciente) { this.paciente = paciente; }


public String getMedico() { return medico; }
public void setMedico(String medico) { this.medico = medico; }


public LocalDate getDataConsulta() { return dataConsulta; }
public void setDataConsulta(LocalDate dataConsulta) { this.dataConsulta = dataConsulta; }


public LocalTime getHorario() { return horario; }
public void setHorario(LocalTime horario) { this.horario = horario; }


public Status getStatus() { return status; }
public void setStatus(Status status) { this.status = status; }
}