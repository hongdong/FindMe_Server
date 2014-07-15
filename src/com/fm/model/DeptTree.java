package com.fm.model;

import java.util.HashSet;
import java.util.Set;

public class DeptTree {
	private String text;
	private String id;
	private boolean checked;
	private boolean leaf;

	private Set<DeptTree> children = new HashSet<DeptTree>();

	public DeptTree(String text, String id, boolean checked, boolean leaf) {
		super();
		this.text = text;
		this.id = id;
		this.checked = checked;
		this.leaf = leaf;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public Set<DeptTree> getChildren() {
		return children;
	}

	public void setChildren(Set<DeptTree> children) {
		this.children = children;
	}

}
