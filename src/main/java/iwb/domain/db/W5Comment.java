package iwb.domain.db;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="w5_comment",schema="iwb")
public class W5Comment  implements java.io.Serializable {

	private int commentId;
	private int tableId;
	private int tablePk;
	private String dsc;
	private int commentUserId;
	private	Timestamp commentDttm;
	
	private String projectUuid;
	@Id	
	@Column(name="project_uuid")
	public String getProjectUuid() {
		return projectUuid;
	}

	public W5Comment(String projectUuid) {
    super();
    this.projectUuid = projectUuid;
  }

  public void setProjectUuid(String projectUuid) {
		this.projectUuid = projectUuid;
	}
	
    @SequenceGenerator(name="sex_comment",sequenceName="iwb.seq_comment",allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sex_comment")
	@Column(name="comment_id")
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	
	@Column(name="table_id")
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	
	@Column(name="table_pk")
	public int getTablePk() {
		return tablePk;
	}
	public void setTablePk(int tablePk) {
		this.tablePk = tablePk;
	}
	
	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	
	@Column(name="comment_user_id")
	public int getCommentUserId() {
		return commentUserId;
	}
	public void setCommentUserId(int commentUserId) {
		this.commentUserId = commentUserId;
	}
	
	@Column(name="comment_dttm")
	public Timestamp getCommentDttm() {
		return commentDttm;
	}
	public void setCommentDttm(Timestamp commentDttm) {
		this.commentDttm = commentDttm;
	}
	
	public W5Comment() {
		super();
	}
	
	
	
}

