package com.nit.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CaronaPetient {
    private Long id;
    private String pName;
    private Integer age;
    private String hospitalName;
    private Date admit_Date;
    private Date discharge_Date;
    private String city;
}
