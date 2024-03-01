package com.example.SpringPro.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="Student_DB")
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;
    @Column(name="ST_MARK")
    private int mark;
    @Column(name="NAME")
    private String name;



}
