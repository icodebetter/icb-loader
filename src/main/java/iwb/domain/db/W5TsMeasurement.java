package iwb.domain.db;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;


@Entity
@Immutable
@Table(name="w5_ts_measurement")
public class W5TsMeasurement implements java.io.Serializable {
	private static final long serialVersionUID = -3436475318977082282L;

	private int measurementId;
	
	private String dsc;
	private int tableId;
	private int tablePk;
	private String tagCode;
	private short measurementSourceTip;
	private int measurementObjectId;
	private String extraCode;
	private short accessViewTip;
	private String accessViewRoles;
	private String accessViewUsers;
//	  measurement_source_tip smallint NOT NULL DEFAULT 0,
//	  measurement_object_id integer NOT NULL DEFAULT 0,
	private List<W5TsMeasurementField> _measurementFields;
	
	public W5TsMeasurement(){
	}



	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	
	@Id
	@Column(name="measurement_id")
	public int getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(int measurementId) {
		this.measurementId = measurementId;
	}

	@Column(name="table_id")
	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	@Column(name="table_pk")
	public int getTablePk() {
		return tablePk;
	}

	public void setTablePk(int tablePk) {
		this.tablePk = tablePk;
	}

	@Column(name="tag_code")
	public String getTagCode() {
		return tagCode;
	}

	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	
	@Column(name="access_view_tip")
	public short getAccessViewTip() {
		return accessViewTip;
	}

	@Column(name="access_view_roles")
	public String getAccessViewRoles() {
		return accessViewRoles;
	}

	@Column(name="access_view_users")
	public String getAccessViewUsers() {
		return accessViewUsers;
	}

	public void setAccessViewTip(short accessViewTip) {
		this.accessViewTip = accessViewTip;
	}

	public void setAccessViewRoles(String accessViewRoles) {
		this.accessViewRoles = accessViewRoles;
    }
	
	public void setAccessViewUsers(String accessViewUsers) {
		this.accessViewUsers = accessViewUsers;
	}

	@Column(name="measurement_source_tip")
	public short getMeasurementSourceTip() {
		return measurementSourceTip;
	}

	public void setMeasurementSourceTip(short measurementSourceTip) {
		this.measurementSourceTip = measurementSourceTip;
	}

	@Column(name="measurement_object_id")
	public int getMeasurementObjectId() {
		return measurementObjectId;
	}

	public void setMeasurementObjectId(int measurementObjectId) {
		this.measurementObjectId = measurementObjectId;
	}

	@Column(name="extra_code")
	public String getExtraCode() {
		return extraCode;
	}

	public void setExtraCode(String extraCode) {
		this.extraCode = extraCode;
	}

	@Transient
	public List<W5TsMeasurementField> get_measurementFields() {
		return _measurementFields;
	}

	public void set_measurementFields(List<W5TsMeasurementField> _measurementFields) {
		this._measurementFields = _measurementFields;
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
