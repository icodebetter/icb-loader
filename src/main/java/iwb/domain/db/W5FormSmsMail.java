package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;


@Entity
@Immutable
@Table(name="w5_form_sms_mail",schema="iwb")
public class W5FormSmsMail implements java.io.Serializable, W5Base {

	private int formSmsMailId;

	private int formId;
	
	private int mailSettingId;

	private String dsc;

	private short tabOrder;

	private short smsMailTip; // 0: sms, 1:mail 
	private short smsMailSentTip; // 0: disabled, 1: auto, 2: preview_before, 3: manual 
	private short previewFlag;
	
	private String smsMailTo;
	private String smsMailCc;
	private String smsMailBcc;
	private String smsMailSubject;
	private String smsMailBody;
	private String actionTips;
	private String webMobileTips;
	private short activeFlag;
	private short alarmFlag;
	private Integer alarmDttmFieldId;
	private short alarmTmTip;
	private String alarmTm;
	private short asyncFlag;

	private String conditionSqlCode;
	

	@Column(name="form_id")
	public int getFormId() {
		return formId;
	}
	public void setFormId(int formId) {
		this.formId = formId;
	}

	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	@Column(name="tab_order")
	public short getTabOrder() {
		return tabOrder;
	}
	public void setTabOrder(short tabOrder) {
		this.tabOrder = tabOrder;
	}	
	
	public W5FormSmsMail() {
		super();
	}
	
	
	@Id
	@Column(name="form_sms_mail_id")
	public int getFormSmsMailId() {
		return formSmsMailId;
	}
	public void setFormSmsMailId(int formSmsMailId) {
		this.formSmsMailId = formSmsMailId;
	}

	@Column(name="sms_mail_tip")
	public short getSmsMailTip() {
		return smsMailTip;
	}
	public void setSmsMailTip(short smsMailTip) {
		this.smsMailTip = smsMailTip;
	}
	@Column(name="sms_mail_sent_tip")
	public short getSmsMailSentTip() {
		return smsMailSentTip;
	}
	public void setSmsMailSentTip(short smsMailSentTip) {
		this.smsMailSentTip = smsMailSentTip;
	}
	@Column(name="sms_mail_to")
	public String getSmsMailTo() {
		return smsMailTo;
	}
	public void setSmsMailTo(String smsMailTo) {
		this.smsMailTo = smsMailTo;
	}
	@Column(name="sms_mail_cc")
	public String getSmsMailCc() {
		return smsMailCc;
	}
	public void setSmsMailCc(String smsMailCc) {
		this.smsMailCc = smsMailCc;
	}
	@Column(name="sms_mail_bcc")
	public String getSmsMailBcc() {
		return smsMailBcc;
	}
	public void setSmsMailBcc(String smsMailBcc) {
		this.smsMailBcc = smsMailBcc;
	}
	@Column(name="sms_mail_subject")
	public String getSmsMailSubject() {
		return smsMailSubject;
	}
	public void setSmsMailSubject(String smsMailSubject) {
		this.smsMailSubject = smsMailSubject;
	}
	@Column(name="sms_mail_body")
	public String getSmsMailBody() {
		return smsMailBody;
	}
	public void setSmsMailBody(String smsMailBody) {
		this.smsMailBody = smsMailBody;
	}
	@Column(name="preview_flag")
	public short getPreviewFlag() {
		return previewFlag;
	}
	public void setPreviewFlag(short previewFlag) {
		this.previewFlag = previewFlag;
	}
	
	@Column(name="action_tips")
	public String getActionTips() {
		return actionTips;
	}
	public void setActionTips(String actionTips) {
		this.actionTips = actionTips;
	}
	@Column(name="active_flag")
	public short getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(short activeFlag) {
		this.activeFlag = activeFlag;
	}
	@Transient
	public boolean safeEquals(W5Base q){
		if(q==null)return false;
		W5FormSmsMail f = (W5FormSmsMail)q;
		return false;
	}
	@Column(name="condition_sql_code")
	public String getConditionSqlCode() {
		return conditionSqlCode;
	}
	
	public void setConditionSqlCode(String conditionSqlCode) {
		this.conditionSqlCode = conditionSqlCode;
	}
	@Column(name="web_mobile_tips")
	public String getWebMobileTips() {
		return webMobileTips;
	}
	public void setWebMobileTips(String webMobileTips) {
		this.webMobileTips = webMobileTips;
	}
	@Column(name="alarm_flag")
	public short getAlarmFlag() {
		return alarmFlag;
	}
	public void setAlarmFlag(short alarmFlag) {
		this.alarmFlag = alarmFlag;
	}
	@Column(name="alarm_dttm_field_id")
	public Integer getAlarmDttmFieldId() {
		return alarmDttmFieldId;
	}
	public void setAlarmDttmFieldId(Integer alarmDttmFieldId) {
		this.alarmDttmFieldId = alarmDttmFieldId;
	}
	@Column(name="alarm_tm_tip")
	public short getAlarmTmTip() {
		return alarmTmTip;
	}
	public void setAlarmTmTip(short alarmTmTip) {
		this.alarmTmTip = alarmTmTip;
	}
	@Column(name="alarm_tm")
	public String getAlarmTm() {
		return alarmTm;
	}
	public void setAlarmTm(String alarmTm) {
		this.alarmTm = alarmTm;
	}
	@Column(name="mail_setting_id")
	public int getMailSettingId() {
		return mailSettingId;
	}
	public void setMailSettingId(int mailSettingId) {
		this.mailSettingId = mailSettingId;
	}
	@Column(name="async_flag")
	public short getAsyncFlag() {
		return asyncFlag;
	}
	public void setAsyncFlag(short asyncFlag) {
		this.asyncFlag = asyncFlag;
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
