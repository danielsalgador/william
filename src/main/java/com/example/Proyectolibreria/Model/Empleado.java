package com.example.Proyectolibreria.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;

    private String nombre;
    private String cargo;
    private String telefono;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<Venta> ventas;
}
