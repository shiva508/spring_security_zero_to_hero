package com.pool.model;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="RANKING")
public class Ranking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer rankingId;
	@ManyToOne
	private Product product;
	private Integer ranking;

	public Ranking() {
	}

	public Integer getRankingId() {
		return rankingId;
	}

	public void setRankingId(Integer rankingId) {
		this.rankingId = rankingId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		return "Ranking [product=" + product + ", ranking=" + ranking + "]";
	}
}
