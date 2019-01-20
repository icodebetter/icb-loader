package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="w5_form_cell_code_detail",schema="iwb")
public class W5FormCellCodeDetail implements java.io.Serializable, W5Base {

	private int formCellCodeDetailId;
	private int formCellId;
	private short tabOrder;
	private short codeTip;
	private short codeLength;
	private int sourceFormCellId;
	private int sourceFcQueryFieldId;
	private String defaultValue;
	private char fillCharacter;
	
	
	@Id
	@Column(name="form_cell_code_detail_id")
	public int getFormCellCodeDetailId() {
		return formCellCodeDetailId;
	}

	public void setFormCellCodeDetailId(int formCellCodeDetailId) {
		this.formCellCodeDetailId = formCellCodeDetailId;
	}

	@Column(name="code_tip")
	public short getCodeTip() {
		return codeTip;
	}

	public void setCodeTip(short codeTip) {
		this.codeTip = codeTip;
	}

	@Column(name="form_cell_id")
	public int getFormCellId() {
		return formCellId;
	}

	public void setFormCellId(int formCellId) {
		this.formCellId = formCellId;
	}


	@Column(name="tab_order")
	public short getTabOrder() {
		return tabOrder;
	}

	public void setTabOrder(short tabOrder) {
		this.tabOrder = tabOrder;
	}


	@Column(name="code_length")
	public short getCodeLength() {
		return codeLength;
	}

	public void setCodeLength(short codeLength) {
		this.codeLength = codeLength;
	}


	@Column(name="source_form_cell_id")
	public int getSourceFormCellId() {
		return sourceFormCellId;
	}

	public void setSourceFormCellId(int sourceFormCellId) {
		this.sourceFormCellId = sourceFormCellId;
	}


	@Column(name="default_value")
	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	@Column(name="fill_character")
	public char getFillCharacter() {
		return fillCharacter;
	}

	public void setFillCharacter(char fillCharacter) {
		this.fillCharacter = fillCharacter;
	}
	@Column(name="source_fc_query_field_id")
	public int getSourceFcQueryFieldId() {
		return sourceFcQueryFieldId;
	}

	public void setSourceFcQueryFieldId(int sourceFcQueryFieldId) {
		this.sourceFcQueryFieldId = sourceFcQueryFieldId;
	}
	
	@Transient
	public boolean safeEquals(W5Base q){
		if(q==null)return false;
		W5FormCellCodeDetail f = (W5FormCellCodeDetail)q;
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
