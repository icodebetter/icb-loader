package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;


@Entity
@Immutable
@Table(name="w5_table_access_condition_sql",schema="iwb")
public class W5TableAccessConditionSql implements java.io.Serializable, W5Base {

	private int accessConditionSqlId;

	private int tableId; //gelen table'in PK'si

	private String conditionCode;

	@Id
	@Column(name="access_condition_sql_id")
	public int getAccessConditionSqlId() {
		return accessConditionSqlId;
	}

	public void setAccessConditionSqlId(int accessConditionSqlId) {
		this.accessConditionSqlId = accessConditionSqlId;
	}
	@Column(name="table_id")
	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	@Column(name="condition_code")
	public String getConditionCode() {
		return conditionCode;
	}

	public void setConditionCode(String conditionCode) {
		this.conditionCode = conditionCode;
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
