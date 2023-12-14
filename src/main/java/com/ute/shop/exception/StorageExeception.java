package com.ute.shop.exception;

public class StorageExeception extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StorageExeception(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public StorageExeception(String message, Exception e) {
		// TODO Auto-generated constructor stub
		super(message,e);
	}
	
}
