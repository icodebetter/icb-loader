package iwb.domain.db;

import java.util.List;



public interface W5ListBase {
	public List<W5QueryField> get_postProcessQueryFields();
	
	public void set_postProcessQueryFields(List<W5QueryField> postProcessQueryFields);
	
	public W5Workflow get_workflow();
	public void set_workflow(W5Workflow workflow);
	
	public List<W5FormSmsMail> get_crudFormSmsMailList();
	public void set_crudFormSmsMailList(List<W5FormSmsMail> _crudFormSmsMailList);

	public List<W5Conversion> get_crudFormConversionList();
	public void set_crudFormConversionList(List<W5Conversion> _crudFormConversionList);

	public W5Query get_query();	
	public void set_query(W5Query query);
}
