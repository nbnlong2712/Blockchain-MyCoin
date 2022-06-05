package com.example.blockchain.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "peer")
public class Peer implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username",nullable = false, unique = true)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;

    public Peer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Peer() {}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}