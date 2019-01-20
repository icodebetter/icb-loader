package iwb.domain.db;

// Generated Feb 4, 2007 3:49:13 PM by Hibernate Tools 3.2.0.b9

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="log5_approval_record",schema="iwb")
public class Log5WorkflowRecord implements java.io.Serializable, Log5Base {

	private int logId;
	private int userId;
	private int approvalRecordId;
	private int approvalId;
	private int approvalStepId;
	private short approvalActionTip;//--start, approve, return, reject, time_limit_cont

	private String dsc;

	public String toInfluxDB() {
		StringBuilder s=new StringBuilder();
		return s.toString();
	}

	@Column(name="approval_id")
	public int getApprovalId() {
		return approvalId;
	}
	public void setApprovalId(int approvalId) {
		this.approvalId = approvalId;
	}
	
	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	
	public Log5WorkflowRecord() {
	}

    @SequenceGenerator(name="sex_log_approval_record",sequenceName="iwb.seq_log_approval_record",allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sex_log_approval_record")
	@Column(name="log_id")
	public int getLogId() {
		return this.logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	@Column(name="user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name="approval_record_id")
	public int getApprovalRecordId() {
		return approvalRecordId;
	}

	public void setApprovalRecordId(int approvalRecordId) {
		this.approvalRecordId = approvalRecordId;
	}

	@Column(name="approval_step_id")
	public int getApprovalStepId() {
		return approvalStepId;
	}

	public void setApprovalStepId(int approvalStepId) {
		this.approvalStepId = approvalStepId;
	}

	@Column(name="approval_action_tip")
	public short getApprovalActionTip() {
		return approvalActionTip;
	}

	public void setApprovalActionTip(short approvalActionTip) {
		this.approvalActionTip = approvalActionTip;
	}
    
    
}
