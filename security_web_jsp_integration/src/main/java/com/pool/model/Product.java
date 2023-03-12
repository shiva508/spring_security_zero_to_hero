package com.pool.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="PRODUCT")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCT_ID")
	private Integer productId;
	private String productMame;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="product",orphanRemoval=true)
	private List<Features> featurs;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="product",orphanRemoval=true)
	private List<Ranking> ranking;

	public Product() {

	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductMame() {
		return productMame;
	}

	public void setProductMame(String productMame) {
		this.productMame = productMame;
	}

	public List<Features> getFeaturs() {
		if(featurs==null) {
			featurs=new ArrayList<>();
		}
		return featurs;
	}

	public void setFeaturs(List<Features> featurs) {
		this.featurs = featurs;
	}

	public List<Ranking> getRanking() {
		if(ranking==null) {
			ranking=new ArrayList<>();
		}
		return ranking;
	}

	public void setRanking(List<Ranking> ranking) {
		this.ranking = ranking;
	}

	public void addRankin(Ranking newRanking) {
		newRanking.setProduct(this);
		getRanking().add(newRanking);
	}
	public void addFeature(Features newFeature) {
		newFeature.setProduct(this);
		getFeaturs().add(newFeature);
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productMame=" + productMame + ", featurs=" + featurs
				+ ", ranking=" + ranking + "]";
	}

}
