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

// Generated Feb 6, 2007 10:20:24 AM by Hibernate Tools 3.2.0.b9

@Entity
@Immutable
@Table(name="w5_look_up", schema="iwb")
public class W5LookUp implements java.io.Serializable, W5Base {

	private int lookUpId;
	
	private String dsc;
	
	private short cssClassFlag;
	
	private	List<W5LookUpDetay> _detayList;
	private	Map<String, W5LookUpDetay> _detayMap;

	public W5LookUp() {
	}


	@Id
	@Column(name="look_up_id")
	public int getLookUpId() {
		return this.lookUpId;
	}

	public void setLookUpId(int lookUpId) {
		this.lookUpId = lookUpId;
	}

	@Column(name="dsc")
	public String getDsc() {
		return this.dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	
	

	@Transient
	public List<W5LookUpDetay> get_detayList() {
		return _detayList;
	}

	public void set_detayList(List<W5LookUpDetay> detayList) {
		_detayList = detayList;
	}

	@Transient
	public Map<String, W5LookUpDetay> get_detayMap() {
		return _detayMap;
	}

	public void set_detayMap(Map<String, W5LookUpDetay> detayMap) {
		_detayMap = detayMap;
	}

	@Column(name="css_class_flag")
	public short getCssClassFlag() {
		return cssClassFlag;
	}

	public void setCssClassFlag(short cssClassFlag) {
		this.cssClassFlag = cssClassFlag;
	}



	@Transient
	public boolean safeEquals(W5Base q){
		if(q==null)return false;
		W5LookUp l = (W5LookUp)q;
		boolean b = this.lookUpId==l.getLookUpId() &&
			GenericUtil.safeEquals(this.dsc , l.getDsc()) &&
	//		this.parentLookUpId &&
			this.cssClassFlag==l.getCssClassFlag();
		if(!b)return false;
		
		if(!GenericUtil.safeEquals(this._detayList, l._detayList))return false;
		/*if(this._detayList!=null && l.get_detayList()!=null){
			if(this._detayList.size()==l.get_detayList().size())return false;
			for(int i=0;i<this._detayList.size();i++){
				W5LookUpDetay c1 = this._detayList.get(i); 
				W5LookUpDetay c2 = l.get_detayList().get(i);
				if(!c1.equals(c2))return false;
			}			
		} else if(this._detayList!=null ^ l.get_detayList()!=null) return false;*/
		
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
