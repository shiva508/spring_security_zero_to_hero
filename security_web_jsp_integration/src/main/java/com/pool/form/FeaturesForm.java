package com.pool.form;

public class FeaturesForm {
	private Integer featureId;
	private String feature;
	public FeaturesForm() {
		super();
	}
	public Integer getFeatureId() {
		return featureId;
	}
	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	@Override
	public String toString() {
		return "FeaturesForm [featureId=" + featureId + ", feature=" + feature + "]";
	}
	
}
