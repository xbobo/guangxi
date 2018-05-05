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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @Package: com.huishu.bean 
 * @author: xiaobo   
 * @date: 2018年4月25日 下午4:33:11 
 *
 */
@Entity
@Table(name="SysUser")
public class SysUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1472649718856755029L;
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id", unique = false, nullable = false)
	private Integer id;
	/**
	 * 用户名
	 */
	@Column(name="UserName")
	private String username;
	
	/**
	 * 真实姓名
	 */
	@Column(name="Realname")
	private String realname;
	
	/**
	 * 密码
	 */
	@Column(name="Password")
	private String password;
	
	/**
	 * 资源标识
	 */
	@Column(name="Resources")
	private String resources;
	
	/**
	 * 加密盐值
	 */
	@Column(name="Salt")
	private String salt;
	/**
	 * 手机号
	 */
	@Column(name="Phone")
	private String phone;
	
	/**
	 * 邮箱地址
	 */
	@Column(name="Email")
	private String email;
	/**
	 * 公司名称
	 */
	@Column(name="Company")
	private String company;
	/**
	 * 部门名称
	 */
	@Column(name="Department")
	private String department;
	/**
	 * 有效期
	 */
	//@Column(name = "u_validdate", unique = false, nullable = false)
	@Column(name="ValidDate")
	private Date validDate;
	/**
	 * 用户类型
	 */
	@Column(name="UserType")
	private Integer userType;
	/**
	 * 地址
	 */
	@Column(name="Address")
	private String address;
	/**
	 * 地址类型
	 */
	@Column(name="AddressType")
	private Integer addressType;
	/**
	 * 证件
	 */
	@Column(name="Credential")
	private String credential;
	/***
	 * 证件类型
	 */
	@Column(name="CredentialType")
	private Integer credentialType;
	/**
	 * 来源
	 */
	@Column(name="Source")
	private String source;
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
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="SysUserRole",
		joinColumns={@JoinColumn(name="UserId",referencedColumnName="Id")},
		inverseJoinColumns={@JoinColumn(name="RoleId",referencedColumnName="Id")})
    private Set<SysRole> roles;
	
	public SysUser(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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
	
	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	public Set<SysRole> getRoles() {
		return roles;
	}
	@JsonBackReference
	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SysUser){
			SysUser p = (SysUser)obj;
			return(username.equals(p.username) && id == p.id);
		}
		return super.equals(obj);
	}

	public String getResources() {
		return resources;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAddressType() {
		return addressType;
	}

	public void setAddressType(Integer addressType) {
		this.addressType = addressType;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public Integer getCredentialType() {
		return credentialType;
	}

	public void setCredentialType(Integer credentialType) {
		this.credentialType = credentialType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
