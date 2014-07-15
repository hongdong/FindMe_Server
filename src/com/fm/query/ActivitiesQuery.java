package com.fm.query;

public class ActivitiesQuery {

	private String actTypeId;
	private String beginTime;
	private String endTime;
	private String keyWorld;

	public ActivitiesQuery() {
		super();
	}

	public String getSqlWhere() {

		String sqlWhere = "";
		if (actTypeId != null) {
			sqlWhere = " and act.actTypeId='" + this.actTypeId + "' ";
		}
		if (beginTime != null) {
			if (!sqlWhere.equals("")) {
				sqlWhere = sqlWhere + "and act.actBeginTime >= '"
						+ this.beginTime + "' ";
			} else {
				sqlWhere = " and act.actBeginTime >= '" + this.beginTime + "' ";
			}
		}
		if (endTime != null) {
			if (!sqlWhere.equals("")) {
				sqlWhere = sqlWhere + "and act.actEndTime <= '" + this.endTime
						+ "' ";
			} else {
				sqlWhere = " and act.actEndTime <= '" + this.endTime + "' ";
			}
		}
		return sqlWhere;
	}

	public String getSqlWhereBySys() {

		String sqlWhere = "";
		if (actTypeId != null && !actTypeId.equals("")) {
			sqlWhere = " and act.actTypeId='" + this.actTypeId + "' ";
		}
		if (beginTime != null && !beginTime.equals("")) {
			if (!sqlWhere.equals("")) {
				sqlWhere = sqlWhere + "and act.actBeginTime >= '"
						+ this.beginTime + "' ";
			} else {
				sqlWhere = " and act.actBeginTime >= '" + this.beginTime + "' ";
			}
		}
		if (endTime != null && !endTime.equals("")) {
			if (!sqlWhere.equals("")) {
				sqlWhere = sqlWhere + "and act.actEndTime <= '" + this.endTime
						+ "' ";
			} else {
				sqlWhere = " and act.actEndTime <= '" + this.endTime + "' ";
			}
		}
		if (keyWorld != null && !keyWorld.equals("")) {
			if (!sqlWhere.equals("")) {
				sqlWhere = sqlWhere + "and (act.actTitle like '%" + this.keyWorld
						+ "%' or act.actContent like '%" + this.keyWorld
						+ "%') ";
			} else {
				sqlWhere = " and (act.actTitle like '%" + this.keyWorld
						+ "%' or act.actContent like '%" + this.keyWorld
						+ "%') ";
			}
		}
		return sqlWhere;
	}

	public String getActTypeId() {
		return actTypeId;
	}

	public void setActTypeId(String actTypeId) {
		this.actTypeId = actTypeId;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getKeyWorld() {
		return keyWorld;
	}

	public void setKeyWorld(String keyWorld) {
		this.keyWorld = keyWorld;
	}

}
