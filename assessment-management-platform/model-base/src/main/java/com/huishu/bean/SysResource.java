package com.huishu.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
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
 * @date: 2018年4月25日 下午4:33:17 
 *
 */
//@Entity
//@Table(name="SysResource")
public class SysResource implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5926741098616793079L;
	/**
	 * 主键id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id", unique = false, nullable = false)
    private Integer id; //编号
	/**
	 * 资源名称
	 */
	@Column(name="Name")
    private String name;
	/**
	 * 资源类型
	 */
	@Column(name="Menu")
    private String menu;
	/**
	 * 资源路径
	 */
	@Column(name="Url")
    private String url; 
	/**
	 * 权限字符串
	 */
	@Column(name="Permission")
    private String permission;
	/**
	 * 父编号
	 */
	@Column(name="ParentId")
    private Integer parentId;
	/**
	 * 父编号列表
	 */
	@Column(name="ParentIds")
    private String parentIds;
	
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
	
	@ManyToMany(mappedBy="resources",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<SysRole> roles;

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

    public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public boolean isRootNode() {
        return parentId == 0;
    }

    public String makeSelfAsParentIds() {
        return getParentIds() + getId() + "/";
    }

	public Set<SysRole> getRoles() {
		return roles;
	}

	@JsonBackReference
	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}
	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SysResource){
			SysResource p = (SysResource)obj;
			return(name.equals(p.name) && id == p.id);
		}
		return super.equals(obj);
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
