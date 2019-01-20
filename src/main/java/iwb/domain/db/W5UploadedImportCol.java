package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

// Generated Jun 17, 2007 5:12:14 PM by Hibernate Tools 3.2.0.b9


@Entity
@Immutable
@Table(name="w5_uploaded_import_col")
public class W5UploadedImportCol implements java.io.Serializable {

	private int uploadedImportColId;
	private int uploadedImportId;
	private String importColumn;
	private int formCellId;
	private String defaultValue;
	private short mappingType;
	private int fileAttachmentId;
	private int customizationId;

	@Id
	@Column(name="uploaded_import_col_id")
	public int getUploadedImportColId() {
		return uploadedImportColId;
	}
	public void setUploadedImportColId(int uploadedImportColId) {
		this.uploadedImportColId = uploadedImportColId;
	}
	@Column(name="uploaded_import_id")
	public int getUploadedImportId() {
		return uploadedImportId;
	}
	public void setUploadedImportId(int uploadedImportId) {
		this.uploadedImportId = uploadedImportId;
	}
	
	
	@Column(name="file_attachment_id")
	public int getFileAttachmentId() {
		return fileAttachmentId;
	}
	public void setFileAttachmentId(int fileAttachmentId) {
		this.fileAttachmentId = fileAttachmentId;
	}
	@Column(name="import_coloumn")
	public String getImportColumn() {
		return importColumn;
	}
	public void setImportColumn(String importColumn) {
		this.importColumn = importColumn;
	}
	@Column(name="form_cell_id")
	public int getFormCellId() {
		return formCellId;
	}
	public void setFormCellId(int formCellId) {
		this.formCellId = formCellId;
	}
	@Column(name="constant_value")
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	@Column(name="mapping_type")
	public short getMappingType() {
		return mappingType;
	}
	public void setMappingType(short mappingType) {
		this.mappingType = mappingType;
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
