package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="w5_jasper_object",schema="iwb")
public class W5JasperObject implements java.io.Serializable {

		private int jasperObjectId;
		private int jasperId;
		private int objectTip;
		private int objectId;
		private int tabOrder;
		private int singleRecordFlag;
		private short htmlFlag;
		private short jasperQueryType;
		private int jasperParentQueryId;
		private int jasperParentQueryFieldId;
		private int jasperQueryFieldId;		

		@Id
		@Column(name="jasper_object_id")	
		public int getJasperObjectId() {
			return jasperObjectId;
		}
		public void setJasperObjectId(int jasperObjectId) {
			this.jasperObjectId = jasperObjectId;
		}
		@Column(name="jasper_id")	
		public int getJasperId() {
			return jasperId;
		}
		public void setJasperId(int jasperId) {
			this.jasperId = jasperId;
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
		@Column(name="tab_order")
		public int getTabOrder() {
			return tabOrder;
		}
		public void setTabOrder(int tabOrder) {
			this.tabOrder = tabOrder;
		}
		@Column(name="single_record_flag")
		public int getSingleRecordFlag() {
			return singleRecordFlag;
		}
		public void setSingleRecordFlag(int singleRecordFlag) {
			this.singleRecordFlag = singleRecordFlag;
		}
		@Column(name="html_flag")
		public short getHtmlFlag() {
			return htmlFlag;
		}
		public void setHtmlFlag(short htmlFlag) {
			this.htmlFlag = htmlFlag;
		}
		@Column(name="jasper_query_type")
		public short getJasperQueryType() {
			return jasperQueryType;
		}
		public void setJasperQueryType(short jasperQueryType) {
			this.jasperQueryType = jasperQueryType;
		}
}
