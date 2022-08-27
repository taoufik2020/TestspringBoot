package com.test.springboot.Dto;

public class GenericResponse<T>{
	
	
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	private T data;
	public GenericResponse(T data, int code) {
		super();
		this.data = data;
		this.code = code;
	}
	private int code; 

}