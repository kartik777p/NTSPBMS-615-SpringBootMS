package com.nit.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Tourist implements Serializable {
	@Id
    private String tNo;
    private String tName;
    private String addrs;
    private Long moNumber;
    private String passNumber;
    private Boolean isVaccinated;
}
