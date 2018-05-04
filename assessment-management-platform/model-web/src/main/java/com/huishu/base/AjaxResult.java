package com.huishu.base;

public class AjaxResult {
	
	private boolean status;
	
	private Object data;
	
	private String msg;

	public boolean isStatus() {
		return status;
	}

	public AjaxResult setStatus(boolean status) {
		this.status = status;
		return this;
	}

	public Object getData() {
		return data;
	}

	public AjaxResult setData(Object data) {
		this.data = data;
		return this;
	}
	
	public String getMsg() {
		return msg;
	}

	public AjaxResult setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public static AjaxResult error(String msg) {
		return new AjaxResult().setStatus(false).setMsg(msg);
	}
	
	public static AjaxResult success(Object data) {
		return new AjaxResult().setStatus(true).setData(data);
	}
	
}
