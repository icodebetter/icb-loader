package iwb.domain.db;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "W5_JOB_SCHEDULE",schema="iwb")
public class W5JobSchedule implements java.io.Serializable {
	private int jobScheduleId;
	private String dsc;
	private int actionTip;
	private int activeFlag;
	private int actionDbFuncId;
	private int formValueId;
	private int executeUserId;
	private int executeRoleId;
	private String actionSendEmailTo;
	private String actionSendEmailSubject;
	private String actionSendEmailBody;
	private int actionStartTip;
	private Timestamp actionStartDttm;
	private int actionFrequency;
	private int actionDelay;
	private Timestamp actionEndDttm;
	private String actionMonths;
	private String actionMonthsDays;
	private String actionWeekDays;
	private String reports;
	private String repeatTime;
	private String locale;
	private int todayFlag;
	private int todayAddDayValue;
	private Timestamp lastRunTime;
	private int _userRoleId;
	private int customizationId;	

	public W5JobSchedule() {
	}

	@SequenceGenerator(name = "SEX_JOB_SCHEDULE_ID", sequenceName = "SEQ_JOB_SCHEDULE_ID", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEX_JOB_SCHEDULE_ID")
	@Column(name = "JOB_SCHEDULE_ID")
	public int getJobScheduleId() {
		return this.jobScheduleId;
	}

	public void setJobScheduleId(int jobScheduleId) {
		this.jobScheduleId = jobScheduleId;
	}

	@Column(name = "DSC")
	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	

	@Column(name = "ACTION_TIP")
	public int getActionTip() {
		return actionTip;
	}

	public void setActionTip(int actionTip) {
		this.actionTip = actionTip;
	}

	@Column(name = "ACTIVE_FLAG")
	public int getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "ACTION_DB_FUNC_ID")
	public int getActionDbFuncId() {
		return actionDbFuncId;
	}

	public void setActionDbFuncId(int actionDbFuncId) {
		this.actionDbFuncId = actionDbFuncId;
	}

	@Column(name = "FORM_VALUE_ID")
	public int getFormValueId() {
		return formValueId;
	}

	public void setFormValueId(int formValueId) {
		this.formValueId = formValueId;
	}

	@Column(name = "EXECUTE_USER_ID")
	public int getExecuteUserId() {
		return executeUserId;
	}

	public void setExecuteUserId(int executeUserId) {
		this.executeUserId = executeUserId;
	}

	@Column(name = "EXECUTE_ROLE_ID")
	public int getExecuteRoleId() {
		return executeRoleId;
	}

	public void setExecuteRoleId(int executeRoleId) {
		this.executeRoleId = executeRoleId;
	}

	@Column(name = "ACTION_SEND_EMAIL_TO")
	public String getActionSendEmailTo() {
		return actionSendEmailTo;
	}

	public void setActionSendEmailTo(String actionSendEmailTo) {
		this.actionSendEmailTo = actionSendEmailTo;
	}

	@Column(name = "ACTION_SEND_EMAIL_SUBJECT")
	public String getActionSendEmailSubject() {
		return actionSendEmailSubject;
	}


	public void setActionSendEmailSubject(String actionSendEmailSubject) {
		this.actionSendEmailSubject = actionSendEmailSubject;
	}

	@Column(name = "ACTION_SEND_EMAIL_BODY")
	public String getActionSendEmailBody() {
		return actionSendEmailBody;
	}
	
	public void setActionSendEmailBody(String actionSendEmailBody) {
		this.actionSendEmailBody = actionSendEmailBody;
	}

	@Column(name = "ACTION_START_TIP")
	public int getActionStartTip() {
		return actionStartTip;
	}

	public void setActionStartTip(int actionStartTip) {
		this.actionStartTip = actionStartTip;
	}

	@Column(name = "ACTION_START_DTTM")
	public Timestamp getActionStartDttm() {
		return actionStartDttm;
	}

	public void setActionStartDttm(Timestamp actionStartDttm) {
		this.actionStartDttm = actionStartDttm;
	}

	@Column(name = "ACTION_FREQUENCY")
	public int getActionFrequency() {
		return actionFrequency;
	}

	public void setActionFrequency(int actionFrequency) {
		this.actionFrequency = actionFrequency;
	}

	@Column(name = "ACTION_DELAY")
	public int getActionDelay() {
		return actionDelay;
	}

	public void setActionDelay(int actionDelay) {
		this.actionDelay = actionDelay;
	}

	@Column(name = "ACTION_END_DTTM")
	public Timestamp getActionEndDttm() {
		return actionEndDttm;
	}

	public void setActionEndDttm(Timestamp actionEndDttm) {
		this.actionEndDttm = actionEndDttm;
	}

	@Column(name = "ACTION_MONTHS")
	public String getActionMonths() {
		return actionMonths;
	}

	public void setActionMonths(String actionMonths) {
		this.actionMonths = actionMonths;
	}

	@Column(name = "ACTION_MONTHS_DAYS")
	public String getActionMonthsDays() {
		return actionMonthsDays;
	}

	public void setActionMonthsDays(String actionMonthsDays) {
		this.actionMonthsDays = actionMonthsDays;
	}
	
	@Column(name = "ACTION_WEEK_DAYS")
	public String getActionWeekDays() {
		return actionWeekDays;
	}

	public void setActionWeekDays(String actionWeekDays) {
		this.actionWeekDays = actionWeekDays;
	}

	@Column(name = "REPORTS")
	public String getReports() {
		return reports;
	}

	public void setReports(String reports) {
		this.reports = reports;
	}
	
	@Column(name = "REPEAT_TIME")
	public String getRepeatTime() {
		return repeatTime;
	}

	public void setRepeatTime(String repeatTime) {
		this.repeatTime = repeatTime;
	}
	
	@Column(name = "LOCALE")
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	@Column(name = "LAST_RUN_TIME_DTTM")
	public Timestamp getlastRunTime() {
		return lastRunTime;
	}

	public void setlastRunTime(Timestamp lastRunTime) {
		this.lastRunTime = lastRunTime;
	}
	
	@Transient
	public int get_userRoleId() {
		return _userRoleId;
	}

	public void set_userRoleId(int userRoleId) {
		_userRoleId = userRoleId;
	}
	@Id
	@Column(name = "CUSTOMIZATION_ID")
	public int getCustomizationId() {
		return customizationId;
	}

	public void setCustomizationId(int customizationId) {
		this.customizationId = customizationId;
	}
	
	@Column(name = "TODAY_FLAG")
	public int getTodayFlag() {
		return todayFlag;
	}

	public void setTodayFlag(int todayFlag) {
		this.todayFlag = todayFlag;
	}
	
	@Column(name = "TODAY_ADD_DAY_VALUE")
	public int getTodayAddDayValue() {
		return todayAddDayValue;
	}

	public void setTodayAddDayValue(int todayAddDayValue) {
		this.todayAddDayValue = todayAddDayValue;
	}
	

}
