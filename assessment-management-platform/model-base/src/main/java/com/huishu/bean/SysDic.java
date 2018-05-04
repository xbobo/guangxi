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
 * 基础字典表
 * @Package: com.huishu.bean 
 * @author: xiaobo   
 * @date: 2018年4月27日 上午11:20:14 
 *
 */
@Entity
@Table(name="SysDic")
public class SysDic implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5334416298292571756L;
	/**
	 * 主键id 自增长
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private Integer id;
	/**
	 * 名称
	 */
	@Column(name="Name")
	private String name;
	/**
	 * 标识
	 */
	@Column(name="Mark")
	private String mark;
	/**
	 * 类型
	 */
	@Column(name="Type")
	private String type;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
