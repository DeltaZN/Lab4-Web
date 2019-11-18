package ru.itmo.Lab4.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;

    private String password;

    @Transient
    private String passwordConfirm;

}
