package iwb.domain.db;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="w5_ws_server_method",schema="iwb")
public class W5WsServerMethod  implements java.io.Serializable {

	private int wsServerMethodId;
	private int wsServerId;
	private String dsc;
	private short objectTip;
	private int objectId;
	private W5WsServer _ws;
	private short tabOrder;
	private short dataAcceptTip;
	private short accessExecuteTip;
	private String accessExecuteRoles;
	private String accessExecuteUsers;
	private String accessSourceTypes;

	private List<W5WsServerMethodParam> _params;
	private Object _sourceObject;
	
	public W5WsServerMethod(String dsc, short objectTip, int objectId) {
		super();
		this.dsc = dsc;
		this.objectTip = objectTip;
		this.objectId = objectId;
	}
	public W5WsServerMethod() {
		super();
	}
	@Id
	@Column(name="ws_server_method_id")
	public int getWsServerMethodId() {
		return wsServerMethodId;
	}
	public void setWsServerMethodId(int wsServerMethodId) {
		this.wsServerMethodId = wsServerMethodId;
	}
	
	@Column(name="object_tip")
	public short getObjectTip() {
		return objectTip;
	}
	public void setObjectTip(short objectTip) {
		this.objectTip = objectTip;
	}
	
	@Column(name="ws_server_id")
	public int getWsServerId() {
		return wsServerId;
	}
	public void setWsServerId(int wsServerId) {
		this.wsServerId = wsServerId;
	}
	
	
	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	

	
	@Transient
	public W5WsServer get_ws() {
		return _ws;
	}
	public void set_ws(W5WsServer _ws) {
		this._ws = _ws;
	}
	
	@Column(name="access_execute_tip")
	public short getAccessExecuteTip() {
		return accessExecuteTip;
	}
	public void setAccessExecuteTip(short accessExecuteTip) {
		this.accessExecuteTip = accessExecuteTip;
	}
	
	@Column(name="access_execute_roles")
	public String getAccessExecuteRoles() {
		return accessExecuteRoles;
	}
	public void setAccessExecuteRoles(String accessExecuteRoles) {
		this.accessExecuteRoles = accessExecuteRoles;
	}
	
	@Column(name="access_execute_users")
	public String getAccessExecuteUsers() {
		return accessExecuteUsers;
	}
	public void setAccessExecuteUsers(String accessExecuteUsers) {
		this.accessExecuteUsers = accessExecuteUsers;
	}
	
	@Transient
	public List<W5WsServerMethodParam> get_params() {
		return _params;
	}
	public void set_params(List<W5WsServerMethodParam> _params) {
		this._params = _params;
	}
	
	@Column(name="object_id")
	public int getObjectId() {
		return objectId;
	}
	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}
	
	@Column(name="tab_order")
	public short getTabOrder() {
		return tabOrder;
	}
	public void setTabOrder(short tabOrder) {
		this.tabOrder = tabOrder;
	}
	
	@Transient
	public Object get_sourceObject() {
		return _sourceObject;
	}
	public void set_sourceObject(Object _sourceObject) {
		this._sourceObject = _sourceObject;
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

	@Column(name="data_accept_tip")
	public short getDataAcceptTip() {
		return dataAcceptTip;
	}
	public void setDataAcceptTip(short dataAcceptTip) {
		this.dataAcceptTip = dataAcceptTip;
	}
	@Column(name="access_source_types")
	public String getAccessSourceTypes() {
		return accessSourceTypes;
	}

	public void setAccessSourceTypes(String accessSourceTypes) {
		this.accessSourceTypes = accessSourceTypes;
	}
	
}
