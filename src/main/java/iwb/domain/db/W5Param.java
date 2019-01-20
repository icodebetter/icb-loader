package iwb.domain.db;

import java.math.BigDecimal;



public interface W5Param  {


	public String getDsc();

	public short getParamTip();
	
	public short getNotNullFlag();
	
	public short getSourceTip();
	

	public String getDefaultValue();
	
	public BigDecimal getMinValue();

	public BigDecimal getMaxValue();

	public Short getMinLength();
	
	public Short getMaxLength();
	
	public short getTabOrder();
	
}
