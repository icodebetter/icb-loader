package iwb.domain.db;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="w5_ws_method",schema="iwb")
public class W5WsMethod  implements java.io.Serializable {

	private int wsMethodId;
	private int wsId;
	private String dsc;
	private String realDsc;
	private short callMethodTip;
	private short postUrlFlag;
	private W5Ws _ws;
	private short accessExecuteTip;
	private	short paramSendTip;
	private	Short headerAcceptTip;
	private String accessExecuteRoles;
	private String accessExecuteUsers;
	private List<W5WsMethodParam> _params;
	private Map<Integer, W5WsMethodParam> _paramMap;
	
	
	@Id
	@Column(name="ws_method_id")
	public int getWsMethodId() {
		return wsMethodId;
	}
	public void setWsMethodId(int wsMethodId) {
		this.wsMethodId = wsMethodId;
	}
	
	@Column(name="call_method_tip")
	public short getCallMethodTip() {
		return callMethodTip;
	}
	public void setCallMethodTip(short callMethodTip) {
		this.callMethodTip = callMethodTip;
	}
	
	@Column(name="ws_id")
	public int getWsId() {
		return wsId;
	}
	public void setWsId(int wsId) {
		this.wsId = wsId;
	}
	
	
	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	
	@Transient
	public W5Ws get_ws() {
		return _ws;
	}
	public void set_ws(W5Ws _ws) {
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
	public List<W5WsMethodParam> get_params() {
		return _params;
	}
	public void set_params(List<W5WsMethodParam> _params) {
		this._params = _params;
	}
	@Transient
	public Map<Integer, W5WsMethodParam> get_paramMap() {
		return _paramMap;
	}
	public void set_paramMap(Map<Integer, W5WsMethodParam> _paramMap) {
		this._paramMap = _paramMap;
	}
	
	@Column(name="param_send_tip")
	public short getParamSendTip() {
		return paramSendTip;
	}
	public void setParamSendTip(short paramSendTip) {
		this.paramSendTip = paramSendTip;
	}
	
	@Column(name="real_dsc")
	public String getRealDsc() {
		return realDsc;
	}
	public void setRealDsc(String realDsc) {
		this.realDsc = realDsc;
	}
	
	@Column(name="header_accept_tip")
	public Short getHeaderAcceptTip() {
		return headerAcceptTip;
	}
	public void setHeaderAcceptTip(Short headerAcceptTip) {
		this.headerAcceptTip = headerAcceptTip;
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

	@Column(name="post_url_flag")
	public short getPostUrlFlag() {
		return postUrlFlag;
	}
	public void setPostUrlFlag(short postUrlFlag) {
		this.postUrlFlag = postUrlFlag;
	}
	
}
