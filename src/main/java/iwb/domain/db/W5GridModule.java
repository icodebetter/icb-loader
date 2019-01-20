package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

import iwb.util.GenericUtil;


@Entity
@Immutable
@Table(name="w5_grid_module",schema="iwb")
public class W5GridModule implements java.io.Serializable, W5Base {

	private int gridModuleId;
	private int gridId;
	private String localeMsgKey;
	private short tabOrder;
	private short accessViewTip;
	private String accessViewRoles;
	private String accessViewUsers;

	
	@Id
	@Column(name="grid_module_id")
	public int getGridModuleId() {
		return gridModuleId;
	}
	public void setGridModuleId(int gridModuleId) {
		this.gridModuleId = gridModuleId;
	}


	@Column(name="grid_id")
	public int getGridId() {
		return gridId;
	}
	public void setGridId(int gridId) {
		this.gridId = gridId;
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
	
	
	@Transient
	public boolean safeEquals(W5Base q){
		if(q==null)return false;
		W5GridModule g = (W5GridModule)q;
		return 
			this.gridModuleId == g.getGridModuleId() &&
			this.gridId == g.getGridId() &&
			GenericUtil.safeEquals(this.localeMsgKey, g.getLocaleMsgKey()) &&
			this.tabOrder == g.getTabOrder() &&
			this.accessViewTip == g.getAccessViewTip() &&
			GenericUtil.safeEquals(this.accessViewRoles, g.getAccessViewRoles()) &&
			GenericUtil.safeEquals(this.accessViewUsers, g.getAccessViewUsers());
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
