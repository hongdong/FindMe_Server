package com.fm.model;

import java.io.Serializable;

public class Type implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 类型id
	 * 
	 */
	private String typeId;

	/**
	 * 类型名称
	 * 
	 */
	private String typeName;

	/**
	 * 所属表
	 * 
	 */
	private Integer typeBelongTo;
	/**
	 * 所属表
	 * 
	 */
	private Integer typeSort;

	public Type(String typeId, String typeName, Integer typeBelongTo) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeBelongTo = typeBelongTo;
	}

	public Type(Integer typeBelongTo) {
		super();
		this.typeBelongTo = typeBelongTo;
	}

	public Type() {
		super();
	}

	/* getter、setter methods */
	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getTypeBelongTo() {
		return typeBelongTo;
	}

	public void setTypeBelongTo(Integer typeBelongTo) {
		this.typeBelongTo = typeBelongTo;
	}

	public Integer getTypeSort() {
		return typeSort;
	}

	public void setTypeSort(Integer typeSort) {
		this.typeSort = typeSort;
	}

}
