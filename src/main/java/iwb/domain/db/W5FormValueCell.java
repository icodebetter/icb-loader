package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;


@Entity
@Immutable
@Table(name="w5_form_value_cell",schema="iwb")
public class W5FormValueCell implements java.io.Serializable {

	private int formCellId;
	private int formValueId;
	private String val;
	private int customizationId;
	
	@Id
	@Column(name="form_cell_id")
	public int getFormCellId() {
		return formCellId;
	}

	public void setFormCellId(int formCellId) {
		this.formCellId = formCellId;
	}

	@Column(name="form_value_id")
	public int getFormValueId() {
		return formValueId;
	}

	public void setFormValueId(int formValueId) {
		this.formValueId = formValueId;
	}
	
	@Column(name="val")
	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
	@Id
	@Column(name="customization_id")
	public int getCustomizationId() {
		return customizationId;
	}


	public void setCustomizationId(int customizationId) {
		this.customizationId = customizationId;
	}


}
