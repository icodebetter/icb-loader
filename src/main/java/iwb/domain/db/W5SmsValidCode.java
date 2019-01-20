package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

// Generated Jun 17, 2007 5:12:14 PM by Hibernate Tools 3.2.0.b9


@Entity
@Immutable
@Table(name="w5_sms_valid_code")
public class W5SmsValidCode implements java.io.Serializable {
	private static final long serialVersionUID = 3223467949864599144L;
	private int smsValidCodeId;
	private int userId;
	private int customizationId;
	private String smsCode;
	private short validated;

	@SequenceGenerator(name="sex_sms_valid_code",sequenceName="iwb.seq_sms_valid_code",allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sex_sms_valid_code")
	
	@Column(name="sms_valid_code_id")
	public int getSmsValidCodeId() {
		return smsValidCodeId;
	}
	public void setSmsValidCodeId(int smsValidCodeId) {
		this.smsValidCodeId = smsValidCodeId;
	}
	
	@Column(name="user_id")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name="customization_id")
	public int getCustomizationId() {
		return customizationId;
	}
	public void setCustomizationId(int customizationId) {
		this.customizationId = customizationId;
	}
	
	@Column(name="sms_code")
	public String getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	
	@Column(name="validated")
	public short getValidated() {
		return validated;
	}
	public void setValidated(short validated) {
		this.validated = validated;
	}
}
