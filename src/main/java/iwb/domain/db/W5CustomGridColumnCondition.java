package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

// Generated Jun 17, 2007 5:12:14 PM by Hibernate Tools 3.2.0.b9


@Entity
@Immutable
@Table(name="w5_custom_grid_column_condtion", schema="iwb")
public class W5CustomGridColumnCondition implements java.io.Serializable {

	private int customGridColumnConditionId;
	private int gridId;
	private int queryFieldId;
	private short tabOrder;
	private short operatorTip;
	private String conditionVal;
	private String cssVal;	
	
	@Id
	@Column(name="custom_grid_column_condtion_id")
	public int getCustomGridColumnConditionId() {
		return customGridColumnConditionId;
	}
	public void setCustomGridColumnConditionId(int customGridColumnConditionId) {
		this.customGridColumnConditionId = customGridColumnConditionId;
	}

	@Column(name="grid_id")
	public int getGridId() {
		return gridId;
	}
	public void setGridId(int gridId) {
		this.gridId = gridId;
	}
	@Column(name="tab_order")
	public short getTabOrder() {
		return tabOrder;
	}
	public void setTabOrder(short tabOrder) {
		this.tabOrder = tabOrder;
	}
	@Column(name="operator_tip")
	public short getOperatorTip() {
		return operatorTip;
	}
	public void setOperatorTip(short operatorTip) {
		this.operatorTip = operatorTip;
	}
	@Column(name="condition_val")
	public String getConditionVal() {
		return conditionVal;
	}
	public void setConditionVal(String val) {
		this.conditionVal = val;
	}
	@Column(name="css_val")
	public String getCssVal() {
		return cssVal;
	}
	public void setCssVal(String cssVal) {
		this.cssVal = cssVal;
	}	
	@Column(name="query_field_id")
	public int getQueryFieldId() {
		return queryFieldId;
	}
	public void setQueryFieldId(int queryFieldId) {
		this.queryFieldId = queryFieldId;
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
