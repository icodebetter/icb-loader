package iwb.domain.db;

// Generated Feb 4, 2007 3:49:13 PM by Hibernate Tools 3.2.0.b9

import java.util.Date;

import javax.persistence.Table;

@Table(name="log5_user_role_login",schema="iwb")
public class Log5UserRoleLogin implements java.io.Serializable, Log5Base {

	private int logId;

	private Date logDttm;

	private int userRoleId;

	private String userIp;
	
	private String userAgent;
	
	public String toInfluxDB() {
		StringBuilder s=new StringBuilder();
//		s.append("user_role_login,user_id=\"").append(getPageName()).append("\",page_id=").append(getPageId()).append("i user_id=").append(getScd().get("userId")).append("i,duration=").append(getDuration()).append("i,ip=\"").append(getIp()).append("\"");
		return s.toString();
	}

	public Log5UserRoleLogin() {}

	public Log5UserRoleLogin(int userRoleId, String userIp, String userAgent) {
		this.userRoleId = userRoleId;		
		this.userIp = userIp;
		int	i=0;
		if(userAgent!=null){
			if(userAgent.contains("MSIE")){
				i=userAgent.indexOf("MSIE");
			} else if(userAgent.contains("Firefox")){
				i=userAgent.indexOf("Firefox");
			} else if(userAgent.contains("Chrome")){
				i=userAgent.indexOf("Chrome");
			} else if(userAgent.contains("Opera")){
				i=userAgent.indexOf("Opera");
			} else if(userAgent.contains("iPhone")){
				i=userAgent.indexOf("iPhone");
			} else if(userAgent.contains("Safari")){
				i=userAgent.indexOf("Safari");
			}
			this.userAgent = userAgent.substring(i,userAgent.length()<(i+16) ? userAgent.length() : (i+16));		
		}
	}


	public int getLogId() {
		return logId;
	}


	public void setLogId(int logId) {
		this.logId = logId;
	}


	public Date getLogDttm() {
		return logDttm;
	}


	public void setLogDttm(Date logDttm) {
		this.logDttm = logDttm;
	}


	public int getUserRoleId() {
		return userRoleId;
	}


	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}


	public String getUserIp() {
		return userIp;
	}


	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
}
