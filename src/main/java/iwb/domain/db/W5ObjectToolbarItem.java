package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;


@Entity
@Immutable
@Table(name="w5_object_toolbar_item",schema="iwb")
public class W5ObjectToolbarItem implements java.io.Serializable, W5Base {

	private int toolbarItemId;
	private short objectTip; // hangi tablodan geldigi: 2:table_id, 1:gridId, 3:dbFunc
	private int objectId; //gelen table'in PK'si
	private String dsc;
	private String localeMsgKey;
	private short tabOrder;
	private String imgIcon;
	private short accessViewTip; //0:kisitlama yok, 1:var
	private String accessViewRoles;
	private String accessViewUsers;
	private short itemTip; // duz icon, menu'lu vs.vs.
	private short activeOnSelectionFlag; // duz icon, menu'lu vs.vs.
	private String code; 
	private int lookupQueryId;

	
	@Id
	@Column(name="toolbar_item_id")
	public int getToolbarItemId() {
		return toolbarItemId;
	}
	public void setToolbarItemId(int toolbarItemId) {
		this.toolbarItemId = toolbarItemId;
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
	@Column(name="tab_order")
	public short getTabOrder() {
		return tabOrder;
	}
	public void setTabOrder(short tabOrder) {
		this.tabOrder = tabOrder;
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
	@Column(name="img_icon")
	public String getImgIcon() {
		return imgIcon;
	}
	public void setImgIcon(String imgIcon) {
		this.imgIcon = imgIcon;
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
	@Column(name="item_tip")
	public short getItemTip() {
		return itemTip;
	}
	public void setItemTip(short itemTip) {
		this.itemTip = itemTip;
	}
	@Column(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="active_on_selection_flag")
	public short getActiveOnSelectionFlag() {
		return activeOnSelectionFlag;
	}
	public void setActiveOnSelectionFlag(short activeOnSelectionFlag) {
		this.activeOnSelectionFlag = activeOnSelectionFlag;
	}
	
	@Column(name="lookup_query_id")
	public int getLookupQueryId() {
		return lookupQueryId;
	}
	public void setLookupQueryId(int lookupQueryId) {
		this.lookupQueryId = lookupQueryId;
	}
	@Transient
	public boolean safeEquals(W5Base q){
		if(q==null)return false;
		W5ObjectToolbarItem l = (W5ObjectToolbarItem)q;
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
