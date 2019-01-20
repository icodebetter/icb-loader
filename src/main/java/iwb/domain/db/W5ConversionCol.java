package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

import iwb.util.GenericUtil;

// Generated Jun 17, 2007 5:12:14 PM by Hibernate Tools 3.2.0.b9


@Entity
@Immutable
@Table(name="w5_conversion_col",schema="iwb")
public class W5ConversionCol implements java.io.Serializable, W5Base {

	private int conversionColId;
	private int conversionId;
	private short tabOrder;
	private String conversionCode;
	private short fieldConversionTip;
	private int formCellId;
	private short synchFlag;

	@Id
	@Column(name="conversion_col_id")
	public int getConversionColId() {
		return conversionColId;
	}
	public void setConversionColId(int conversionColId) {
		this.conversionColId = conversionColId;
	}
	@Column(name="conversion_id")
	public int getConversionId() {
		return conversionId;
	}
	public void setConversionId(int conversionId) {
		this.conversionId = conversionId;
	}
	
	@Column(name="tab_order")
	public short getTabOrder() {
		return this.tabOrder;
	}

	public void setTabOrder(short tabOrder) {
		this.tabOrder = tabOrder;
	}
	@Column(name="conversion_code")
	public String getConversionCode() {
		return conversionCode;
	}
	public void setConversionCode(String conversionCode) {
		this.conversionCode = conversionCode;
	}
	@Column(name="field_conversion_tip")
	public short getFieldConversionTip() {
		return fieldConversionTip;
	}
	public void setFieldConversionTip(short fieldConversionTip) {
		this.fieldConversionTip = fieldConversionTip;
	}
	@Column(name="form_cell_id")
	public int getFormCellId() {
		return formCellId;
	}
	public void setFormCellId(int formCellId) {
		this.formCellId = formCellId;
	}

	@Column(name="synch_flag")
	public short getSynchFlag() {
		return synchFlag;
	}
	public void setSynchFlag(short synchFlag) {
		this.synchFlag = synchFlag;
	}
	@Transient
	public boolean safeEquals(W5Base q){
		if(q==null)return false;
		W5ConversionCol c = (W5ConversionCol)q;
		return 
			this.conversionColId==c.getConversionColId() &&
			this.conversionId==c.getConversionId() &&
			this.tabOrder==c.getTabOrder() &&
			GenericUtil.safeEquals(this.conversionCode,c.getConversionCode()) &&
			this.fieldConversionTip==c.getFieldConversionTip() &&
			this.formCellId==c.getFormCellId();
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
