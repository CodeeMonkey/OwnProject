package com.realdolmen.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("E")
@Table(name = "user", schema = "realdolmen")
public class EmployeeEntity extends UserEntity{

	private String department;
}
