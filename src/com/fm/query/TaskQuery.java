package com.fm.query;

public class TaskQuery {

	private String tkTypeId;
	private String tkUserId;
	private String enrollUserId;

	public TaskQuery() {
		super();
	}

	public TaskQuery(String tkTypeId, String tkUserId, String enrollUserId) {
		super();
		this.tkTypeId = tkTypeId;
		this.tkUserId = tkUserId;
		this.enrollUserId = enrollUserId;
	}

	public String getSqlWhere() {

		String sqlWhere = "";
		if (tkTypeId != null) {
			sqlWhere = " AND tk.tkTypeId = '" + this.tkTypeId + "' ";
		}
		if (tkUserId != null) {
			if (!sqlWhere.equals("")) {
				sqlWhere = sqlWhere + "AND tk.tkUserId = '" + this.tkUserId
						+ "' ";
			} else {
				sqlWhere = " AND tk.tkUserId = '" + this.tkUserId + "' ";
			}
		}
		if (enrollUserId != null) {
			if (!sqlWhere.equals("")) {
				sqlWhere = sqlWhere
						+ "AND te.enrollTkId = tk.tkId AND te.enrollUserId = '"
						+ this.enrollUserId + "' ";
			} else {
				sqlWhere = " AND te.enrollTkId = tk.tkId AND te.enrollUserId = '"
						+ this.enrollUserId + "' ";
			}
		}

		return sqlWhere;
	}

	public static void main(String[] args) {
		TaskQuery taskQuery = new TaskQuery("111", "222", "333");
		String sql = taskQuery.getSqlWhere();
		System.out.println(sql);
		
		System.out.println(sql.indexOf("5"));
	}

	public String getTkTypeId() {
		return tkTypeId;
	}

	public void setTkTypeId(String tkTypeId) {
		this.tkTypeId = tkTypeId;
	}

	public String getTkUserId() {
		return tkUserId;
	}

	public void setTkUserId(String tkUserId) {
		this.tkUserId = tkUserId;
	}

	public String getEnrollUserId() {
		return enrollUserId;
	}

	public void setEnrollUserId(String enrollUserId) {
		this.enrollUserId = enrollUserId;
	}

}
