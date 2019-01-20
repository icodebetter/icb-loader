package iwb.domain.db;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

// Generated Feb 5, 2007 3:58:07 PM by Hibernate Tools 3.2.0.b9

@Entity
@Immutable
@Table(name="m5_list",schema="iwb")
public class M5List implements java.io.Serializable, W5Base, W5ListBase {

	private int listId;
	private int parentListId;

	private String dsc;

	private int queryId;

	private String localeMsgKey;

	private short listTip;
	private short defaultPageRecordNumber;
	private short hideBarsOnScrollFlag;
	private short searchPanelOpenFlag;
	
	private int defaultCrudFormId;// burdan edit, insert vs olaylari incelenecek

	private String defaultSqlOrderby;

	private int _searchFormId;
	private	String htmlPageCode;	
	private	String htmlDataCode;	
	private	String jsCode;	

	private W5QueryField	_pkQueryField;
	private	W5Table _mainTable;
	private W5Query	_query;	
	private List<M5List> _detailMLists;
	private List<String> _orderQueryFieldNames;
	private	List<W5ObjectToolbarItem>	_toolbarItemList;
	private	List<W5ObjectMenuItem>	_menuItemList;
	private	List<W5FormSmsMail>	_crudFormSmsMailList;
	private	List<W5Conversion>	_crudFormConversionList;
	private List<W5QueryField> _postProcessQueryFields;
	private W5Workflow _approval;

	private String orderQueryFieldIds;
	
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
	public W5Table get_mainTable() {
		return _mainTable;
	}
	public void set_mainTable(W5Table mainTable) {
		_mainTable = mainTable;
	}
	
	@Transient
	public int get_searchFormId() {
		return _searchFormId;
	}
	public void set_searchFormId(int searchFormId) {
		_searchFormId = searchFormId;
	}
	
	@Column(name="html_page_code")
	public String getHtmlPageCode() {
		return htmlPageCode;
	}
	public void setHtmlPageCode(String htmlPageCode) {
		this.htmlPageCode = htmlPageCode;
	}
	
	@Column(name="html_data_code")
	public String getHtmlDataCode() {
		return htmlDataCode;
	}
	public void setHtmlDataCode(String htmlDataCode) {
		this.htmlDataCode = htmlDataCode;
	}
	
	@Column(name="default_crud_form_id")
	public int getDefaultCrudFormId() {
		return defaultCrudFormId;
	}
	public void setDefaultCrudFormId(int defaultCrudFormId) {
		this.defaultCrudFormId = defaultCrudFormId;
	}
	
	@Column(name="order_query_field_ids")
	public String getOrderQueryFieldIds() {
		return orderQueryFieldIds;
	}
	public void setOrderQueryFieldIds(String orderQueryFieldIds) {
		this.orderQueryFieldIds = orderQueryFieldIds;
	}
	
	@Column(name="hide_bars_on_scroll_flag")
	public short getHideBarsOnScrollFlag() {
		return hideBarsOnScrollFlag;
	}
	public void setHideBarsOnScrollFlag(short hideBarsOnScrollFlag) {
		this.hideBarsOnScrollFlag = hideBarsOnScrollFlag;
	}
	@Column(name="search_panel_open_flag")
	public short getSearchPanelOpenFlag() {
		return searchPanelOpenFlag;
	}
	public void setSearchPanelOpenFlag(short searchPanelOpenFlag) {
		this.searchPanelOpenFlag = searchPanelOpenFlag;
	}
	
	@Column(name="list_tip")
	public short getListTip() {
		return listTip;
	}
	public void setListTip(short listTip) {
		this.listTip = listTip;
	}
	@Column(name="parent_list_id")
	public int getParentListId() {
		return parentListId;
	}
	public void setParentListId(int parentListId) {
		this.parentListId = parentListId;
	}
	
	@Transient
	public List<M5List> get_detailMLists() {
		return _detailMLists;
	}
	public void set_detailMLists(List<M5List> _detailMLists) {
		this._detailMLists = _detailMLists;
	}
	
	@Transient
	public List<String> get_orderQueryFieldNames() {
		return _orderQueryFieldNames;
	}
	public void set_orderQueryFieldNames(List<String> _orderQueryFieldNames) {
		this._orderQueryFieldNames = _orderQueryFieldNames;
	}
	
	@Transient
	public List<W5ObjectToolbarItem> get_toolbarItemList() {
		return _toolbarItemList;
	}
	public void set_toolbarItemList(List<W5ObjectToolbarItem> _toolbarItemList) {
		this._toolbarItemList = _toolbarItemList;
	}
	@Transient
	public List<W5ObjectMenuItem> get_menuItemList() {
		return _menuItemList;
	}
	public void set_menuItemList(List<W5ObjectMenuItem> menuItemList) {
		_menuItemList = menuItemList;
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
	public W5Workflow get_workflow() {
		return _approval;
	}
	public void set_workflow(W5Workflow approval) {
		_approval = approval;
	}
	

	@Transient
	public List<W5QueryField> get_postProcessQueryFields() {
		return _postProcessQueryFields;
	}
	public void set_postProcessQueryFields(List<W5QueryField> postProcessQueryFields) {
		_postProcessQueryFields = postProcessQueryFields;
	}

	@Transient
	public List<W5FormSmsMail> get_crudFormSmsMailList() {
		return _crudFormSmsMailList;
	}
	public void set_crudFormSmsMailList(List<W5FormSmsMail> _crudFormSmsMailList) {
		this._crudFormSmsMailList = _crudFormSmsMailList;
	}
	@Transient
	public List<W5Conversion> get_crudFormConversionList() {
		return _crudFormConversionList;
	}
	public void set_crudFormConversionList(List<W5Conversion> _crudFormConversionList) {
		this._crudFormConversionList = _crudFormConversionList;
	}
	
	@Transient
	public boolean safeEquals(W5Base q){
		return false;
	}
}
