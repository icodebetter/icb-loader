package iwb.domain.db;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

import iwb.util.GenericUtil;


@Entity
@Immutable
@Table(name="w5_approval", schema="iwb")
public class W5Workflow implements java.io.Serializable {

	private int approvalId;
	
	private String dsc;

	private short activeFlag;
	private int tableId;
	private short actionTip;
	private short approvalFlowTip;
	private short onRejectTip;
	private String advancedBeginSql;
	private short approvalRequestTip;
	private String manualAppRoleIds; 
	private String manualAppUserIds; 
	private String manualAppTableFieldIds;
	private String afterFinUpdateUserIds;	
	private short manualDemandStartAppFlag;
	private short sendMailOnManualStepFlag;
	private short sendSmsOnManualStepFlag;
	private String approvalRequestMsg;		
	private String approvedMsg;		
	private String rejectedMsg;	
	private short sendMailFlag;
	private short sendSmsFlag;
			

	private List<W5WorkflowStep> _approvalStepList;
	private Map<Integer, W5WorkflowStep> _approvalStepMap;
	
	@Id
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
	@Column(name="active_flag")
	public short getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(short activeFlag) {
		this.activeFlag = activeFlag;
	}
	@Column(name="table_id")
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	@Column(name="action_tip")
	public short getActionTip() {
		return actionTip;
	}
	public void setActionTip(short actionTip) {
		this.actionTip = actionTip;
	}
	@Transient
	public List<W5WorkflowStep> get_approvalStepList() {
		return _approvalStepList;
	}
	public void set_approvalStepList(List<W5WorkflowStep> approvalStepList) {
		_approvalStepList = approvalStepList;
	}
	
	@Column(name="approval_flow_tip")
	public short getApprovalFlowTip() {
		return approvalFlowTip;
	}
	public void setApprovalFlowTip(short approvalFlowTip) {
		this.approvalFlowTip = approvalFlowTip;
	}
	@Column(name="on_reject_action_tip")
	public short getOnRejectTip() {
		return onRejectTip;
	}
	public void setOnRejectTip(short onRejectTip) {
		this.onRejectTip = onRejectTip;
	}
	@Column(name="advanced_begin_sql")
	public String getAdvancedBeginSql() {
		return advancedBeginSql;
	}
	public void setAdvancedBeginSql(String advancedBeginSql) {
		this.advancedBeginSql = advancedBeginSql;
	}
	@Transient
	public Map<Integer, W5WorkflowStep> get_approvalStepMap() {
		return _approvalStepMap;
	}
	public void set_approvalStepMap(Map<Integer, W5WorkflowStep> approvalStepMap) {
		_approvalStepMap = approvalStepMap;
	}
	
	@Column(name="approval_request_tip")
	public short getApprovalRequestTip() {
		return approvalRequestTip;
	}
	public void setApprovalRequestTip(short approvalRequestTip) {
		this.approvalRequestTip = approvalRequestTip;
	}


	/*private String ; 
	private String manual_app_user_ids; 
	private String manual_app_table_field_ids;
	private short dynamic_step_flag;
	private String dynamic_step_user_ids;
	private int dynamic_step_min_user_count;
	private int dynamic_step_max_user_count;*/

	@Column(name="manual_app_role_ids")
	public String getManualAppRoleIds() {
		return manualAppRoleIds;
	}
	public void setManualAppRoleIds(String manualAppRoleIds) {
		this.manualAppRoleIds = manualAppRoleIds;
	}
	
	@Column(name="manual_app_user_ids")
	public String getManualAppUserIds() {
		return manualAppUserIds;
	}
	public void setManualAppUserIds(String manualAppUserIds) {
		this.manualAppUserIds = manualAppUserIds;
	}
	
	@Column(name="manual_app_table_field_ids")
	public String getManualAppTableFieldIds() {
		return manualAppTableFieldIds;
	}
	public void setManualAppTableFieldIds(String manualAppTableFieldIds) {
		this.manualAppTableFieldIds = manualAppTableFieldIds;
	}
	
	
	@Column(name="after_fin_update_user_ids")
	public String getAfterFinUpdateUserIds() {
		return afterFinUpdateUserIds;
	}
	public void setAfterFinUpdateUserIds(String afterFinUpdateUserIds) {
		this.afterFinUpdateUserIds = afterFinUpdateUserIds;
	}
	
	@Column(name="manual_demand_start_app_flag")
	public short getManualDemandStartAppFlag() {
		return manualDemandStartAppFlag;
	}
	public void setManualDemandStartAppFlag(short manualDemandStartAppFlag) {
		this.manualDemandStartAppFlag = manualDemandStartAppFlag;
	}
	
	@Column(name="send_mail_on_manual_step_flag")
	public short getSendMailOnManualStepFlag() {
		return sendMailOnManualStepFlag;
	}
	public void setSendMailOnManualStepFlag(short sendMailOnManualStepFlag) {
		this.sendMailOnManualStepFlag = sendMailOnManualStepFlag;
	}
	
	@Column(name="send_sms_on_manual_step_flag")
	public short getSendSmsOnManualStepFlag() {
		return sendSmsOnManualStepFlag;
	}
	public void setSendSmsOnManualStepFlag(short sendSmsOnManualStepFlag) {
		this.sendSmsOnManualStepFlag = sendSmsOnManualStepFlag;
	}
	

	
	
	@Column(name="approval_request_msg")
	public String getApprovalRequestMsg() {
		return approvalRequestMsg;
	}
	public void setApprovalRequestMsg(String approvalRequestMsg) {
		this.approvalRequestMsg = approvalRequestMsg;
	}
	
	
	
	@Column(name="approved_msg")
	public String getApprovedMsg() {
		return approvedMsg;
	}
	public void setApprovedMsg(String approvedMsg) {
		this.approvedMsg = approvedMsg;
	}
	
	@Column(name="rejected_msg")
	public String getRejectedMsg() {
		return rejectedMsg;
	}
	public void setRejectedMsg(String rejectedMsg) {
		this.rejectedMsg = rejectedMsg;
	}

	
	@Column(name="send_mail_flag")
	public short getSendMailFlag() {
		return sendMailFlag;
	}
	public void setSendMailFlag(short sendMailFlag) {
		this.sendMailFlag = sendMailFlag;
	}
	
	@Column(name="send_sms_flag")
	public short getSendSmsFlag() {
		return sendSmsFlag;
	}
	public void setSendSmsFlag(short sendSmsFlag) {
		this.sendSmsFlag = sendSmsFlag;
	}

	@Transient
	public boolean safeEquals(W5Base q){
		if(q==null)return false;
		W5Workflow a = (W5Workflow)q;
		boolean b =
			this.approvalId==a.approvalId &&
			GenericUtil.safeEquals(this.dsc,a.dsc) &&
			this.activeFlag==a.approvalId &&
			this.tableId==a.tableId &&
			this.actionTip==a.actionTip &&
			this.approvalFlowTip==a.approvalFlowTip &&
			this.onRejectTip==a.onRejectTip &&
			GenericUtil.safeEquals(this.advancedBeginSql,a.advancedBeginSql) &&
			this.approvalRequestTip==a.approvalRequestTip &&
			GenericUtil.safeEquals(this.manualAppRoleIds,a.manualAppRoleIds) && 
			GenericUtil.safeEquals(this.manualAppUserIds,a.manualAppUserIds) && 
			GenericUtil.safeEquals(this.manualAppTableFieldIds,a.manualAppTableFieldIds) &&
			GenericUtil.safeEquals(this.afterFinUpdateUserIds,a.afterFinUpdateUserIds) &&	
			this.manualDemandStartAppFlag==a.manualDemandStartAppFlag &&
			this.sendMailOnManualStepFlag==a.sendMailOnManualStepFlag &&
			this.sendSmsOnManualStepFlag==a.sendSmsOnManualStepFlag &&
			GenericUtil.safeEquals(this.approvalRequestMsg,a.approvalRequestMsg) &&		
			GenericUtil.safeEquals(this.approvedMsg,a.approvedMsg) &&		
			GenericUtil.safeEquals(this.rejectedMsg,a.rejectedMsg) &&	
			this.sendMailFlag==a.sendMailFlag &&
			this.sendSmsFlag==a.sendSmsFlag;
		if(!b)return false;

		if(!GenericUtil.safeEquals(this._approvalStepList, a._approvalStepList))return false;
		
		return true;
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
