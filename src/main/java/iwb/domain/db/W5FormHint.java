package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;


@Entity
@Immutable
@Table(name="w5_form_hint",schema="iwb")
public class W5FormHint implements java.io.Serializable, W5Base {

	private int formHintId;
	private int formId;
	
	private String dsc;

	private String locale;

	private String hintColor;
	private String hintTip;

	private short tabOrder;
	private String actionTips;
	private short activeFlag;

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

	@Id
	@Column(name="form_hint_id")
	public int getFormHintId() {
		return formHintId;
	}
	public void setFormHintId(int formHintId) {
		this.formHintId = formHintId;
	}
	@Column(name="locale")
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	@Column(name="hint_color")
	public String getHintColor() {
		return hintColor;
	}
	public void setHintColor(String hintColor) {
		this.hintColor = hintColor;
	}
	@Column(name="hint_tip")
	public String getHintTip() {
		return hintTip;
	}
	public void setHintTip(String hintTip) {
		this.hintTip = hintTip;
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
		return false;
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
