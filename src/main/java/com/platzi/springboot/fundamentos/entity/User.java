package com.platzi.springboot.fundamentos.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", nullable = false, unique = true)
    private Long id;

    @Column(name="email",  length = 50)
    private String email;

    @Column(name= "name", length = 50)
    private String name;
    private LocalDate birthdate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Post> post = new ArrayList<>();


    public User(String name, String email, LocalDate birthdate) {

        this.email = email;
        this.name = name;
        this.birthdate = birthdate;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", post=" + post +
                '}';
    }

    /**
     * get field @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="id_user", unique = true)

      *
      * @return id @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="id_user", unique = true)

     */
    public Long getId() {
        return this.id;
    }

    /**
     * set field @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="id_user", unique = true)

      *
      * @param id @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="id_user", unique = true)

     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get field @Column(name="email",  length = 50)
     *
     * @return email @Column(name="email",  length = 50)

     */
    public String getEmail() {
        return this.email;
    }

    /**
     * set field @Column(name="email",  length = 50)
     *
     * @param email @Column(name="email",  length = 50)

     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get field @Column(name= "name", length = 50)
     *
     * @return name @Column(name= "name", length = 50)

     */
    public String getName() {
        return this.name;
    }

    /**
     * set field @Column(name= "name", length = 50)
     *
     * @param name @Column(name= "name", length = 50)

     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get field @Column(name = "birthdate")
     *
     * @return birthdate @Column(name = "birthdate")

     */
    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    /**
     * set field @Column(name = "birthdate")
     *
     * @param birthdate @Column(name = "birthdate")

     */
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * get field @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @JsonManagedReference

      *
      * @return post @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @JsonManagedReference

     */
    public List<Post> getPost() {
        return this.post;
    }

    /**
     * set field @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @JsonManagedReference

      *
      * @param post @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @JsonManagedReference

     */
    public void setPost(List<Post> post) {
        this.post = post;
    }
}
