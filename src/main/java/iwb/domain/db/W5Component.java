package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

// Generated Feb 5, 2007 3:58:07 PM by Hibernate Tools 3.2.0.b9

@Entity
@Immutable
@Table(name="w5_component",schema="iwb")
public class W5Component implements java.io.Serializable, W5Base{

	private int componentId;
	private int parentComponentId;

	private String dsc;

	private short status;
	private short frontendTip;
	private short frontendLang;
	private	String componentVersion;	

	private	String code;	
	private	String cssCode;	
	private	String jsCode;	

	
	@Id
	@Column(name="component_id")
	public int getComponentId() {
		return componentId;
	}

	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}

	@Column(name="parent_component_id")
	public int getParentComponentId() {
		return parentComponentId;
	}

	public void setParentComponentId(int parentComponentId) {
		this.parentComponentId = parentComponentId;
	}

	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	@Column(name="status")
	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	@Column(name="frontend_tip")
	public short getFrontendTip() {
		return frontendTip;
	}

	public void setFrontendTip(short frontendTip) {
		this.frontendTip = frontendTip;
	}



	@Column(name="frontend_lang")
	public short getFrontendLang() {
		return frontendLang;
	}




	public void setFrontendLang(short frontendLang) {
		this.frontendLang = frontendLang;
	}



	@Column(name="component_version")
	public String getComponentVersion() {
		return componentVersion;
	}




	public void setComponentVersion(String componentVersion) {
		this.componentVersion = componentVersion;
	}




	@Column(name="code")
	public String getCode() {
		return code;
	}




	public void setCode(String code) {
		this.code = code;
	}



	@Column(name="css_code")
	public String getCssCode() {
		return cssCode;
	}




	public void setCssCode(String cssCode) {
		this.cssCode = cssCode;
	}




	@Column(name="js_code")
	public String getJsCode() {
		return jsCode;
	}

	public void setJsCode(String jsCode) {
		this.jsCode = jsCode;
	}




	@Transient
	public boolean safeEquals(W5Base q){
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
