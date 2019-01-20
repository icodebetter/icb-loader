package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

// Generated Jun 17, 2007 5:12:14 PM by Hibernate Tools 3.2.0.b9


@Entity
@Immutable
@Table(name="w5_uploaded_import")
public class W5UploadedImport implements java.io.Serializable {

	private int uploadedImportId;
	private int formId;
	private int startRowNo;
	private Integer endRowNo;
	private short rowErrorStrategyTip;
	private short importStatus;
	private int fileAttachmentId;
	private int customizationId;
	
	@Id
	@Column(name="uploaded_import_id")
	public int getUploadedImportId() {
		return uploadedImportId;
	}
	public void setUploadedImportId(int uploadedImportId) {
		this.uploadedImportId = uploadedImportId;
	}
	@Column(name="form_id")
	public int getFormId() {
		return formId;
	}
	public void setFormId(int formId) {
		this.formId = formId;
	}
	@Column(name="start_row_no")
	public int getStartRowNo() {
		return startRowNo;
	}
	public void setStartRowNo(int startRowNo) {
		this.startRowNo = startRowNo;
	}
	@Column(name="end_row_no")
	public Integer getEndRowNo() {
		return endRowNo;
	}
	public void setEndRowNo(Integer endRowNo) {
		this.endRowNo = endRowNo;
	}
	@Column(name="row_error_strategy_tip")
	public short getRowErrorStrategyTip() {
		return rowErrorStrategyTip;
	}
	public void setRowErrorStrategyTip(short rowErrorStrategyTip) {
		this.rowErrorStrategyTip = rowErrorStrategyTip;
	}
	@Column(name="import_status")
	public short getImportStatus() {
		return importStatus;
	}
	public void setImportStatus(short importStatus) {
		this.importStatus = importStatus;
	}
	
	@Column(name="file_attachment_id")
	public int getFileAttachmentId() {
		return fileAttachmentId;
	}
	public void setFileAttachmentId(int fileAttachmentId) {
		this.fileAttachmentId = fileAttachmentId;
	}
	@Id
	@Column(name="customization_id")
	public int getCustomizationId() {
		return customizationId;
	}
	public void setCustomizationId(int customizationId) {
		this.customizationId = customizationId;
	}
}
