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
@Table(name="w5_data_view",schema="iwb")
public class W5Card implements java.io.Serializable, W5Base, W5ListBase {

	private int dataViewId;

	private String dsc;

	private int queryId;

	private String localeMsgKey;

	private short defaultPageRecordNumber;

	private short defaultWidth;

	private short defaultHeight;

	private int pkQueryFieldId;

	private String defaultSqlOrderby;

	private int defaultCrudFormId;// burdan edit, insert vs olaylari incelenecek
	 
	private String orderQueryFieldIds;
	private List<String> _orderQueryFieldNames;

	
	private int _searchFormId;
	private	String templateCode;	
	private	String jsCode;	

	private Map<String, W5QueryField> _queryFieldMapDsc;
	private W5QueryField	_pkQueryField;
	private	List<W5ObjectToolbarItem>	_toolbarItemList;
	private	List<W5ObjectMenuItem>	_menuItemList;
	private	W5Form _defaultCrudForm;
	private	W5Table _crudTable;
	private W5Query	_query;	
	private Map<Integer, W5QueryField> _queryFieldMap;
	private	List<W5FormSmsMail>	_crudFormSmsMailList;
	private	List<W5Conversion>	_crudFormConversionList;
	private List<W5QueryField> _postProcessQueryFields;
	private W5Workflow _approval;

	
	@Id
	@Column(name="data_view_id")
	public int getDataViewId() {
		return dataViewId;
	}
	public void setDataViewId(int gridId) {
		this.dataViewId = gridId;
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
	public W5Query get_query() {
		return _query;
	}
	public void set_query(W5Query query) {
		_query = query;
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
	@Transient	
	public W5Table get_crudTable() {
		return _crudTable;
	}
	public void set_crudTable(W5Table mainTable) {
		_crudTable = mainTable;
	}
	
	@Transient
	public List<W5ObjectMenuItem> get_menuItemList() {
		return _menuItemList;
	}
	public void set_menuItemList(List<W5ObjectMenuItem> menuItemList) {
		_menuItemList = menuItemList;
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

	@Column(name="template_code")
	public String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	@Column(name="js_code")
	public String getJsCode() {
		return jsCode;
	}
	public void setJsCode(String jsCode) {
		this.jsCode = jsCode;
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

	@Column(name="order_query_field_ids")
	public String getOrderQueryFieldIds() {
		return orderQueryFieldIds;
	}
	public void setOrderQueryFieldIds(String orderQueryFieldIds) {
		this.orderQueryFieldIds = orderQueryFieldIds;
	}
	
	@Transient
	public List<String> get_orderQueryFieldNames() {
		return _orderQueryFieldNames;
	}
	public void set_orderQueryFieldNames(List<String> _orderQueryFieldNames) {
		this._orderQueryFieldNames = _orderQueryFieldNames;
	}
	
	@Transient
	public W5Workflow get_workflow() {
		return _approval;
	}
	public void set_workflow(W5Workflow approval) {
		_approval = approval;
	}
	
	@Transient
	public boolean safeEquals(W5Base q){
		return false;
	}
}
