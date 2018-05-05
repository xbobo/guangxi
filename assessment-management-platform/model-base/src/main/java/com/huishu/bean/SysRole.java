package com.huishu.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @Package: com.huishu.bean 
 * @author: xiaobo   
 * @date: 2018年4月25日 下午4:33:04 
 *
 */
@Entity
@Table(name="SysRole")
public class SysRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8931067957017245379L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id", unique = false, nullable = false)
	private Integer id;
	/**
	 * 角色名称
	 */
	@Column(name="Name")
	private String name;
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
	private Date createdOn;
	/**
	 * 修改人
	 */
	@Column(name="ModifiedBy")
	private Integer modifiedBy;
	/**
	 * 修改时间
	 */
	@Column(name="ModifiedOn")
	private Date modifiedOn;
	
	/**
	 * 时间戳
	 */
	@Column(name="DateTimeStamp")
	private Long dateTimeStamp;
	
	/***
	 * 备注
	 */
	@Column(name="Comments")
	private String comments;
	
	@ManyToMany(mappedBy="roles",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<SysUser> users;
	
	
/*	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="SysRoleResource",
		joinColumns={@JoinColumn(name="RoleId",referencedColumnName="Id")
					},
		inverseJoinColumns={@JoinColumn(name="ResourceId",referencedColumnName="Id")})
	private Set<SysResource> resources;*/

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

	  
	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SysRole){
			SysRole p = (SysRole)obj;
			return(name.equals(p.name) && id == p.id);
		}
		return super.equals(obj);
	}

	public Set<SysUser> getUsers() {
		return users;
	}
	@JsonBackReference
	public void setUsers(Set<SysUser> users) {
		this.users = users;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Long getDateTimeStamp() {
		return dateTimeStamp;
	}

	public void setDateTimeStamp(Long dateTimeStamp) {
		this.dateTimeStamp = dateTimeStamp;
	}

	/*public Set<SysResource> getResources() {
		return resources;
	}
	@JsonBackReference
	public void setResources(Set<SysResource> resources) {
		this.resources = resources;
	}*/
}
