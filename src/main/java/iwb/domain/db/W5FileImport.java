package iwb.domain.db;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="w5_file_import")
public class W5FileImport implements java.io.Serializable {

	private int fileImportId;	
	private int customizationId;
	private int tableId;
	private String dsc;
	private int row_error_strategy_tip;
	private int file_type_id;
	private int version_no;
	private int insert_user_id;
	private int version_user_id;
	private Timestamp insert_dttm;
	private Timestamp version_dttm;
	
	
	@SequenceGenerator(name="sex_w5_file_import",sequenceName="iwb.seq_w5_file_import",allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sex_w5_file_import")
	@Column(name="file_import_id")
	public int getFileImportId() {
		return fileImportId;
	}
	public void setFileImportId(int fileImportId) {
		this.fileImportId = fileImportId;
	}
	@Id
	@Column(name="customization_id")
	public int getCustomizationId() {
		return customizationId;
	}
	public void setCustomizationId(int customizationId) {
		this.customizationId = customizationId;
	}

	@Column(name="table_id")
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}	

	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}	
	
	@Column(name="row_error_strategy_tip")
	public int getRowErrorStrategyTip() {
		return row_error_strategy_tip;
	}
	public void setRowErrorStrategyTip(int row_error_strategy_tip) {
		this.row_error_strategy_tip = row_error_strategy_tip;
	}
	
	@Column(name="file_type_id")
	public int getFileTypeId() {
		return file_type_id;
	}
	public void setFileTypeId(int file_type_id) {
		this.file_type_id = file_type_id;
	}
	
	@Column(name="version_no")
	public int getVersionNo() {
		return version_no;
	}
	public void setVersionNo(int version_no) {
		this.version_no = version_no;
	}
	
	@Column(name="insert_user_id")
	public int getInsertUserId() {
		return insert_user_id;
	}
	public void setInsertUserId(int insert_user_id) {
		this.insert_user_id = insert_user_id;
	}
	
	@Column(name="version_user_id")
	public int getVerisonUserId() {
		return version_user_id;
	}
	public void setVerisonUserId(int version_user_id) {
		this.version_user_id = version_user_id;
	}
	
	@Column(name="insert_dttm")
	public Timestamp getInsertDttm() {
		return insert_dttm;
	}
	public void setInsertDttm(Timestamp insert_dttm) {
		this.insert_dttm = insert_dttm;
	}
	
	@Column(name="version_dttm")
	public Timestamp getVerisonDttm() {
		return version_dttm;
	}
	public void setVerisonDttm(Timestamp version_dttm) {
		this.version_dttm = version_dttm;
	}
}
