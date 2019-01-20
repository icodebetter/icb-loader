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


@Entity
@Immutable
@Table(name="w5_form",schema="iwb")
public class W5Form implements java.io.Serializable, W5Base {

	private int formId;
	
	private short objectTip; // hangi tablodan geldigi: 2:table_id, 1:gridId, 3:dbFunc

	private int objectId; //gelen table'in PK'si

	private String dsc;

	private String localeMsgKey;

	private short defaultWidth;

	private short defaultHeight;

	private short tabOrder;

	private short renderTip; // 0: duz, 1: fieldset, 2: tab 
	
	private int renderTemplateId; // default olarak

	private short labelWidth;

	private short labelAlignTip;
	
	private short contEntryFlag;

	private String jsCode;
	
	private boolean _versioningFlag;
//	private W5Table _sourceTable;
	private W5Query _sourceQuery;
	private List<W5FormCell> _formCells;
	private List<W5FormModule> _moduleList;
	private W5Page _renderTemplate;
	private	List<W5ObjectToolbarItem>	_toolbarItemList;
	private List<W5FormSmsMail> _formSmsMailList;
	private Map<Integer,W5FormSmsMail> _formSmsMailMap;
	private List<W5Conversion> _conversionList;
	private List<W5FormHint> _formHintList;

	
	@Transient
	public List<W5FormCell> get_formCells() {
		return _formCells;
	}
	public void set_formCells(List<W5FormCell> formCells) {
		_formCells = formCells;
	}
	
	@Id
	@Column(name="form_id")
	public int getFormId() {
		return formId;
	}
	public void setFormId(int formId) {
		this.formId = formId;
	}
	@Column(name="object_tip")
	public short getObjectTip() {
		return objectTip;
	}
	public void setObjectTip(short objectTip) {
		this.objectTip = objectTip;
	}
	@Column(name="object_id")
	public int getObjectId() {
		return objectId;
	}
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	@Column(name="locale_msg_key")
	public String getLocaleMsgKey() {
		return localeMsgKey;
	}
	public void setLocaleMsgKey(String localeMsgKey) {
		this.localeMsgKey = localeMsgKey;
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
	@Column(name="tab_order")
	public short getTabOrder() {
		return tabOrder;
	}
	public void setTabOrder(short tabOrder) {
		this.tabOrder = tabOrder;
	}
	@Column(name="render_tip")
	public short getRenderTip() {
		return renderTip;
	}
	public void setRenderTip(short renderTip) {
		this.renderTip = renderTip;
	}
	@Column(name="label_width")
	public short getLabelWidth() {
		return labelWidth;
	}
	public void setLabelWidth(short labelWidth) {
		this.labelWidth = labelWidth;
	}
	@Column(name="label_align_tip")
	public short getLabelAlignTip() {
		return labelAlignTip;
	}
	public void setLabelAlignTip(short labelAlignTip) {
		this.labelAlignTip = labelAlignTip;
	}
	@Column(name="cont_entry_flag")
	public short getContEntryFlag() {
		return contEntryFlag;
	}
	public void setContEntryFlag(short contEntryFlag) {
		this.contEntryFlag = contEntryFlag;
	}
	

	
	@Column(name="code")
	public String getJsCode() {
		return jsCode;
	}
	public void setJsCode(String code) {
		this.jsCode = code;
	}
	@Column(name="render_template_id")
	public int getRenderTemplateId() {
		return renderTemplateId;
	}
	public void setRenderTemplateId(int renderTemplateId) {
		this.renderTemplateId = renderTemplateId;
	}
/*
	@Id
	@Column(name="customization_id")
	public int getCustomizationId() {
		return customizationId;
	}
	public void setCustomizationId(int customizationId) {
		this.customizationId = customizationId;
	}*/
	@Transient
	public W5Query get_sourceQuery() {
		return _sourceQuery;
	}
	public void set_sourceQuery(W5Query sourceQuery) {
		_sourceQuery = sourceQuery;
	}
	@Transient
	public boolean get_versioningFlag() {
		return this._versioningFlag;
	}
	public void set_versioningFlag(boolean versioningFlag) {
		this._versioningFlag = versioningFlag;
	}
	@Transient
	public List<W5FormModule> get_moduleList() {
		return _moduleList;
	}
	public void set_moduleList(List<W5FormModule> moduleList) {
		_moduleList = moduleList;
	}
	@Transient
	public W5Page get_renderTemplate() {
		return _renderTemplate;
	}
	public void set_renderTemplate(W5Page renderTemplate) {
		_renderTemplate = renderTemplate;
	}
	
	@Transient
	public List<W5ObjectToolbarItem> get_toolbarItemList() {
		return _toolbarItemList;
	}
	public void set_toolbarItemList(List<W5ObjectToolbarItem> toolbarItemList) {
		_toolbarItemList = toolbarItemList;
	}
	public W5Form() {
		super();
	}
	@Transient
	public List<W5FormSmsMail> get_formSmsMailList() {
		return _formSmsMailList;
	}
	public void set_formSmsMailList(List<W5FormSmsMail> formSmsMailList) {
		_formSmsMailList = formSmsMailList;
	}
	@Transient
	public Map<Integer, W5FormSmsMail> get_formSmsMailMap() {
		return _formSmsMailMap;
	}
	public void set_formSmsMailMap(Map<Integer, W5FormSmsMail> formSmsMailMap) {
		_formSmsMailMap = formSmsMailMap;
	}
	@Transient
	public List<W5Conversion> get_conversionList() {
		return _conversionList;
	}
	public void set_conversionList(List<W5Conversion> conversionList) {
		_conversionList = conversionList;
	}

	@Transient
	public boolean safeEquals(W5Base q){
		if(q==null)return false;
		W5Form f = (W5Form)q;
		if(this.formId!=f.getFormId() || this.objectTip!=f.getObjectTip() ||
				this.objectId != f.getObjectId() ||
				!GenericUtil.safeEquals(this.dsc,f.getDsc()) ||
				!GenericUtil.safeEquals(this.localeMsgKey,f.getLocaleMsgKey()) ||
				this.defaultWidth !=  f.getDefaultWidth()||
				this.defaultHeight !=  f.getDefaultHeight()||
				this.tabOrder !=  f.getTabOrder() ||
				this.renderTip  !=  f.getRenderTip() ||
				this.renderTemplateId !=  f.getRenderTemplateId() ||
				this.labelWidth !=  f.getLabelWidth() ||
				this.labelAlignTip !=  f.getLabelAlignTip() ||
				this.contEntryFlag !=  f.getContEntryFlag() ||
				!GenericUtil.safeEquals(this.jsCode, f.getJsCode()))return false;
		
		if(!GenericUtil.safeEquals(this._formCells, f._formCells))return false;
/*		if(this._formCells!=null && f.get_formCells()!=null){
			if(this._formCells.size()==f.get_formCells().size())return false;
			for(int i=0;i<this._formCells.size();i++){
				W5FormCell c1 = this._formCells.get(i); 
				W5FormCell c2 = f.get_formCells().get(i);
				if(!c1.equals(c2))return false;
			}			
		} else if(this._formCells!=null ^ f.get_formCells()!=null) return false;*/
		
		if(!GenericUtil.safeEquals(this._toolbarItemList, f._toolbarItemList))return false;
/*		if(this._toolbarItemList!=null && f.get_toolbarItemList()!=null){
			if(this._toolbarItemList.size()==f.get_toolbarItemList().size())return false;
			for(int i=0;i<this._toolbarItemList.size();i++){
				W5ObjectToolbarItem c1 = this._toolbarItemList.get(i); 
				W5ObjectToolbarItem c2 = f.get_toolbarItemList().get(i);
				if(!c1.equals(c2))return false;
			}			
		} else if(this._toolbarItemList!=null ^ f.get_toolbarItemList()!=null) return false;*/
		
		if(!GenericUtil.safeEquals(this._formSmsMailList, f._formSmsMailList))return false;
/*		if(this._formSmsMailList!=null && f.get_formSmsMailList()!=null){
			if(this._formSmsMailList.size()==f.get_formSmsMailList().size())return false;
			for(int i=0;i<this._formSmsMailList.size();i++){
				W5FormSmsMail c1 = this._formSmsMailList.get(i); 
				W5FormSmsMail c2 = f.get_formSmsMailList().get(i);
				if(!c1.equals(c2))return false;
			}			
		} else if(this._formSmsMailList!=null ^ f.get_formSmsMailList()!=null) return false;*/
	
		if(!GenericUtil.safeEquals(this._conversionList, f._conversionList))return false;
/*		if(this._conversionList!=null && f.get_conversionList()!=null){
			if(this._conversionList.size()==f.get_conversionList().size())return false;
			for(int i=0;i<this._conversionList.size();i++){
				W5Conversion c1 = this._conversionList.get(i); 
				W5Conversion c2 = f.get_conversionList().get(i);
				if(!c1.equals(c2))return false;
			}			
		} else if(this._conversionList!=null ^ f.get_conversionList()!=null) return false;*/
		
		return true;
	}
	@Transient
	public List<W5FormHint> get_formHintList() {
		return _formHintList;
	}
	public void set_formHintList(List<W5FormHint> _formHintList) {
		this._formHintList = _formHintList;
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
