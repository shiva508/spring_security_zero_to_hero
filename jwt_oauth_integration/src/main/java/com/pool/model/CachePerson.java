package com.pool.model;


import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "CACHE_PERSON")
@Cache(region="personCache",usage=CacheConcurrencyStrategy.READ_WRITE)
@NamedQuery(name="GET_TOTAL_PERSONS_COUNT",query="select count(1) from CachePerson")
@NamedQueries({
	@NamedQuery(name="GET_PERSON_NAME",query="select personName from CachePerson where cachePersonId=:cachePersonId"),
	@NamedQuery(name="GET_ALL_PERSONS",query="from CachePerson")
})
public class CachePerson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cachePersonId;
	private String personName;
	public CachePerson() {
	
	}
	public CachePerson(String personName) {
		this.personName = personName;
	}
	public Integer getCachePersonId() {
		return cachePersonId;
	}
	public void setCachePersonId(Integer cachePersonId) {
		this.cachePersonId = cachePersonId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	@Override
	public String toString() {
		return "CachePerson [cachePersonId=" + cachePersonId + ", personName=" + personName + "]";
	}
}
