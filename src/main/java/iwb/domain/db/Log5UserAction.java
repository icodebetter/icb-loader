package iwb.domain.db;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="log5_user_action",schema="iwb")
public class Log5UserAction implements Serializable, Log5Base{
	
	private int logId;
	private int userId;
	private int customizationId;  
	private int tableId;  
	private int tablePk;  
	private short actionTip;  
	private String userIp;  
	
	
	public String toInfluxDB() {
		StringBuilder s=new StringBuilder();
		return s.toString();
	}
	
	public Log5UserAction() {
	}
	
	public Log5UserAction(Map<String, Object> scd) {
		this.customizationId = (Integer)scd.get("customizationId");
		this.userId = (Integer)scd.get("userId");
	}

	@SequenceGenerator(name="sex_log5_user_action",sequenceName="iwb.seq_log5_user_action",allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sex_log5_user_action")
	@Column(name="log_id")  
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	@Id
	@Column(name="customization_id")
	public int getCustomizationId() {
		return customizationId;
	}
	public void setCustomizationId(int customizationId) {
		this.customizationId = customizationId;
	}
	@Column(name="user_id")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name="table_id")
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	@Column(name="table_pk")
	public int getTablePk() {
		return tablePk;
	}
	public void setTablePk(int tablePk) {
		this.tablePk = tablePk;
	}
	@Column(name="action_tip")
	public short getActionTip() {
		return actionTip;
	}
	public void setActionTip(short actionTip) {
		this.actionTip = actionTip;
	}
	@Column(name="user_ip")
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	
}
