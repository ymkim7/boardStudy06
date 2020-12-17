package kr.co.vo;

import java.util.Date;

public class MemberVO {
	
	private String id;
	private String pw;
	private String email;
	private Date reg_date;
	private Date log_date;
	private String approval_status;
	private String approval_key;
	
	public MemberVO() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public Date getLog_date() {
		return log_date;
	}

	public void setLog_date(Date log_date) {
		this.log_date = log_date;
	}

	public String getApproval_status() {
		return approval_status;
	}

	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}

	public String getApproval_key() {
		return approval_key;
	}

	public void setApproval_key(String approval_key) {
		this.approval_key = approval_key;
	}

	public MemberVO(String id, String pw, String email, Date reg_date, Date log_date, String approval_status,
			String approval_key) {
		super();
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.reg_date = reg_date;
		this.log_date = log_date;
		this.approval_status = approval_status;
		this.approval_key = approval_key;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", email=" + email + ", reg_date=" + reg_date + ", log_date="
				+ log_date + ", approval_status=" + approval_status + ", approval_key=" + approval_key + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approval_key == null) ? 0 : approval_key.hashCode());
		result = prime * result + ((approval_status == null) ? 0 : approval_status.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((log_date == null) ? 0 : log_date.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + ((reg_date == null) ? 0 : reg_date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		if (approval_key == null) {
			if (other.approval_key != null)
				return false;
		} else if (!approval_key.equals(other.approval_key))
			return false;
		if (approval_status == null) {
			if (other.approval_status != null)
				return false;
		} else if (!approval_status.equals(other.approval_status))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (log_date == null) {
			if (other.log_date != null)
				return false;
		} else if (!log_date.equals(other.log_date))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		if (reg_date == null) {
			if (other.reg_date != null)
				return false;
		} else if (!reg_date.equals(other.reg_date))
			return false;
		return true;
	}

}
