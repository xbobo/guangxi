package com.huishu.es.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.huishu.es.conf.EsConstants;



@Document(indexName=EsConstants.ES_INDEX,type=EsConstants.ES_TYPE)
public class AmpInfo {
	
	@Id
	private String id;
	
	/**发布时间*/
	private String publishDateTime;
	
	/**发布日期*/
	private String publishDate;
	
	private Long year;
	
	private Long month;
	
	private Long day;
	
	private Long hour;
	
	private String brand;
	
	private String carSeries;
	
	private String carModel;
	
	private Long hitCount;
	
	private Long replyCount;
	
	private String media;
	
	private String site;
	
	private String province;
	
	private String area;
	
	private String emotion;
	
	private String author;
	
	private String authorId;
	
	private String advertisementTheme;
	
	private Long putTimeMills;
	
	private String terminal;
	
	private String terminalDetails;
	
	private String content;
	
	private String title;
	
	private String url;
	
	private String vector;

	public String getPublishDateTime() {
		return publishDateTime;
	}

	public void setPublishDateTime(String publishDateTime) {
		this.publishDateTime = publishDateTime;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Long getMonth() {
		return month;
	}

	public void setMonth(Long month) {
		this.month = month;
	}

	public Long getDay() {
		return day;
	}

	public void setDay(Long day) {
		this.day = day;
	}

	public Long getHour() {
		return hour;
	}

	public void setHour(Long hour) {
		this.hour = hour;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	public Long getHitCount() {
		return hitCount;
	}

	public void setHitCount(Long hitCount) {
		this.hitCount = hitCount;
	}

	public Long getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Long replyCount) {
		this.replyCount = replyCount;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEmotion() {
		return emotion;
	}

	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getAdvertisementTheme() {
		return advertisementTheme;
	}

	public void setAdvertisementTheme(String advertisementTheme) {
		this.advertisementTheme = advertisementTheme;
	}

	public Long getPutTimeMills() {
		return putTimeMills;
	}

	public void setPutTimeMills(Long putTimeMills) {
		this.putTimeMills = putTimeMills;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getTerminalDetails() {
		return terminalDetails;
	}

	public void setTerminalDetails(String terminalDetails) {
		this.terminalDetails = terminalDetails;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVector() {
		return vector;
	}

	public void setVector(String vector) {
		this.vector = vector;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return " info {   publishDateTime = "+ this.publishDateTime
				+" , publicDate = "+this.publishDate+" , brand = "+this.brand + " , carSeries = "+this.carSeries
				+" , carModel = "+this.carModel + " , hitCount = "+this.hitCount+" , replyCount= " +this.replyCount
				+" , media = "+this.media+" , site = "+ this.site
				+" , province = "+this.province+" , area = "+this.area
				+" , emotion = "+this.emotion+" , author = "+this.author
				+" , title = "+this.title+" , url = "+this.url
				+" , vector = "+this.vector+" , termainal = "+this.terminal
				+" , terminalDetails = "+this.terminalDetails+" , vector = "+this.vector
				+" } ";
	}

}
