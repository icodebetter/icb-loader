package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;


@Entity
@Immutable
@Table(name="w5_ts_measurement_field")
public class W5TsMeasurementField implements java.io.Serializable {
	private static final long serialVersionUID = -3436475318977082282L;

	private int measurementFieldId;
	private int measurementId;
	
	private String dsc;
	private short fieldTip;
	private short accessViewTip;
	private String accessViewRoles;
	private String accessViewUsers;
//	  measurement_source_tip smallint NOT NULL DEFAULT 0,
//	  measurement_object_id integer NOT NULL DEFAULT 0,
	public W5TsMeasurementField(){
	}
	@Id
	@Column(name="measurement_field_id")
	public int getMeasurementFieldId() {
		return measurementFieldId;
	}

	public void setMeasurementFieldId(int measurementFieldId) {
		this.measurementFieldId = measurementFieldId;
	}

	@Column(name="field_tip")
	public short getFieldTip() {
		return fieldTip;
	}

	public void setFieldTip(short fieldTip) {
		this.fieldTip = fieldTip;
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
