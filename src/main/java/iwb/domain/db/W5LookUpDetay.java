package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

import iwb.util.GenericUtil;

// Generated Feb 6, 2007 10:20:24 AM by Hibernate Tools 3.2.0.b9

@Entity
@Immutable
@Table(name="w5_look_up_detay", schema="iwb")
public class W5LookUpDetay implements java.io.Serializable, W5Detay, W5Base {

	private int lookUpDetayId;
	
	private int lookUpId;

	private int tabOrder;

	private String val;

	private String dsc;
	
	private short activeFlag;
	
	private String parentVal;

	public W5LookUpDetay() {
	}
	@Id
	@Column(name="look_up_detay_id")
	public int getLookUpDetayId() {
		return this.lookUpDetayId;
	}

	public void setLookUpDetayId(int lookUpDetayId) {
		this.lookUpDetayId = lookUpDetayId;
	}

	@Column(name="look_up_id")
	public int getLookUpId() {
		return this.lookUpId;
	}

	public void setLookUpId(int lookUpId) {
		this.lookUpId = lookUpId;
	}

	@Column(name="tab_order")
	public int getTabOrder() {
		return tabOrder;
	}
	public void setTabOrder(int tabOrder) {
		this.tabOrder = tabOrder;
	}
	@Column(name="val")
	public String getVal() {
		return this.val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	@Column(name="dsc")
	public String getDsc() {
		return this.dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	

	
	@Column(name="parent_val")
	public String getParentVal() {
		return parentVal;
	}
	public void setParentVal(String parentVal) {
		this.parentVal = parentVal;
	}
	
	@Column(name="active_flag")
	public short getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(short activeFlag) {
		this.activeFlag = activeFlag;
	}
	@Transient
	public boolean safeEquals(W5Base q){
		if(q==null)return false;
		W5LookUpDetay l = (W5LookUpDetay)q;
		return this.lookUpDetayId== l.lookUpDetayId &&
			this.lookUpId==l.lookUpId &&
			this.tabOrder==l.tabOrder &&
			GenericUtil.safeEquals(this.val , l.getVal()) &&
			GenericUtil.safeEquals(this.dsc , l.getDsc()) &&
			this.activeFlag==l.activeFlag &&
			GenericUtil.safeEquals(this.parentVal , l.getParentVal());

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
