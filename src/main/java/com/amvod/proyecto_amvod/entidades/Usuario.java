package com.amvod.proyecto_amvod.entidades;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nickname;

    @Column(unique = true)
    private String email;

    private String imagen;

    @Column(unique = true)
    private String auth0Id;

    public Usuario() {
    }

    public Usuario(String nickname, String email, String imagen, String auth0Id) {
        this.nickname = nickname;
        this.email = email;
        this.imagen = imagen;
        this.auth0Id = auth0Id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getAuth0Id() {
        return auth0Id;
    }

    public void setAuth0Id(String auth0Id) {
        this.auth0Id = auth0Id;
    }
}
