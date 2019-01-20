package iwb.domain.db;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

// Generated Feb 5, 2007 3:58:07 PM by Hibernate Tools 3.2.0.b9

@Entity
@Immutable
@Table(name="w5_list",schema="iwb")
public class W5List implements java.io.Serializable {

	private int listId;

	private String dsc;

	private int queryId;

	private String localeMsgKey;

	private short loadMaskFlag;

	private short defaultPageRecordNumber;

	private short defaultWidth;

	private short defaultHeight;

	private int pkQueryFieldId;

	private short selectionTip;
	
	private String defaultSqlOrderby;

	private int _searchFormId;
	private int _totalWidth;
	private	String jsCode;	

	private Map<String, W5QueryField> _queryFieldMapDsc;
	private W5QueryField	_pkQueryField;
	private	List<W5ListColumn> _listColumnList;
	private	List<W5ObjectToolbarItem>	_toolbarItemList;
	private	List<W5ObjectMenuItem>	_menuItemList;
	private	W5Form _defaultCrudForm;
	private	W5Table _mainTable;
	private W5Query	_query;	
	private Map<Integer, W5QueryField> _queryFieldMap;
	private List<W5CustomGridColumnRenderer> _listCustomGridColumnRenderer;

	
	@Id
	@Column(name="list_id")
	public int getListId() {
		return listId;
	}
	public void setListId(int gridId) {
		this.listId = gridId;
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

	@Column(name="pk_query_field_id")
	public int getPkQueryFieldId() {
		return pkQueryFieldId;
	}
	public void setPkQueryFieldId(int pkQueryFieldId) {
		this.pkQueryFieldId = pkQueryFieldId;
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
	public List<W5ListColumn> get_listColumnList() {
		return _listColumnList;
	}
	public void set_listColumnList(List<W5ListColumn> _listColumnList) {
		this._listColumnList = _listColumnList;
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
	
	
	@Column(name="js_code")
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
	public W5Table get_mainTable() {
		return _mainTable;
	}
	public void set_mainTable(W5Table mainTable) {
		_mainTable = mainTable;
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
	
	@Transient
	public List<W5CustomGridColumnRenderer> get_listCustomGridColumnRenderer() {
		return _listCustomGridColumnRenderer;
	}
	public void set_listCustomGridColumnRenderer(
			List<W5CustomGridColumnRenderer> listCustomGridColumnRenderer) {
		_listCustomGridColumnRenderer = listCustomGridColumnRenderer;
	}
	@Column(name="load_mask_flag")
	public short getLoadMaskFlag() {
		return loadMaskFlag;
	}
	public void setLoadMaskFlag(short loadMaskFlag) {
		this.loadMaskFlag = loadMaskFlag;
	}
	@Column(name="selection_tip")
	public short getSelectionTip() {
		return selectionTip;
	}
	public void setSelectionTip(short selectionTip) {
		this.selectionTip = selectionTip;
	}
	@Transient
	public int get_totalWidth() {
		return _totalWidth;
	}
	public void set_totalWidth(int totalWidth) {
		_totalWidth = totalWidth;
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
