package com.example.course.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "ementa")
    private String ementa;

    @CreationTimestamp
    private Date dataCadastro;

    @Column(name = "data_inicio")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataInicio;

    @Column(name = "valor")
    private float valor;

}
