package kr.co.vo;

import java.util.Date;

public class BoardVO {
	
	private int bod_no;
	private String id;
	private String subject;
	private String content;
	private Date write_date;
	private int read_count;
	private int rec_count;
	private int comt_count;
	
	public BoardVO() {}

	public int getBod_no() {
		return bod_no;
	}

	public void setBod_no(int bod_no) {
		this.bod_no = bod_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}

	public int getRead_count() {
		return read_count;
	}

	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}

	public int getRec_count() {
		return rec_count;
	}

	public void setRec_count(int rec_count) {
		this.rec_count = rec_count;
	}

	public int getComt_count() {
		return comt_count;
	}

	public void setComt_count(int comt_count) {
		this.comt_count = comt_count;
	}

	public BoardVO(int bod_no, String id, String subject, String content, Date write_date, int read_count,
			int rec_count, int comt_count) {
		super();
		this.bod_no = bod_no;
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.write_date = write_date;
		this.read_count = read_count;
		this.rec_count = rec_count;
		this.comt_count = comt_count;
	}

	@Override
	public String toString() {
		return "BoardVO [bod_no=" + bod_no + ", id=" + id + ", subject=" + subject + ", content=" + content
				+ ", write_date=" + write_date + ", read_count=" + read_count + ", rec_count=" + rec_count
				+ ", comt_count=" + comt_count + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bod_no;
		result = prime * result + comt_count;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + read_count;
		result = prime * result + rec_count;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((write_date == null) ? 0 : write_date.hashCode());
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
		BoardVO other = (BoardVO) obj;
		if (bod_no != other.bod_no)
			return false;
		if (comt_count != other.comt_count)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (read_count != other.read_count)
			return false;
		if (rec_count != other.rec_count)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (write_date == null) {
			if (other.write_date != null)
				return false;
		} else if (!write_date.equals(other.write_date))
			return false;
		return true;
	}

}
