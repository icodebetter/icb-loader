package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;
//import org.influxdb.InfluxDB;

@Entity
@Immutable
@Table(name="w5_project",schema="iwb")
public class W5Project  implements java.io.Serializable {

	private String projectUuid;
	private int customizationId;

	private String dsc;
	private String vcsUrl;
	private String vcsUserName;
	private String vcsPassword;
	
	private String rdbmsSchema;

	
	private short mqFlag;
	private short mqTip;
	private String mqUrl;
	private String mqQueueName;

	private short tsdbFlag;
	private String tsdbUrl;
	private String tsdbUserName;
	private String tsdbPassWord;
	private String tsdbDatabase;
	
	private short uiWebFrontendTip;
	private int uiMainTemplateId;
	private int uiLoginTemplateId;
	private int sessionQueryId;
	private int authenticationFuncId;
	private int _defaultUserTip;
	
	/*
	  ui_web_frontend_tip smallint NOT NULL DEFAULT 1,
	  ui_main_template_id integer NOT NULL DEFAULT 0,
	  session_query_id integer NOT NULL DEFAULT 0,
	  authentication_func_id integer NOT NULL DEFAULT 0,*/
	/*private Channel _mqChannel;
	private InfluxDB _tsdb;*/
	
	
	@Column(name="ui_login_template_id")
	public int getUiLoginTemplateId() {
		return uiLoginTemplateId;
	}
	public void setUiLoginTemplateId(int uiLoginTemplateId) {
		this.uiLoginTemplateId = uiLoginTemplateId;
	}
	
	@Column(name="ui_web_frontend_tip")
	public short getUiWebFrontendTip() {
		return uiWebFrontendTip;
	}
	public void setUiWebFrontendTip(short uiWebFrontendTip) {
		this.uiWebFrontendTip = uiWebFrontendTip;
	}
	@Column(name="ui_main_template_id")
	public int getUiMainTemplateId() {
		return uiMainTemplateId;
	}
	public void setUiMainTemplateId(int uiMainTemplateId) {
		this.uiMainTemplateId = uiMainTemplateId;
	}
	@Column(name="session_query_id")
	public int getSessionQueryId() {
		return sessionQueryId;
	}
	public void setSessionQueryId(int sessionQueryId) {
		this.sessionQueryId = sessionQueryId;
	}
	@Column(name="authentication_func_id")
	public int getAuthenticationFuncId() {
		return authenticationFuncId;
	}
	public void setAuthenticationFuncId(int authenticationFuncId) {
		this.authenticationFuncId = authenticationFuncId;
	}
	
	@Id
	@Column(name="project_uuid")
	public String getProjectUuid() {
		return projectUuid;
	}
	
	public void setProjectUuid(String projectUuid) {
		this.projectUuid = projectUuid;
	}
	
	@Column(name="customization_id")
	public int getCustomizationId() {
		return customizationId;
	}
	public void setCustomizationId(int customizationId) {
		this.customizationId = customizationId;
	}

	@Column(name="vcs_url")
	public String getVcsUrl() {
		return vcsUrl;
	}
	public void setVcsUrl(String vcsUrl) {
		this.vcsUrl = vcsUrl;
	}
	@Column(name="vcs_user_name")
	public String getVcsUserName() {
		return vcsUserName;
	}
	public void setVcsUserName(String vcsUserName) {
		this.vcsUserName = vcsUserName;
	}
	@Column(name="vcs_password")
	public String getVcsPassword() {
		return vcsPassword;
	}
	public void setVcsPassword(String vcsPassword) {
		this.vcsPassword = vcsPassword;
	}
	
	@Column(name="rdbms_schema")
	public String getRdbmsSchema() {
		return rdbmsSchema;
	}
	public void setRdbmsSchema(String rdbmsSchema) {
		this.rdbmsSchema = rdbmsSchema;
	}

	@Column(name="mq_flag")
	public short getMqFlag() {
		return mqFlag;
	}
	public void setMqFlag(short mqFlag) {
		this.mqFlag = mqFlag;
	}
	
	@Column(name="mq_tip")
	public short getMqTip() {
		return mqTip;
	}
	public void setMqTip(short mqTip) {
		this.mqTip = mqTip;
	}
	
	
	@Column(name="mq_url")
	public String getMqUrl() {
		return mqUrl;
	}
	public void setMqUrl(String mqUrl) {
		this.mqUrl = mqUrl;
	}
	
	
	@Column(name="mq_queue_name")
	public String getMqQueueName() {
		return mqQueueName;
	}
	public void setMqQueueName(String mqQueueName) {
		this.mqQueueName = mqQueueName;
	}
	
	/*@Transient
	public Channel get_mqChannel() {
		return _mqChannel;
	}
	public void set_mqChannel(Channel _mqChannel) {
		this._mqChannel = _mqChannel;
	}*/
	@Column(name="tsdb_flag")
	public short getTsdbFlag() {
		return tsdbFlag;
	}
	public void setTsdbFlag(short tsdbFlag) {
		this.tsdbFlag = tsdbFlag;
	}
	@Column(name="tsdb_url")
	public String getTsdbUrl() {
		return tsdbUrl;
	}
	public void setTsdbUrl(String tsdbUrl) {
		this.tsdbUrl = tsdbUrl;
	}
	@Column(name="tsdb_user_name")
	public String getTsdbUserName() {
		return tsdbUserName;
	}
	public void setTsdbUserName(String tsdbUserName) {
		this.tsdbUserName = tsdbUserName;
	}
	@Column(name="tsdb_pass_word")
	public String getTsdbPassWord() {
		return tsdbPassWord;
	}
	public void setTsdbPassWord(String tsdbPassWord) {
		this.tsdbPassWord = tsdbPassWord;
	}
	
	/*@Transient
	public InfluxDB get_tsdb() {
		return _tsdb;
	}
	public void set_tsdb(InfluxDB _tsdb) {
		this._tsdb = _tsdb;
	}*/
	
	@Column(name="tsdb_database")
	public String getTsdbDatabase() {
		return tsdbDatabase;
	}
	public void setTsdbDatabase(String tsdbDatabase) {
		this.tsdbDatabase = tsdbDatabase;
	}
	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	
	@Transient
	public int get_defaultUserTip() {
		return _defaultUserTip;
	}
	public void set_defaultUserTip(int _defaultUserTip) {
		this._defaultUserTip = _defaultUserTip;
	}

}

