package com.huishu.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 车系信息表
 * @Package: com.huishu.bean 
 * @author: xiaobo   
 * @date: 2018年5月3日 上午10:29:48 
 *
 */
@Entity
@Table(name="SysCarInfo")
public class SysCarInfo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2604237641050668960L;
	/**
	 * 主键id 自增长
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id", unique = false, nullable = false)
	private Integer id;
	/**
	 * 品牌
	 */
	@Column(name="Brand")
	private String brand;
	/**
	 * 车系编码
	 */
	@Column(name="CarSeriesCode")
	private String carSeriesCode;
	/**
	 * 车系
	 */
	@Column(name="CarSeries")
	private String carSeries;
	/**
	 * 车型
	 */
	@Column(name="CarModel")
	private String carModel;
	/**
	 * 年代款
	 */
	@Column(name="CarYear")
	private String carYear;
	/**
	 *国家
	 */
	@Column(name="Country")
	private String country;
	
	/**
	 * 状态
	 */
	@Column(name="Status")
	private Integer status;
	/**
	 * 删除标志
	 * 1：有效；0：无效
	 */
	@Column(name="IsDeleted")
	private Boolean isDeleted;
	/**
	 * 创建人
	 */
	@Column(name="CreatedBy")
	private Integer createdBy;
	/**
	 * 创建时间
	 */
	@Column(name="CreatedOn")
	private Timestamp createdOn;
	/**
	 * 修改人
	 */
	@Column(name="ModifiedBy")
	private Integer modifiedBy;
	/**
	 * 修改时间
	 */
	@Column(name="ModifiedOn")
	private Timestamp modifiedOn;
	
	/**
	 * 时间戳
	 */
	@Column(name="DateTimeStamp")
	private Timestamp dateTimeStamp;
	
	/***
	 * 备注
	 */
	@Column(name="Comments")
	private String comments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCarSeriesCode() {
		return carSeriesCode;
	}

	public void setCarSeriesCode(String carSeriesCode) {
		this.carSeriesCode = carSeriesCode;
	}

	public String getCarSeries() {
		return carSeries;
	}

	public void setCarSeries(String carSeries) {
		this.carSeries = carSeries;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarYear() {
		return carYear;
	}

	public void setCarYear(String carYear) {
		this.carYear = carYear;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Timestamp getDateTimeStamp() {
		return dateTimeStamp;
	}

	public void setDateTimeStamp(Timestamp dateTimeStamp) {
		this.dateTimeStamp = dateTimeStamp;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
