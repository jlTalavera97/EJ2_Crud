package com.example.demo.model;


import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSONA")
public class Persona {

    @Id
    @GeneratedValue
    @Column
    private Integer id_persona;

    @NonNull
    @Column(name = "usuario")
    private String usuario;

    @NonNull
    @Column
    private String password;

    @NonNull
    @Column
    private String name;

    @Column
    private String surname;

    @NonNull
    @Column
    private String company_email;

    @NonNull
    @Column
    private String personal_email;

    @NonNull
    @Column
    private String city;

    @NonNull
    @Column
    private Boolean active;

    @NonNull
    @Column
    private String created_date;

    @Column
    private String imagen_url;

    @Column
    private String termination_date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Persona persona = (Persona) o;
        return id_persona != null && Objects.equals(id_persona, persona.id_persona);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
