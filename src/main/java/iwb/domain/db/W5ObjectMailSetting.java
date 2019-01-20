package iwb.domain.db;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="w5_object_mail_setting",schema="iwb")
public class W5ObjectMailSetting implements java.io.Serializable {

	private int mailSettingId;
	
	private int tableId;
	private int customizationId;
	private int tablePk;
	private String dsc;
	private short activeFlag;
	private String emailAddress;
	private short outboxRequestDeliveryFlag;
	private short outboxRequestReadFlag;
	private short serverTimeout;
	private short lastErrorTip;
	private Timestamp lastErrorDttm;
	
	private String outboxServer;
	private short outboxServerPort;
	private short outboxServerSslFlag;
	private String outboxServerUserName;
	private String outboxServerPassWord;
	
	private short outboxAuthTip;
	private short errorRetryCount;

	@Id
	@Column(name="mail_setting_id")
	public int getMailSettingId() {
		return mailSettingId;
	}
	public void setMailSettingId(int mailSettingId) {
		this.mailSettingId = mailSettingId;
	}
	@Column(updatable=false,name="TABLE_PK")
	public int getTablePk() {
		return tablePk;
	}
	public void setTablePk(int tablePk) {
		this.tablePk = tablePk;
	}
	@Id
	@Column(updatable=false,name="CUSTOMIZATION_ID")
	public int getCustomizationId() {
		return customizationId;
	}
	public void setCustomizationId(int customizationId) {
		this.customizationId = customizationId;
	}
	@Column(updatable=false,name="DSC")
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	@Column(name="active_flag")
	public short getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(short activeFlag) {
		this.activeFlag = activeFlag;
	}
	@Column(updatable=false,name="TABLE_ID")
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	@Column(updatable=false,name="SERVER_TIMEOUT")
	public short getServerTimeout() {
		return serverTimeout;
	}
	public void setServerTimeout(short serverTimeout) {
		this.serverTimeout = serverTimeout;
	}
	@Column(name="last_error_tip")
	public short getLastErrorTip() {
		return lastErrorTip;
	}
	public void setLastErrorTip(short lastErrorTip) {
		this.lastErrorTip = lastErrorTip;
	}
	@Column(name="last_error_dttm")
	public Timestamp getLastErrorDttm() {
		return lastErrorDttm;
	}
	public void setLastErrorDttm(Timestamp lastErrorDttm) {
		this.lastErrorDttm = lastErrorDttm;
	}
	
	@Column(updatable=false,name="OUTBOX_SERVER")
	public String getOutboxServer() {
		return outboxServer;
	}
	public void setOutboxServer(String outboxServer) {
		this.outboxServer = outboxServer;
	}
	@Column(updatable=false,name="OUTBOX_SERVER_PORT")
	public short getOutboxServerPort() {
		return outboxServerPort;
	}
	public void setOutboxServerPort(short outboxServerPort) {
		this.outboxServerPort = outboxServerPort;
	}
	@Column(updatable=false,name="OUTBOX_SERVER_SSL_FLAG")
	public short getOutboxServerSslFlag() {
		return outboxServerSslFlag;
	}
	public void setOutboxServerSslFlag(short outboxServerSslFlag) {
		this.outboxServerSslFlag = outboxServerSslFlag;
	}
	@Column(updatable=false,name="OUTBOX_SERVER_USER_NAME")
	public String getOutboxServerUserName() {
		return outboxServerUserName;
	}
	public void setOutboxServerUserName(String outboxServerUserName) {
		this.outboxServerUserName = outboxServerUserName;
	}
	@Column(updatable=false,name="OUTBOX_SERVER_PASS_WORD")
	public String getOutboxServerPassWord() {
		return outboxServerPassWord;
	}
	public void setOutboxServerPassWord(String outboxServerPassWord) {
		this.outboxServerPassWord = outboxServerPassWord;
	}
	
	@Column(updatable=false,name="OUTBOX_AUTH_TIP")
	public short getOutboxAuthTip() {
		return outboxAuthTip;
	}
	public void setOutboxAuthTip(short outboxAuthTip) {
		this.outboxAuthTip = outboxAuthTip;
	}
	
	@Column(name="error_retry_count")
	public short getErrorRetryCount() {
		return errorRetryCount;
	}
	public void setErrorRetryCount(short errorRetryCount) {
		this.errorRetryCount = errorRetryCount;
	}
	@Column(name="outbox_request_delivery_flag")
	public short getOutboxRequestDeliveryFlag() {
		return outboxRequestDeliveryFlag;
	}
	public void setOutboxRequestDeliveryFlag(short outboxRequestDeliveryFlag) {
		this.outboxRequestDeliveryFlag = outboxRequestDeliveryFlag;
	}	
	
	@Column(name="outbox_request_read_flag")
	public short getOutboxRequestReadFlag() {
		return outboxRequestReadFlag;
	}
	public void setOutboxRequestReadFlag(short outboxRequestReadFlag) {
		this.outboxRequestReadFlag = outboxRequestReadFlag;
	}
	
	@Column(updatable=false,name="EMAIL_ADDRESS")
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
}
