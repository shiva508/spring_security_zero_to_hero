package com.pool.model;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@Setter
@Getter
public class Emails {
private String personalEmail;
private String officialEmail;
@Override
public String toString() {
	return "Emails [personalEmail=" + personalEmail + ", officialEmail=" + officialEmail + "]";
}

}
