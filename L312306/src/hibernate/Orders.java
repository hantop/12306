package hibernate;
// Generated 2017-7-10 16:57:49 by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * Orders generated by hbm2java
 */
public class Orders implements java.io.Serializable {
	
	private Integer id;
	private Ticket ticket;
	private Uuser uuser;
	private Integer status;
	private Date maketime;
	private String con1;
	private String con2;
	private String con3;
	private String con4;
	private String con5;

	public Orders() {
	}

	public Orders(Integer id, Ticket ticket, Uuser uuser, Integer status, Date maketime) {
		this.id = id;
		this.ticket = ticket;
		this.uuser = uuser;
		this.status = status;
		this.maketime = maketime;
	}

	public Orders(Integer id, Ticket ticket, Uuser uuser, Integer status, Date maketime, String con1, String con2,
			String con3, String con4, String con5) {
		this.id = id;
		this.ticket = ticket;
		this.uuser = uuser;
		this.status = status;
		this.maketime = maketime;
		this.con1 = con1;
		this.con2 = con2;
		this.con3 = con3;
		this.con4 = con4;
		this.con5 = con5;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ticket getTicket() {
		return this.ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Uuser getUuser() {
		return this.uuser;
	}

	public void setUuser(Uuser uuser) {
		this.uuser = uuser;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getMaketime() {
		return this.maketime;
	}

	public void setMaketime(Date maketime) {
		this.maketime = maketime;
	}

	public String getCon1() {
		return this.con1;
	}

	public void setCon1(String con1) {
		this.con1 = con1;
	}

	public String getCon2() {
		return this.con2;
	}

	public void setCon2(String con2) {
		this.con2 = con2;
	}

	public String getCon3() {
		return this.con3;
	}

	public void setCon3(String con3) {
		this.con3 = con3;
	}

	public String getCon4() {
		return this.con4;
	}

	public void setCon4(String con4) {
		this.con4 = con4;
	}

	public String getCon5() {
		return this.con5;
	}

	public void setCon5(String con5) {
		this.con5 = con5;
	}
	
	@Override
	public String toString() {
		return "Orders [id=" + id + ", status=" + status + ", maketime=" + maketime + "]";
	}
}
