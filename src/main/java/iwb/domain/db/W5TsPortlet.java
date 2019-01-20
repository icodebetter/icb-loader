package iwb.domain.db;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;


@Entity
@Immutable
@Table(name="w5_ts_portlet")
public class W5TsPortlet implements java.io.Serializable {
	private static final long serialVersionUID = -3436475318977086382L;

	private int portletId;
	
	private short codeTip;
	private String dsc;
	private String extraCode;
	private Short timeRangeDuration;
	private String timeRangeResolutionTip;
	private Short duration;
	private String resolutionTip;
	private List<W5TsPortletObject> _portletObjects;
	
	public W5TsPortlet(){
	}

	@Id
	@Column(name="portlet_id")
	public int getPortletId() {
		return portletId;
	}

	public void setPortletId(int portletId) {
		this.portletId = portletId;
	}
	


	@Column(name="code_tip")
	public short getCodeTip() {
		return codeTip;
	}

	public void setCodeTip(short codeTip) {
		this.codeTip = codeTip;
	}

	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	@Column(name="extra_code")
	public String getExtraCode() {
		return extraCode;
	}

	public void setExtraCode(String extraCode) {
		this.extraCode = extraCode;
	}

	@Column(name="time_range_duration")
	public Short getTimeRangeDuration() {
		return timeRangeDuration;
	}

	public void setTimeRangeDuration(Short timeRangeDuration) {
		this.timeRangeDuration = timeRangeDuration;
	}

	@Column(name="time_range_resolution_tip")
	public String getTimeRangeResolutionTip() {
		return timeRangeResolutionTip;
	}

	public void setTimeRangeResolutionTip(String timeRangeResolutionTip) {
		this.timeRangeResolutionTip = timeRangeResolutionTip;
	}

	@Column(name="duration")
	public Short getDuration() {
		return duration;
	}

	public void setDuration(Short duration) {
		this.duration = duration;
	}

	@Column(name="resolution_tip")
	public String getResolutionTip() {
		return resolutionTip;
	}

	public void setResolutionTip(String resolutionTip) {
		this.resolutionTip = resolutionTip;
	}

	@Transient
	public List<W5TsPortletObject> get_portletObjects() {
		return _portletObjects;
	}

	public void set_portletObjects(List<W5TsPortletObject> _portletObjects) {
		this._portletObjects = _portletObjects;
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
