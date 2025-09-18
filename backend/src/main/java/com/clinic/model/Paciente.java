package com.clinic.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;


@Entity
@Table(name = "pacientes")
public class Paciente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@NotBlank
private String nome;


@NotBlank
@Column(unique = true)
private String cpf;


private LocalDate dataNascimento;
private String telefone;


@Email
private String email;


public Paciente() {}


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }


public String getNome() { return nome; }
public void setNome(String nome) { this.nome = nome; }


public String getCpf() { return cpf; }
public void setCpf(String cpf) { this.cpf = cpf; }


public LocalDate getDataNascimento() { return dataNascimento; }
public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }


public String getTelefone() { return telefone; }
public void setTelefone(String telefone) { this.telefone = telefone; }


public String getEmail() { return email; }
public void setEmail(String email) { this.email = email; }
}