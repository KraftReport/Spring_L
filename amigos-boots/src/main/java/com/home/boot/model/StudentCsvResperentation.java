package com.home.boot.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class StudentCsvResperentation {
	
	@CsvBindByName(column = "name")
	private String name;
	@CsvBindByName(column = "email")
	private String eamil;
	@CsvBindByName(column = "dob")
	private String dob; 

}
