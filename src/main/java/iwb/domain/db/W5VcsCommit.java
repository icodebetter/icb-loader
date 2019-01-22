package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;


import iwb.util.GenericUtil;

@Entity
@Immutable
@Table(name="w5_vcs_commit", schema="iwb")
public class W5VcsCommit  implements java.io.Serializable {

	private int vcsCommitId;
	private String projectUuid;
	private String oprojectUuid;
	private String extraSql;
	private String comment;
	private short commitTip;
	private short runLocalFlag;
	private int commitUserId;
	

	

	public W5VcsCommit() {
	}

	@Id
	@Column(name="project_uuid")
	public String getProjectUuid() {
		return projectUuid;
	}
	public void setProjectUuid(String projectUuid) {
		this.projectUuid = projectUuid;
	}
	
	@Id
	@Column(name="vcs_commit_id")
	public int getVcsCommitId() {
		return vcsCommitId;
	}
	public void setVcsCommitId(int vcsCommitId) {
		this.vcsCommitId = vcsCommitId;
	}
	
	@Column(name="extra_sql")
	public String getExtraSql() {
		return extraSql;
	}
	public void setExtraSql(String extraSql) {
		this.extraSql = extraSql;
	}
	
	@Column(name="comment")
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Column(name="commit_tip")
	public short getCommitTip() {
		return commitTip;
	}
	public void setCommitTip(short commitTip) {
		this.commitTip = commitTip;
	}

	@Column(name="commit_user_id")
	public int getCommitUserId() {
		return commitUserId;
	}

	public void setCommitUserId(int commitUserId) {
		this.commitUserId = commitUserId;
	}
	
	
	public W5VcsCommit newInstance(String newProjectUuid){
		W5VcsCommit n = new W5VcsCommit();
		n.setComment(comment);
		n.setCommitTip(commitTip);
		n.setRunLocalFlag(runLocalFlag);
		n.setCommitUserId(commitUserId);
		n.setExtraSql(extraSql);
		n.setOprojectUuid(this.projectUuid);
		n.setProjectUuid(newProjectUuid);
		n.setVcsCommitId(vcsCommitId);
		return n;
	}

	@Column(name="oproject_uuid")
	public String getOprojectUuid() {
		return GenericUtil.isEmpty(oprojectUuid)?projectUuid:oprojectUuid;
	}

	public void setOprojectUuid(String oprojectUuid) {
		this.oprojectUuid = oprojectUuid;
	}

	@Column(name="run_local_flag")
	public short getRunLocalFlag() {
		return runLocalFlag;
	}

	public void setRunLocalFlag(short runLocalFlag) {
		this.runLocalFlag = runLocalFlag;
	}
	
}
