package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;


@Entity
@Immutable
@Table(name="w5_bi_graph_dashboard",schema="iwb")
public class W5BIGraphDashboard implements java.io.Serializable, W5Base {
/*
 * graph_dashboard_id integer NOT NULL,
  project_uuid character varying(36) NOT NULL DEFAULT '067e6162-3b6f-4ae2-a221-2470b63dff00'::character varying,
  customization_id integer NOT NULL DEFAULT 0,
  grid_id integer NOT NULL,
  table_id integer NOT NULL DEFAULT 0,
  locale_msg_key character varying(128) NOT NULL,
  query_base_params character varying(512),
  public_flag smallint NOT NULL DEFAULT 0,
  graph_tip smallint NOT NULL DEFAULT 1,
  graph_group_by_field character varying(256) NOT NULL,
  graph_func_tip smallint NOT NULL DEFAULT 1,
  graph_func_fields character varying(256) NOT NULL,
 */
	private int graphDashboardId;
	
	private int customizationId;

	private int gridId; //gelen table'in PK'si

	private int tableId; //gelen table'in PK'si

	private String localeMsgKey;
	private String queryBaseParams;
	private short publicFlag; //gelen table'in PK'si
	private short graphTip; //gelen table'in PK'si
	private short is3dFlag; //gelen table'in PK'si
	private short legendFlag; //gelen table'in PK'si
	private short dtTip; //gelen table'in PK'si
	private String graphGroupByField;
	private int stackedQueryField; //gelen table'in PK'si
	private short graphFuncTip; //gelen table'in PK'si
	private String graphFuncFields;
	private int defaultHeight; //gelen table'in PK'si
	
	@Id
	@Column(name="graph_dashboard_id")
	public int getGraphDashboardId() {
		return graphDashboardId;
	}


	public void setGraphDashboardId(int graphDashboardId) {
		this.graphDashboardId = graphDashboardId;
	}


	@Id
	@Column(name="customization_id")
	public int getCustomizationId() {
		return customizationId;
	}


	public void setCustomizationId(int customizationId) {
		this.customizationId = customizationId;
	}

	@Column(name="grid_id")
	public int getGridId() {
		return gridId;
	}


	public void setGridId(int gridId) {
		this.gridId = gridId;
	}

	@Column(name="table_id")
	public int getTableId() {
		return tableId;
	}


	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	@Column(name="locale_msg_key")
	public String getLocaleMsgKey() {
		return localeMsgKey;
	}


	public void setLocaleMsgKey(String localeMsgKey) {
		this.localeMsgKey = localeMsgKey;
	}

	@Column(name="graph_tip")
	public short getGraphTip() {
		return graphTip;
	}


	public void setGraphTip(short graphTip) {
		this.graphTip = graphTip;
	}


	@Column(name="query_base_params")
	public String getQueryBaseParams() {
		return queryBaseParams;
	}


	public void setQueryBaseParams(String queryBaseParams) {
		this.queryBaseParams = queryBaseParams;
	}


	@Column(name="public_flag")
	public short getPublicFlag() {
		return publicFlag;
	}


	public void setPublicFlag(short publicFlag) {
		this.publicFlag = publicFlag;
	}

	@Column(name="graph_func_tip")
	public short getGraphFuncTip() {
		return graphFuncTip;
	}


	public void setGraphFuncTip(short graphFuncTip) {
		this.graphFuncTip = graphFuncTip;
	}


	@Column(name="graph_group_by_field")
	public String getGraphGroupByField() {
		return graphGroupByField;
	}



	public void setGraphGroupByField(String graphGroupByField) {
		this.graphGroupByField = graphGroupByField;
	}


	@Column(name="graph_func_fields")
	public String getGraphFuncFields() {
		return graphFuncFields;
	}


	public void setGraphFuncFields(String graphFuncFields) {
		this.graphFuncFields = graphFuncFields;
	}


	@Column(name="is_3d_flag")
	public short getIs3dFlag() {
		return is3dFlag;
	}


	public void setIs3dFlag(short is3dFlag) {
		this.is3dFlag = is3dFlag;
	}

	@Column(name="stacked_field_id")
	public int getStackedQueryField() {
		return stackedQueryField;
	}


	public void setStackedQueryField(int stackedQueryField) {
		this.stackedQueryField = stackedQueryField;
	}

	@Column(name="default_height")
	public int getDefaultHeight() {
		return defaultHeight;
	}


	public void setDefaultHeight(int defaultHeight) {
		this.defaultHeight = defaultHeight;
	}

	@Column(name="legend_flag")
	public short getLegendFlag() {
		return legendFlag;
	}


	public void setLegendFlag(short legendFlag) {
		this.legendFlag = legendFlag;
	}

	@Column(name="dt_tip")
	public short getDtTip() {
		return dtTip;
	}


	public void setDtTip(short dtTip) {
		this.dtTip = dtTip;
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
	@Transient
	public boolean safeEquals(W5Base q){
		return false;
	}

	
}
