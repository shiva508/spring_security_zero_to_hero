package com.pool.model;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@Setter
@Getter
public class UserName {
private String firstName;
private String middleName;
private String lastName;
@Override
public String toString() {
	return "UserName [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
}

}
