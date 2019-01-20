package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

// Generated Jun 17, 2007 5:12:14 PM by Hibernate Tools 3.2.0.b9


@Entity
@Immutable
@Table(name="w5_custom_grid_column_renderer", schema="iwb")
public class W5CustomGridColumnRenderer implements java.io.Serializable {

	private int customGridColumnRendererId;
	private int gridId;
	private int queryFieldId;
	private String lookupDetayVal;
	private String cssVal;
	
	@Id
	@Column(name="custom_grid_column_renderer_id")
	public int getCustomGridColumnRendererId() {
		return customGridColumnRendererId;
	}
	public void setCustomGridColumnRendererId(int customGridColumnRendererId) {
		this.customGridColumnRendererId = customGridColumnRendererId;
	}

	@Column(name="grid_id")
	public int getGridId() {
		return gridId;
	}
	public void setGridId(int gridId) {
		this.gridId = gridId;
	}
	@Column(name="lookup_detay_val")
	public String getLookupDetayVal() {
		return lookupDetayVal;
	}
	public void setLookupDetayVal(String lookupDetayVal) {
		this.lookupDetayVal = lookupDetayVal;
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
