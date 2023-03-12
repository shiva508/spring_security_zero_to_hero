package com.pool.form;

public class RankingResponse {
private Integer totalNumberOfvotes;
private Integer productRank;
private Integer percentage;
public RankingResponse() {
	super();
	// TODO Auto-generated constructor stub
}
public Integer getTotalNumberOfvotes() {
	return totalNumberOfvotes;
}
public void setTotalNumberOfvotes(Integer totalNumberOfvotes) {
	this.totalNumberOfvotes = totalNumberOfvotes;
}
public Integer getProductRank() {
	return productRank;
}
public void setProductRank(Integer productRank) {
	this.productRank = productRank;
}

public Integer getPercentage() {
	return percentage;
}
public void setPercentage(Integer percentage) {
	this.percentage = percentage;
}
@Override
public String toString() {
	return "RankingResponse [totalNumberOfvotes=" + totalNumberOfvotes + ", productRank=" + productRank
			+ ", percentage=" + percentage + "]";
}

}
