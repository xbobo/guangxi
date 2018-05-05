package com.huishu.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统平台站点信息表
 * @Package: com.huishu.bean 
 * @author: xiaobo   
 * @date: 2018年5月5日 下午3:13:53 
 *
 */
@Entity
@Table(name="SysPlatformSiteInfo")
public class SysPlatformSiteInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -507243705361465638L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id",nullable=false,unique=true)
	private Integer id;
	
	@Column(name="Platform")
	private String platform;
	
	@Column(name="MainChannal")
	private String mainChannal;
	
	@Column(name="PartChannal")
	private String partChannal;
	
	@Column(name="SonChannal")
	private String sonChannal;
	
	@Column(name="MediaId")
	private Integer mediaId;
	
	@Column(name="Comments")
	private String comments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getMainChannal() {
		return mainChannal;
	}

	public void setMainChannal(String mainChannal) {
		this.mainChannal = mainChannal;
	}

	public String getPartChannal() {
		return partChannal;
	}

	public void setPartChannal(String partChannal) {
		this.partChannal = partChannal;
	}

	public String getSonChannal() {
		return sonChannal;
	}

	public void setSonChannal(String sonChannal) {
		this.sonChannal = sonChannal;
	}

	public Integer getMediaId() {
		return mediaId;
	}

	public void setMediaId(Integer mediaId) {
		this.mediaId = mediaId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
