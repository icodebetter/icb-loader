package iwb.domain.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;


@Entity
@Immutable
@Table(name="w5_tutorial")
public class W5Tutorial implements java.io.Serializable {

	private int tutorialId;

	private String dsc;
	private String introductionHtml;
	private String code;
	private int moduleId;
	private int menuId;
	private int renderTemplateId;
	private short closeTabsBeforeBeginFlag;
	private short activeFlag;
	
	private String requiredTutorialIds;
	private String recommendedTutorialIds;
	
	private W5Page _renderTemplate;
	
	@Id
	@Column(name="tutorial_id")
	public int getTutorialId() {
		return tutorialId;
	}
	public void setTutorialId(int tutorialId) {
		this.tutorialId = tutorialId;
	}
	@Column(name="dsc")
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	@Column(name="introduction_html")
	public String getIntroductionHtml() {
		return introductionHtml;
	}
	public void setIntroductionHtml(String introductionHtml) {
		this.introductionHtml = introductionHtml;
	}
	@Column(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(name="module_id")
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	@Column(name="required_tutorial_ids")
	public String getRequiredTutorialIds() {
		return requiredTutorialIds;
	}
	public void setRequiredTutorialIds(String requiredTutorialIds) {
		this.requiredTutorialIds = requiredTutorialIds;
	}
	@Column(name="recommended_tutorial_ids")
	public String getRecommendedTutorialIds() {
		return recommendedTutorialIds;
	}
	public void setRecommendedTutorialIds(String recommendedTutorialIds) {
		this.recommendedTutorialIds = recommendedTutorialIds;
	}
	@Column(name="active_flag")
	public short getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(short activeFlag) {
		this.activeFlag = activeFlag;
	}
	@Column(name="render_template_id")
	public int getRenderTemplateId() {
		return renderTemplateId;
	}
	public void setRenderTemplateId(int renderTemplateId) {
		this.renderTemplateId = renderTemplateId;
	}

	@Column(name="close_tabs_before_begin_flag")
	public short getCloseTabsBeforeBeginFlag() {
		return closeTabsBeforeBeginFlag;
	}
	public void setCloseTabsBeforeBeginFlag(short closeTabsBeforeBeginFlag) {
		this.closeTabsBeforeBeginFlag = closeTabsBeforeBeginFlag;
	}
	@Column(name="menu_id")
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	@Transient
	public W5Page get_renderTemplate() {
		return _renderTemplate;
	}
	public void set_renderTemplate(W5Page renderTemplate) {
		_renderTemplate = renderTemplate;
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
