package iwb.domain.db;

import java.util.Map;

public class Log5VisitedPage implements Log5Base {
	private	Map<String, Object> scd;
	private	String pageName;
	private	Object pageId;
	private	String ip;
	private int duration;
	
	public String toInfluxDB() {
		StringBuilder s=new StringBuilder();
		s.append("visited_page,page_name=").append(getPageName()).append(",page_id=").append(getPageId()).append(" user_id=").append(getScd().get("userId")==null?0:(Integer)getScd().get("userId")).append("i,duration=").append(getDuration()).append("i,ip=\"").append(getIp()).append("\"");
		return s.toString();
	}

	
	public Log5VisitedPage(Map<String, Object> scd, String pageName, Object pageId, String ip, int duration) {
		this.scd = scd;
		this.pageName = pageName;
		this.pageId = pageId;
		this.ip = ip;
		this.duration = duration;
	}
	public Map<String, Object> getScd() {
		return scd;
	}
	public Object getPageId() {
		return pageId;
	}
	public String getIp() {
		return ip;
	}
	public int getDuration() {
		return duration;
	}
	public String getPageName() {
		return pageName;
	}

}
