package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;


@Entity
@Immutable
@Table(name="w5_ts_portlet_object")
public class W5TsPortletObject implements java.io.Serializable {
	private static final long serialVersionUID = -3436412348977086382L;

	private int portletObjectId;
	private int portletId;
	
	private short tabOrder;
	private int objectTip;
	private int objectId;
	private String extraCode;
	private Object _sourceObject;
	
	public W5TsPortletObject(){
	}
	
	@Id
	@Column(name="portlet_object_id")
	public int getPortletObjectId() {
		return portletObjectId;
	}

	public void setPortletObjectId(int portletObjectId) {
		this.portletObjectId = portletObjectId;
	}
	
	



	@Column(name="portlet_id")
	public int getPortletId() {
		return portletId;
	}

	public void setPortletId(int portletId) {
		this.portletId = portletId;
	}

	@Column(name="tab_order")
	public short getTabOrder() {
		return tabOrder;
	}

	public void setTabOrder(short tabOrder) {
		this.tabOrder = tabOrder;
	}

	@Column(name="object_tip")
	public int getObjectTip() {
		return objectTip;
	}

	public void setObjectTip(int objectTip) {
		this.objectTip = objectTip;
	}

	@Column(name="object_id")
	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	@Column(name="extra_code")
	public String getExtraCode() {
		return extraCode;
	}

	public void setExtraCode(String extraCode) {
		this.extraCode = extraCode;
	}

	@Transient
	public Object get_sourceObject() {
		return _sourceObject;
	}

	public void set_sourceObject(Object _sourceObject) {
		this._sourceObject = _sourceObject;
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
