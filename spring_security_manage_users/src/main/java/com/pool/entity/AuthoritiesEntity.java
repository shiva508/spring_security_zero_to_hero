package com.pool.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authorities")
@Data
@NoArgsConstructor
public class AuthoritiesEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long authorityId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "authority")
	private String authority;
}
