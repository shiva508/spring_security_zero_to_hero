package com.pool.form;
public class RankingForm {
	private Integer rankingId;
	private Integer ranking;
	public RankingForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getRankingId() {
		return rankingId;
	}
	public void setRankingId(Integer rankingId) {
		this.rankingId = rankingId;
	}
	public Integer getRanking() {
		return ranking;
	}
	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}
	@Override
	public String toString() {
		return "RankingForm [rankingId=" + rankingId + ", ranking=" + ranking + "]";
	}
	
	
}
