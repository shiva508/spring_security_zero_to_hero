package com.pool.form;

import java.util.List;
public class ProductForm {
	private Integer productId;
	private String productMame;
	private List<FeaturesForm> featursList;
	private List<RankingForm> rankingList;
	
	private RankingResponse rankingResponse;
	public ProductForm() {
		super();
		
	}
	
	public RankingResponse getRankingResponse() {
		return rankingResponse;
	}

	public void setRankingResponse(RankingResponse rankingResponse) {
		this.rankingResponse = rankingResponse;
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
	public List<FeaturesForm> getFeatursList() {
		return featursList;
	}
	public void setFeatursList(List<FeaturesForm> featursList) {
		this.featursList = featursList;
	}
	public List<RankingForm> getRankingList() {
		return rankingList;
	}
	public void setRankingList(List<RankingForm> rankingList) {
		this.rankingList = rankingList;
	}

	@Override
	public String toString() {
		return "ProductForm [productId=" + productId + ", productMame=" + productMame + ", featursList=" + featursList
				+ ", rankingList=" + rankingList + ", rankingResponse=" + rankingResponse + "]";
	}
		
	
}
