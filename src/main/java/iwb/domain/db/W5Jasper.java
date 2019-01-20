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
@Table(name="w5_jasper",schema="iwb")
public class W5Jasper implements java.io.Serializable{

	private int jasperId;
	private String localeMsgKey;
	private String code;
	private int accessViewTip;
	private String accessViewRoles;
	private String accessViewUsers;
	private short localeKeyFlag;

	private List<W5JasperObject> _jasperObjects;
	private W5JasperReport _jasperReport;
	private short multiJasperFlag;
	private Integer multiJasperQueryId;
	
	@Id
	@Column(name="jasper_id")	
	public int getJasperId() {
		return jasperId;
	}
	public void setJasperId(int jasperId) {
		this.jasperId = jasperId;
	}
	
	@Column(name="locale_msg_key")	
	public String getLocaleMsgKey() {
		return localeMsgKey;
	}
	public void setLocaleMsgKey(String localeMsgKey) {
		this.localeMsgKey = localeMsgKey;
	}
	
	@Column(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="access_view_tip")
	public int getAccessViewTip() {
		return accessViewTip;
	}
	public void setAccessViewTip(int accessViewTip) {
		this.accessViewTip = accessViewTip;
	}
	
	@Column(name="access_view_roles")
	public String getAccessViewRoles() {
		return accessViewRoles;
	}
	public void setAccessViewRoles(String accessViewRoles) {
		this.accessViewRoles = accessViewRoles;
	}
	
	@Column(name="access_view_users")
	public String getAccessViewUsers() {
		return accessViewUsers;
	}
	public void setAccessViewUsers(String accessViewUsers) {
		this.accessViewUsers = accessViewUsers;
	}
	@Column(name="locale_key_flag")
	public short getLocaleKeyFlag() {
		return localeKeyFlag;
	}
	public void setLocaleKeyFlag(short localeKeyFlag) {
		this.localeKeyFlag = localeKeyFlag;
	}	
	@Column(name="multi_jasper_flag")
	public short getMultiJasperFlag() {
		return multiJasperFlag;
	}
	
	public void setMultiJasperFlag(short multiJasperFlag) {
		this.multiJasperFlag = multiJasperFlag;
	}
	
	@Column(name="multi_jasper_query_id")
	public Integer getMultiJasperQueryId() {
		return multiJasperQueryId;
	}
	public void setMultiJasperQueryId(Integer multiJasperQueryId) {
		this.multiJasperQueryId = multiJasperQueryId;
	}
	
	@Transient
	public List<W5JasperObject> get_jasperObjects() {
		return _jasperObjects;
	}
	public void set_jasperObjects(List<W5JasperObject> jasperObjects) {
		_jasperObjects = jasperObjects;
	}
	
	@Transient
	public W5JasperReport get_jasperReport() {
		return _jasperReport;
	}
	public void set_jasperReport(W5JasperReport jasperReport) {
		_jasperReport = jasperReport;
	}
		
}
