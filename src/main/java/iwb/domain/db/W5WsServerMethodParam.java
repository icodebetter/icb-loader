package iwb.domain.db;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="w5_ws_server_method_param",schema="iwb")
public class W5WsServerMethodParam  implements java.io.Serializable, W5Param {

	private int wsServerMethodParamId;
	private int wsServerMethodId;
	private String dsc;
	private short paramTip;
	private short outFlag;
	private short notNullFlag;
	private short tabOrder;
	private short sourceTip;
	private int objectDetailId;

	private String defaultValue;
	private	BigDecimal	minValue;
	private	BigDecimal	maxValue;
	
	private	Short	minLength;
	private	Short	maxLength;
	private int parentWsMethodParamId;

	public W5WsServerMethodParam() {
		super();
	}

	public W5WsServerMethodParam(W5Param p, short outFlag, int parentWsMethodParamId) {
		super();
		this.dsc = p.getDsc();
		this.paramTip = p.getParamTip();
		this.outFlag = outFlag;
		this.sourceTip = p.getSourceTip();
		this.notNullFlag = p.getNotNullFlag();
		this.minValue = p.getMinValue();
		this.maxValue = p.getMaxValue();
		this.defaultValue = p.getDefaultValue();
		this.parentWsMethodParamId = parentWsMethodParamId;
	}
	
	public W5WsServerMethodParam(int wsServerMethodParamId, String dsc, short paramTip) {
		super();
		this.wsServerMethodParamId = wsServerMethodParamId;
		this.dsc = dsc;
		this.paramTip = paramTip;
		this.outFlag = (short)1;
	}
	
	@Id
	@Column(name="ws_server_method_param_id")
	public int getWsServerMethodParamId() {
		return wsServerMethodParamId;
	}
	public void setWsServerMethodParamId(int wsServerMethodParamId) {
		this.wsServerMethodParamId = wsServerMethodParamId;
	}
	@Column(name="param_tip")
	public short getParamTip() {
		return paramTip;
	}
	public void setParamTip(short paramTip) {
		this.paramTip = paramTip;
	}
	@Column(name="ws_server_method_id")
	public int getWsServerMethodId() {
		return wsServerMethodId;
	}
	public void setWsServerMethodId(int wsServerMethodId) {
		this.wsServerMethodId = wsServerMethodId;
	}

	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
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
	
	@Column(name="object_detail_id")
	public int getObjectDetailId() {
		return objectDetailId;
	}
	public void setObjectDetailId(int objectDetailId) {
		this.objectDetailId = objectDetailId;
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
