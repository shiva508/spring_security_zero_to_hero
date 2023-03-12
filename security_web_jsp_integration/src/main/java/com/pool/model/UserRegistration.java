package com.pool.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
public class UserRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userRegistrationId;
	private Integer userid;
	@Embedded
	private UserName userName;
	@Embedded
	private Emails emails;
	@Override
	public String toString() {
		return "UserRegistration [userRegistrationId=" + userRegistrationId + ", userid=" + userid + ", userName="
				+ userName + "]";
	}
}
