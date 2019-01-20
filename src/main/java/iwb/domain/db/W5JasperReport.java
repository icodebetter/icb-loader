package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="w5_jasper_report",schema="iwb")
public class W5JasperReport  implements java.io.Serializable {

	private int jasperReportId ;
	private int jasperId;
	private int customizationId;
	private String dsc;
	private String reportFileName;
	private int versionNo;
	private short defaultFlag;	
	
	@Id
	@Column(name="jasper_report_id")
	public int getJasperReportId() {
		return jasperReportId;
	}
	public void setJasperReportId(int jasperReportId) {
		this.jasperReportId = jasperReportId;
	}

	@Column(name="jasper_id")
	public int getJasperId() {
		return jasperId;
	}
	public void setJasperId(int jasperId) {
		this.jasperId = jasperId;
	}
	@Id
	@Column(name="customization_id")
	public int getCustomizationId() {
		return customizationId;
	}
	public void setCustomizationId(int customizationId) {
		this.customizationId = customizationId;
	}
	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	@Column(name="report_file_name")
	public String getReportFileName() {
		return reportFileName;
	}
	public void setReportFileName(String reportFileName) {
		this.reportFileName = reportFileName;
	}
	
	@Column(name="version_no")
	public int getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}
	@Column(name="default_flag")
	public short getDefaultFlag() {
		return defaultFlag;
	}
	public void setDefaultFlag(short defaultFlag) {
		this.defaultFlag = defaultFlag;
	}
	
	
}
