package com.pool.dress.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "DRESS")
public class DressModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DRESS_NUMBER")
	private Integer dressId;
	
	@NotBlank(message = "Dress name can not be blank")
	@Column(name = "DRESS_NAME",unique = true)
	private String name;
	
	@Column(name = "DRESS_CODE",updatable = true,unique = true)
	private String dressCode;
	
	@Temporal(TemporalType.DATE)
	@Basic
	@Column(name="DRESS_CREATED_DATE",updatable = false)
	private Date createdDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DRESS_UPDATED_DATE",updatable = true)
	@Basic
	private Date updatedDate;
	
	@Lob
	private String image;
	
	@Column(name = "OFFER_START")
	@Temporal(TemporalType.DATE)
	//@JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date offerStartAt;
	
	@Column(name = "OFFER_END")
	@Temporal(TemporalType.DATE)
	//@JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date offerEndsAt;
	
	@Column(name = "IS_OFFER_AVAILBLE")
	private Boolean isOfferAvailable;
	
	@OneToMany(
			mappedBy = "dressModel",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	//@JoinColumn(name="dressImageId") Uni directional
	private List<DressImages> dressImages=new ArrayList<>();
	
	public DressModel() {
		
	}

	public Integer getDressId() {
		return dressId;
	}

	public void setDressId(Integer dressId) {
		this.dressId = dressId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = new Date();
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = new Date();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getDressCode() {
		return dressCode;
	}

	public void setDressCode(String dressCode) {
		this.dressCode = dressCode;
	}
	
	public Date getOfferStartAt() {
		return offerStartAt;
	}

	public void setOfferStartAt(Date offerStartAt) {
		this.offerStartAt = offerStartAt;
	}

	public Date getOfferEndsAt() {
		return offerEndsAt;
	}

	public void setOfferEndsAt(Date offerEndsAt) {
		this.offerEndsAt = offerEndsAt;
	}

	public Boolean getIsOfferAvailable() {
		return isOfferAvailable;
	}

	public void setIsOfferAvailable(Boolean isOfferAvailable) {
		this.isOfferAvailable = isOfferAvailable;
	}

	public List<DressImages> getDressImages() {
		return dressImages;
	}

	public void setDressImages(List<DressImages> dressImages) {
		this.dressImages = dressImages;
	}

	public void addImages(DressImages dressImage) {
		dressImages.add(dressImage);
		dressImage.setDressModel(this);
	}
	
	@Override
	public String toString() {
		return "DressModel [dressId=" + dressId + ", name=" + name + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", image=" + image + "]";
	}
	
}
