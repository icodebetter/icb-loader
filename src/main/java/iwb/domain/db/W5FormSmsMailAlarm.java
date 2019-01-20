package iwb.domain.db;

import java.sql.Timestamp;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="w5_form_sms_mail_alarm",schema="iwb")
public class W5FormSmsMailAlarm implements java.io.Serializable, W5Base {

	private int formSmsMailAlarmId;
	private int formSmsMailId;

	private int tableId;
	
	private int tablePk;
	private int insertUserId;	
	private int versionUserId;	

	private String dsc;


	private short status; // 0: sms, 1:mail 
	private Timestamp alarmDttm;
	


	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		if(dsc!=null && dsc.length()>256)dsc=dsc.substring(0,253)+"...";
		this.dsc = dsc;
	}	
	
	public W5FormSmsMailAlarm() {
		super();
	}
	@Id
    @SequenceGenerator(name="sex_form_alarm",sequenceName="iwb.seq_form_alarm",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sex_form_alarm")
	@Column(name="form_sms_mail_alarm_id")
	public int getFormSmsMailAlarmId() {
		return formSmsMailAlarmId;
	}
	public void setFormSmsMailAlarmId(int formSmsMailAlarmId) {
		this.formSmsMailAlarmId = formSmsMailAlarmId;
	}
	@Column(name="form_sms_mail_id")
	public int getFormSmsMailId() {
		return formSmsMailId;
	}
	public void setFormSmsMailId(int formSmsMailId) {
		this.formSmsMailId = formSmsMailId;
	}

	@Override
	public boolean safeEquals(W5Base q) {
		// TODO Auto-generated method stub
		return false;
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
	@Column(name="status")
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	@Column(name="alarm_dttm")
	public Timestamp getAlarmDttm() {
		return alarmDttm;
	}
	public void setAlarmDttm(Timestamp alarmDttm) {
		this.alarmDttm = alarmDttm;
	}
	@Column(name="insert_user_id")
	public int getInsertUserId() {
		return insertUserId;
	}
	public void setInsertUserId(int insertUserId) {
		this.insertUserId = insertUserId;
	}
	@Column(name="version_user_id")
	public int getVersionUserId() {
		return versionUserId;
	}
	public void setVersionUserId(int versionUserId) {
		this.versionUserId = versionUserId;
	}
	public W5FormSmsMailAlarm(Map<String, Object> scd) {
		super();
		this.projectUuid = (String)scd.get("projectUuid");
		this.insertUserId = (Integer)scd.get("userId");
		this.versionUserId = (Integer)scd.get("userId");
	}
	private String projectUuid;
	@Id
	@Column(name="project_uuid")
	public String getProjectUuid() {
		return projectUuid;
	}

	public void setProjectUuid(String projectUuid) {
		this.projectUuid = projectUuid;
	}


	
}
