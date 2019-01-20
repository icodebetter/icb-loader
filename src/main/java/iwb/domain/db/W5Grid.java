package iwb.domain.db;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

import iwb.util.GenericUtil;

// Generated Feb 5, 2007 3:58:07 PM by Hibernate Tools 3.2.0.b9

@Entity
@Immutable
@Table(name="w5_grid",schema="iwb")
public class W5Grid implements java.io.Serializable, W5Base, W5ListBase {

	private int gridId;

	private String dsc;

	private int queryId;

	private String localeMsgKey;

	private short gridTip;

	private short defaultPageRecordNumber;

	private short defaultWidth;

	private short defaultHeight;

	private short selectionModeTip;
	
	private int pkQueryFieldId;

	private int autoExpandFieldId;

	private String defaultSqlOrderby;

	private int defaultCrudFormId;// burdan edit, insert vs olaylari incelenecek
	 
	private short columnRenderTip;
	private int groupingFieldId;
	private int treeMasterFieldId;
	private short insertEditModeFlag;

	
	private int _searchFormId;
	private	String jsCode;	

	private Map<String, W5QueryField> _queryFieldMapDsc;
	private W5QueryField	_pkQueryField;
	private W5QueryField	_autoExpandField;	
	private W5QueryField	_groupingField;	
	private W5QueryField	_fxRowField;	
	private	List<W5GridColumn> _gridColumnList;
	private	List<W5GridModule>	_gridModuleList;
	private	List<W5ObjectToolbarItem>	_toolbarItemList;
	private	List<W5ObjectMenuItem>	_menuItemList;
	private	List<W5FormSmsMail>	_crudFormSmsMailList;
	private	List<W5Conversion>	_crudFormConversionList;
	private	W5Form _defaultCrudForm;
	private	W5Table _viewTable;
	private	W5Table _crudTable;
	private W5Query	_query;	
	private List<W5QueryField> _postProcessQueryFields;
	private Map<Integer, W5QueryField> _queryFieldMap;
	private List<W5CustomGridColumnRenderer> _listCustomGridColumnRenderer;
	private List<W5CustomGridColumnCondition> _listCustomGridColumnCondition;
	private short rowColorFxTip;
	private int rowColorFxQueryFieldId;
	private W5Workflow _approval;
	
	@Id
	@Column(name="grid_id")
	public int getGridId() {
		return gridId;
	}
	public void setGridId(int gridId) {
		this.gridId = gridId;
	}
	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	@Column(name="query_id")
	public int getQueryId() {
		return queryId;
	}
	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}
	@Column(name="locale_msg_key")
	public String getLocaleMsgKey() {
		return localeMsgKey;
	}
	public void setLocaleMsgKey(String localeMsgKey) {
		this.localeMsgKey = localeMsgKey;
	}
	@Column(name="grid_tip")
	public short getGridTip() {
		return gridTip;
	}
	public void setGridTip(short gridTip) {
		this.gridTip = gridTip;
	}
	@Column(name="default_page_record_number")
	public short getDefaultPageRecordNumber() {
		return defaultPageRecordNumber;
	}
	public void setDefaultPageRecordNumber(short defaultPageRecordNumber) {
		this.defaultPageRecordNumber = defaultPageRecordNumber;
	}
	@Column(name="default_width")
	public short getDefaultWidth() {
		return defaultWidth;
	}
	public void setDefaultWidth(short defaultWidth) {
		this.defaultWidth = defaultWidth;
	}
	@Column(name="default_height")
	public short getDefaultHeight() {
		return defaultHeight;
	}
	public void setDefaultHeight(short defaultHeight) {
		this.defaultHeight = defaultHeight;
	}
	@Column(name="selection_mode_tip")
	public short getSelectionModeTip() {
		return selectionModeTip;
	}
	public void setSelectionModeTip(short selectionMode) {
		this.selectionModeTip = selectionMode;
	}
	@Column(name="pk_query_field_id")
	public int getPkQueryFieldId() {
		return pkQueryFieldId;
	}
	public void setPkQueryFieldId(int pkQueryFieldId) {
		this.pkQueryFieldId = pkQueryFieldId;
	}
	@Column(name="auto_expand_field_id")
	public int getAutoExpandFieldId() {
		return autoExpandFieldId;
	}
	public void setAutoExpandFieldId(int autoExpandFieldId) {
		this.autoExpandFieldId = autoExpandFieldId;
	}

	@Column(name="default_sql_order_by")
	public String getDefaultSqlOrderby() {
		return defaultSqlOrderby;
	}
	public void setDefaultSqlOrderby(String defaultSqlOrderby) {
		this.defaultSqlOrderby = defaultSqlOrderby;
	}
	@Transient
	public W5QueryField get_pkQueryField() {
		return _pkQueryField;
	}
	public void set_pkQueryField(W5QueryField pkQueryField) {
		_pkQueryField = pkQueryField;
	}
	@Transient
	public W5QueryField get_autoExpandField() {
		return _autoExpandField;
	}
	public void set_autoExpandField(W5QueryField autoExpandField) {
		_autoExpandField = autoExpandField;
	}
	@Transient
	public List<W5GridColumn> get_gridColumnList() {
		return _gridColumnList;
	}
	public void set_gridColumnList(List<W5GridColumn> gridColumnList) {
		_gridColumnList = gridColumnList;
	}

	@Column(name="default_crud_form_id")
	public int getDefaultCrudFormId() {
		return defaultCrudFormId;
	}
	public void setDefaultCrudFormId(int defaultCrudFormId) {
		this.defaultCrudFormId = defaultCrudFormId;
	}
	
	@Transient
	public List<W5ObjectToolbarItem> get_toolbarItemList() {
		return _toolbarItemList;
	}
	public void set_toolbarItemList(List<W5ObjectToolbarItem> toolbarItemList) {
		_toolbarItemList = toolbarItemList;
	}
	
	@Transient
	public W5Form get_defaultCrudForm() {
		return _defaultCrudForm;
	}
	public void set_defaultCrudForm(W5Form defaultCrudForm) {
		_defaultCrudForm = defaultCrudForm;
	}
	
	@Transient
	public List<W5ObjectMenuItem> get_menuItemList() {
		return _menuItemList;
	}
	public void set_menuItemList(List<W5ObjectMenuItem> menuItemList) {
		_menuItemList = menuItemList;
	}
	@Transient
	public W5Query get_query() {
		return _query;
	}
	public void set_query(W5Query query) {
		_query = query;
	}
	@Transient
	public List<W5GridModule> get_gridModuleList() {
		return _gridModuleList;
	}
	public void set_gridModuleList(List<W5GridModule> gridModuleList) {
		_gridModuleList = gridModuleList;
	}
	
	
	@Column(name="column_render_tip")
	public short getColumnRenderTip() {
		return columnRenderTip;
	}
	public void setColumnRenderTip(short columnRenderTip) {
		this.columnRenderTip = columnRenderTip;
	}
	
	@Column(name="grouping_field_id")
	public int getGroupingFieldId() {
		return groupingFieldId;
	}
	public void setGroupingFieldId(int groupingFieldId) {
		this.groupingFieldId = groupingFieldId;
	}
	
	@Transient
	public W5QueryField get_groupingField() {
		return _groupingField;
	}
	public void set_groupingField(W5QueryField groupingField) {
		_groupingField = groupingField;
	}
	
	@Column(name="code")
	public String getJsCode() {
		return jsCode;
	}
	public void setJsCode(String code) {
		this.jsCode = code;
	}
	
	@Transient
	public Map<String, W5QueryField> get_queryFieldMapDsc() {
		return _queryFieldMapDsc;
	}
	public void set_queryFieldMapDsc(Map<String, W5QueryField> queryFieldMapDsc) {
		_queryFieldMapDsc = queryFieldMapDsc;
	}
	
	@Transient
	public List<W5QueryField> get_postProcessQueryFields() {
		return _postProcessQueryFields;
	}
	public void set_postProcessQueryFields(List<W5QueryField> postProcessQueryFields) {
		_postProcessQueryFields = postProcessQueryFields;
	}
	@Column(name="insert_edit_mode_flag")
	public short getInsertEditModeFlag() {
		return insertEditModeFlag;
	}
	public void setInsertEditModeFlag(short insertEditModeFlag) {
		this.insertEditModeFlag = insertEditModeFlag;
	}

	@Transient	
	public W5Table get_viewTable() {
		return _viewTable;
	}
	public void set_viewTable(W5Table mainTable) {
		_viewTable = mainTable;
	}
	
	@Transient
	public Map<Integer, W5QueryField> get_queryFieldMap() {
		return _queryFieldMap;
	}

	public void set_queryFieldMap(Map<Integer, W5QueryField> queryFieldMap) {
		this._queryFieldMap = queryFieldMap;
	}
	@Transient
	public int get_searchFormId() {
		return _searchFormId;
	}
	public void set_searchFormId(int searchFormId) {
		_searchFormId = searchFormId;
	}
	@Column(name="tree_master_field_id")
	public int getTreeMasterFieldId() {
		return treeMasterFieldId;
	}
	public void setTreeMasterFieldId(int treeMasterFieldId) {
		this.treeMasterFieldId = treeMasterFieldId;
	}
	
	@Transient
	public List<W5CustomGridColumnRenderer> get_listCustomGridColumnRenderer() {
		return _listCustomGridColumnRenderer;
	}
	public void set_listCustomGridColumnRenderer(
			List<W5CustomGridColumnRenderer> listCustomGridColumnRenderer) {
		_listCustomGridColumnRenderer = listCustomGridColumnRenderer;
	}
	@Column(name="row_color_fx_tip")
	public short getRowColorFxTip() {
		return rowColorFxTip;
	}

	public void setRowColorFxTip(short rowColorFxTip) {
		this.rowColorFxTip = rowColorFxTip;
	}

	@Column(name="row_color_fx_query_field_id")
	public int getRowColorFxQueryFieldId() {
		return rowColorFxQueryFieldId;
	}

	public void setRowColorFxQueryFieldId(int rowColorFxQueryFieldId) {
		this.rowColorFxQueryFieldId = rowColorFxQueryFieldId;
	}
	@Transient
	public W5QueryField get_fxRowField() {
		return _fxRowField;
	}
	public void set_fxRowField(W5QueryField fxRowField) {
		_fxRowField = fxRowField;
	}
	@Transient
	public List<W5CustomGridColumnCondition> get_listCustomGridColumnCondition() {
		return _listCustomGridColumnCondition;
	}
	public void set_listCustomGridColumnCondition(
			List<W5CustomGridColumnCondition> listCustomGridColumnCondition) {
		_listCustomGridColumnCondition = listCustomGridColumnCondition;
	}
	@Transient
	public List<W5FormSmsMail> get_crudFormSmsMailList() {
		return _crudFormSmsMailList;
	}
	public void set_crudFormSmsMailList(List<W5FormSmsMail> crudFormSmsMailList) {
		_crudFormSmsMailList = crudFormSmsMailList;
	}
	@Transient
	public List<W5Conversion> get_crudFormConversionList() {
		return _crudFormConversionList;
	}
	public void set_crudFormConversionList(List<W5Conversion> crudFormConversionList) {
		_crudFormConversionList = crudFormConversionList;
	}

	@Transient
	public W5Table get_crudTable() {
		return _crudTable;
	}
	public void set_crudTable(W5Table crudTable) {
		_crudTable = crudTable;
	}	
	
	@Transient
	public boolean safeEquals(W5Base q){
		if(q==null)return false;
		W5Grid g = (W5Grid)q;
		boolean b = this.gridId == g.getGridId() &&

		GenericUtil.safeEquals(this.dsc, g.getDsc()) &&

		this.queryId == g.getQueryId() &&

		GenericUtil.safeEquals(this.localeMsgKey, g.getLocaleMsgKey()) &&

		this.gridTip == g.getGridTip() &&

		this.defaultPageRecordNumber == g.getDefaultPageRecordNumber() &&

		this.defaultWidth == g.getDefaultWidth() &&

		this.defaultHeight == g.getDefaultHeight() &&

		this.selectionModeTip == g.getSelectionModeTip() &&
		
		this.pkQueryFieldId == g.getPkQueryFieldId() &&

		this.autoExpandFieldId == g.getAutoExpandFieldId() &&
		
		
		GenericUtil.safeEquals(this.defaultSqlOrderby, g.getDefaultSqlOrderby()) &&

		this.defaultCrudFormId == g.getDefaultCrudFormId() &&// burdan edit, insert vs olaylari incelenecek
		 
		this.columnRenderTip == g.getColumnRenderTip() &&
		this.groupingFieldId == g.getGroupingFieldId() &&
		this.treeMasterFieldId == g.getTreeMasterFieldId() &&
		this.insertEditModeFlag == g.getInsertEditModeFlag() &&

		GenericUtil.safeEquals(jsCode, g.getJsCode());	
		
		if(!b)return false;
		
		if(!GenericUtil.safeEquals(this._gridColumnList, g._gridColumnList))return false;
/*		if(this._gridColumnList!=null && g.get_gridColumnList()!=null){
			if(this._gridColumnList.size()==g.get_gridColumnList().size())return false;
			for(int i=0;i<this._gridColumnList.size();i++){
				W5GridColumn c1 = this._gridColumnList.get(i); 
				W5GridColumn c2 = g.get_gridColumnList().get(i);
				if(!c1.equals(c2))return false;
			}			
		} else if(this._gridColumnList!=null ^ g.get_gridColumnList()!=null) return false;*/
		
		if(!GenericUtil.safeEquals(this._gridModuleList, g._gridModuleList))return false;
/*		if(this._gridModuleList!=null && g.get_gridModuleList()!=null){
			if(this._gridModuleList.size()==g.get_gridModuleList().size())return false;
			for(int i=0;i<this._gridModuleList.size();i++){
				W5GridModule c1 = this._gridModuleList.get(i); 
				W5GridModule c2 = g.get_gridModuleList().get(i);
				if(!c1.equals(c2))return false;
			}			
		} else if(this._gridModuleList!=null ^ g.get_gridModuleList()!=null) return false;*/
		
		if(!GenericUtil.safeEquals(this._toolbarItemList, g._toolbarItemList))return false;
/*		if(this._toolbarItemList!=null && g.get_toolbarItemList()!=null){
			if(this._toolbarItemList.size()==g.get_toolbarItemList().size())return false;
			for(int i=0;i<this._toolbarItemList.size();i++){
				W5ObjectToolbarItem c1 = this._toolbarItemList.get(i); 
				W5ObjectToolbarItem c2 = g.get_toolbarItemList().get(i);
				if(!c1.equals(c2))return false;
			}			
		} else if(this._toolbarItemList!=null ^ g.get_toolbarItemList()!=null) return false;*/
		
		if(!GenericUtil.safeEquals(this._menuItemList, g._menuItemList))return false;
/*		if(this._menuItemList!=null && g.get_menuItemList()!=null){
			if(this._menuItemList.size()==g.get_menuItemList().size())return false;
			for(int i=0;i<this._menuItemList.size();i++){
				W5ObjectMenuItem c1 = this._menuItemList.get(i); 
				W5ObjectMenuItem c2 = g.get_menuItemList().get(i);
				if(!c1.equals(c2))return false;
			}			
		} else if(this._menuItemList!=null ^ g.get_menuItemList()!=null) return false;*/
		
		if(!GenericUtil.safeEquals(this._crudFormSmsMailList, g._crudFormSmsMailList))return false;
/*		if(this._crudFormSmsMailList!=null && g.get_crudFormSmsMailList()!=null){
			if(this._crudFormSmsMailList.size()==g.get_crudFormSmsMailList().size())return false;
			for(int i=0;i<this._crudFormSmsMailList.size();i++){
				W5FormSmsMail c1 = this._crudFormSmsMailList.get(i); 
				W5FormSmsMail c2 = g.get_crudFormSmsMailList().get(i);
				if(!c1.equals(c2))return false;
			}			
		} else if(this._crudFormSmsMailList!=null ^ g.get_crudFormSmsMailList()!=null) return false;*/
		
		if(!GenericUtil.safeEquals(this._crudFormConversionList, g._crudFormConversionList))return false;
/*		if(this._crudFormConversionList!=null && g.get_crudFormConversionList()!=null){
			if(this._crudFormConversionList.size()==g.get_crudFormConversionList().size())return false;
			for(int i=0;i<this._crudFormConversionList.size();i++){
				W5Conversion c1 = this._crudFormConversionList.get(i); 
				W5Conversion c2 = g.get_crudFormConversionList().get(i);
				if(!c1.equals(c2))return false;
			}			
		} else if(this._crudFormConversionList!=null ^ g.get_crudFormConversionList()!=null) return false;*/
		
		if(!GenericUtil.safeEquals(this._approval, g._approval))return false;
		
		return true;
	}
	
	@Transient
	public W5Workflow get_workflow() {
		return _approval;
	}
	public void set_workflow(W5Workflow approval) {
		_approval = approval;
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
