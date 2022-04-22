package com.example.javaspring.Student;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Student {
    @Id
    private String rollNumber;
    private String fullName;
    private String Email;
    private String Address;
    private int Status;


}
