package iwb.domain.db;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="w5_ws_method_param",schema="iwb")
public class W5WsMethodParam  implements java.io.Serializable, W5Param {

	private int wsMethodParamId;
	private int wsMethodId;
	private int parentWsMethodParamId;
	private String dsc;
	private short paramTip;
	private String uid;
	private short outFlag;
	private short credentialsFlag;
	private short notNullFlag;
	private short tabOrder;
	private short sourceTip;

	private String defaultValue;
	private	BigDecimal	minValue;
	private	BigDecimal	maxValue;
	
	private	Short	minLength;
	private	Short	maxLength;

	@Id
	@Column(name="ws_method_param_id")
	public int getWsMethodParamId() {
		return wsMethodParamId;
	}
	public void setWsMethodParamId(int wsMethodParamId) {
		this.wsMethodParamId = wsMethodParamId;
	}
	@Column(name="param_tip")
	public short getParamTip() {
		return paramTip;
	}
	public void setParamTip(short paramTip) {
		this.paramTip = paramTip;
	}
	@Column(name="ws_method_id")
	public int getWsMethodId() {
		return wsMethodId;
	}
	public void setWsMethodId(int wsMethodId) {
		this.wsMethodId = wsMethodId;
	}

	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	
	@Column(name="uid")
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	@Column(name="out_flag")
	public short getOutFlag() {
		return outFlag;
	}
	public void setOutFlag(short outFlag) {
		this.outFlag = outFlag;
	}
	
	@Column(name="not_null_flag")
	public short getNotNullFlag() {
		return notNullFlag;
	}
	public void setNotNullFlag(short notNullFlag) {
		this.notNullFlag = notNullFlag;
	}
	
	@Column(name="tab_order")
	public short getTabOrder() {
		return tabOrder;
	}
	public void setTabOrder(short tabOrder) {
		this.tabOrder = tabOrder;
	}

	@Column(name="min_value")
	public BigDecimal getMinValue() {
		return minValue;
	}

	public void setMinValue(BigDecimal minValue) {
		this.minValue = minValue;
	}

	@Column(name="max_value")
	public BigDecimal getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(BigDecimal maxValue) {
		this.maxValue = maxValue;
	}

	@Column(name="min_length")
	public Short getMinLength() {
		return minLength;
	}
	
	public void setMinLength(Short minLength) {
		this.minLength = minLength;
	}

	@Column(name="max_length")
	public Short getMaxLength() {
		return maxLength;
	}


	public void setMaxLength(Short maxLength) {
		this.maxLength = maxLength;
	}
	@Column(name="source_tip")
	public short getSourceTip() {
		return sourceTip;
	}

	public void setSourceTip(short sourceTip) {
		this.sourceTip = sourceTip;
	}

	
	@Column(name="default_value")
	public String getDefaultValue() {
		return defaultValue;
	}
	
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	@Column(name="parent_ws_method_param_id")
	public int getParentWsMethodParamId() {
		return parentWsMethodParamId;
	}
	public void setParentWsMethodParamId(int parentWsMethodParamId) {
		this.parentWsMethodParamId = parentWsMethodParamId;
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
	@Column(name="credentials_flag")
	public short getCredentialsFlag() {
		return credentialsFlag;
	}
	public void setCredentialsFlag(short credentialsFlag) {
		this.credentialsFlag = credentialsFlag;
	}
	
}
