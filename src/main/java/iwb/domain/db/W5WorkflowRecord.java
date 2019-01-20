package iwb.domain.db;

import java.sql.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="w5_approval_record",schema="iwb")
public class W5WorkflowRecord implements java.io.Serializable {

	private int approvalRecordId;
	private int approvalStepId;
	private int approvalId;

	private String dsc;
	private String approvalRoles;
	private String approvalUsers;

	private Date validUntilDttm;
	private	int	versionNo;
	private	int	insertUserId;
	private	int	versionUserId;
	private int tableId;
	private int tablePk;
	private short approvalActionTip;
	private short finishedFlag;
	private short returnFlag;

	private short accessViewTip;
	private String accessViewRoles;
	private String accessViewUsers;
	private Integer hierarchicalLevel;
  	
	@SequenceGenerator(name="sex_approval_record",sequenceName="iwb.seq_approval_record",allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sex_approval_record")
	@Column(name="approval_record_id")
	public int getApprovalRecordId() {
		return approvalRecordId;
	}
	public void setApprovalRecordId(int approvalRecordId) {
		this.approvalRecordId = approvalRecordId;
	}
	@Column(name="approval_id")
	public int getApprovalId() {
		return approvalId;
	}
	public void setApprovalId(int approvalId) {
		this.approvalId = approvalId;
	}
	@Column(name="table_id")
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	@Column(name="approval_action_tip")
	public short getApprovalActionTip() {
		return approvalActionTip;
	}
	public void setApprovalActionTip(short approvalActionTip) {
		this.approvalActionTip = approvalActionTip;
	}
	@Column(name="table_pk")
	public int getTablePk() {
		return tablePk;
	}
	public void setTablePk(int tablePk) {
		this.tablePk = tablePk;
	}
	@Column(name="approval_step_id")
	public int getApprovalStepId() {
		return approvalStepId;
	}
	public void setApprovalStepId(int approvalStepId) {
		this.approvalStepId = approvalStepId;
	}

	@Column(name="valid_until_dttm")
	public Date getValidUntilDttm() {
		return validUntilDttm;
	}
	public void setValidUntilDttm(Date validUntilDttm) {
		this.validUntilDttm = validUntilDttm;
	}
	
	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	@Column(name="approval_roles")
	public String getApprovalRoles() {
		return approvalRoles;
	}
	public void setApprovalRoles(String approvalRoles) {
		this.approvalRoles = approvalRoles;
	}
	@Column(name="approval_users")
	public String getApprovalUsers() {
		return approvalUsers;
	}
	public void setApprovalUsers(String approvalUsers) {
		this.approvalUsers = approvalUsers;
	}
	
	@Column(name="insert_user_id")
	public int getInsertUserId() {
		return insertUserId;
	}
	public void setInsertUserId(int insertUserId) {
		this.insertUserId = insertUserId;
	}
	@Column(name="version_user_id")
	public int getVersionUserId() {
		return versionUserId;
	}
	public void setVersionUserId(int versionUserId) {
		this.versionUserId = versionUserId;
	}
	
	@Column(name="finished_flag")
	public short getFinishedFlag() {
		return finishedFlag;
	}
	public void setFinishedFlag(short finishedFlag) {
		this.finishedFlag = finishedFlag;
	}
	
	@Column(name="return_flag")
	public short getReturnFlag() {
		return returnFlag;
	}
	public void setReturnFlag(short returnFlag) {
		this.returnFlag = returnFlag;
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

	@Column(name="version_no")
	public int getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}	
	@Column(name="hierarchical_level")
	public Integer getHierarchicalLevel() {
		return hierarchicalLevel;
	}
	public void setHierarchicalLevel(Integer hierarchicalLevel) {
		this.hierarchicalLevel = hierarchicalLevel;
	}
	
	public W5WorkflowRecord() {
		super();
		versionNo=1;
	}
	public W5WorkflowRecord(Map<String, Object> scd,int approvalStepId, int approvalId,
			int tableId, short approvalActionTip,
			short returnFlag) {
		super();
		this.approvalStepId = approvalStepId;
		this.approvalId = approvalId;
		this.projectUuid = (String)scd.get("projectId");
		this.insertUserId = (Integer)scd.get("userId");
		this.versionUserId = (Integer)scd.get("userId");
		this.tableId = tableId;
		this.approvalActionTip = approvalActionTip;
		this.returnFlag = returnFlag;
		this.versionNo=1;
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
	  public W5WorkflowRecord(String projectUuid) {
	    super();
	    this.projectUuid = projectUuid;
	    versionNo=1;
	  }

	
}
