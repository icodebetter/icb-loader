package com.icb.loader;

import com.icb.loader.domain.db.W5Card;
import com.icb.loader.domain.db.W5Conversion;
import com.icb.loader.domain.db.W5ConversionCol;
import com.icb.loader.domain.db.W5Form;
import com.icb.loader.domain.db.W5FormCell;
import com.icb.loader.domain.db.W5FormHint;
import com.icb.loader.domain.db.W5FormModule;
import com.icb.loader.domain.db.W5GlobalFunc;
import com.icb.loader.domain.db.W5GlobalFuncParam;
import com.icb.loader.domain.db.W5Grid;
import com.icb.loader.domain.db.W5GridColumn;
import com.icb.loader.domain.db.W5GridModule;
import com.icb.loader.domain.db.W5Query;
import com.icb.loader.domain.db.W5QueryField;
import com.icb.loader.domain.db.W5QueryParam;
import com.icb.loader.domain.db.W5Table;
import com.icb.loader.domain.db.W5TableChild;
import com.icb.loader.domain.db.W5TableEvent;
import com.icb.loader.domain.db.W5TableField;
import com.icb.loader.domain.db.W5TableParam;


import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class LoaderApplication {
	public static String projectId="067e6162-3b6f-4ae2-a221-2470b63dff00";
	public static String host="localhost";//"35.226.30.186";

	@Bean
	public RedissonClient redisson() {
		Config config = new Config();
		config.useSingleServer().setAddress(String.format("redis://%s:%s", host, 6379)).setTimeout(100000).setConnectionMinimumIdleSize(10).setConnectionPoolSize(10);
		RedissonClient rc = Redisson.create(config);
		return rc;
	}

	public static void main(String[] args) {
		if(args!=null && args.length>0)projectId=args[0];
		SpringApplication.run(LoaderApplication.class, args);
	}

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private RedissonClient redissonClient;

	
	private void loadTables(String projectId){
		List<W5Table> tables = entityManager.createQuery("select f from W5Table f where f.projectUuid=?0 order by f.tableId", W5Table.class).setParameter(0, projectId).getResultList();
		Map<Integer, W5Table> tableMap = new HashMap(tables.size()*4/3);
		for(W5Table t:tables)tableMap.put(t.getTableId(), t);
		
		List<W5TableField> tableFields = entityManager.createQuery("select f from W5TableField f where f.projectUuid=?0 order by f.tableId, f.tabOrder", W5TableField.class).setParameter(0, projectId).getResultList();
		List<W5TableParam> tableParams = entityManager.createQuery("select f from W5TableParam f where f.projectUuid=?0 order by f.tableId, f.tabOrder", W5TableParam.class).setParameter(0, projectId).getResultList();
		List<W5TableEvent> tableEvents = entityManager.createQuery("select f from W5TableEvent f where f.projectUuid=?0 order by f.tableId, f.tabOrder", W5TableEvent.class).setParameter(0, projectId).getResultList();
		List<W5TableChild> tableChilds = entityManager.createQuery("select f from W5TableChild f where f.projectUuid=?0 order by f.tableId, f.tableChildId", W5TableChild.class).setParameter(0, projectId).getResultList();
		
		W5Table t = null;
		for (W5TableField tf : tableFields) {
			if (t == null || tf.getTableId() != t.getTableId())
				t = tableMap.get(tf.getTableId()); // tableMap.get(tf.getTableId());
			if (t != null) {
				if (t.get_tableFieldList() == null) {
					t.set_tableFieldList(new ArrayList<W5TableField>());
					t.set_tableFieldMap(new HashMap<Integer, W5TableField>());
				}
				t.get_tableFieldList().add(tf);
				t.get_tableFieldMap().put(tf.getTableFieldId(), tf);
			}
		}
		t = null;
		for (W5TableParam tp : tableParams) {
			if (t == null || tp.getTableId() != t.getTableId())
				t = tableMap.get(tp.getTableId()); // tableMap.get(tf.getTableId());
			if (t != null) {
				if (t.get_tableParamList() == null) {
					t.set_tableParamList(new ArrayList<W5TableParam>());
				}
				t.get_tableParamList().add(tp);
			}
		}
		t = null;
		for (W5TableChild tc : tableChilds) {
			if (t == null || tc.getTableId() != t.getTableId())
				t = tableMap.get(tc.getTableId()); // tableMap.get(tf.getTableId());
			if (t != null && tableMap.get(tc.getRelatedTableId())!=null) {
				if (t.get_tableChildList() == null) {
					t.set_tableChildList(new ArrayList<W5TableChild>());
				}
				t.get_tableChildList().add(tc);
			}
			
			W5Table t2 = tableMap.get(tc.getRelatedTableId()); // tableMap.get(tf.getTableId());
			if (t2 != null && tableMap.get(tc.getTableId())!=null) {
				if (t2.get_tableParentList() == null) {
					t2.set_tableParentList(new ArrayList<W5TableChild>());
				}
				t2.get_tableParentList().add(tc);
			}
			
		}
		RMap<Integer, W5Table>  rtableMap= redissonClient.getMap(String.format("icb-cache:%s:table", projectId));
		
		for (W5Table tx : tables) {
			rtableMap.put(tx.getTableId(), tx);
		}
	}
	
	private void loadQueries(String projectId){
		List<W5Query> queries = entityManager.createQuery("select f from W5Query f where f.projectUuid=?0 order by f.queryId", W5Query.class).setParameter(0, projectId).getResultList();
		Map<Integer, W5Query> queryMap = new HashMap(queries.size()*4/3);
		for(W5Query q:queries)queryMap.put(q.getQueryId(), q);

		List<W5QueryField> querieFields = entityManager.createQuery("select f from W5QueryField f where f.projectUuid=?0 order by f.queryId, f.tabOrder", W5QueryField.class).setParameter(0, projectId).getResultList();
		List<W5QueryParam> querieParams = entityManager.createQuery("select f from W5QueryParam f where f.projectUuid=?0 order by f.queryId, f.tabOrder", W5QueryParam.class).setParameter(0, projectId).getResultList();
		
		W5Query q = null;
		for (W5QueryField qf : querieFields) {
			if (q == null || qf.getQueryId() != q.getQueryId())
				q = queryMap.get(qf.getQueryId()); // tableMap.get(tf.getTableId());
			
			if (q != null) {
				if (q.get_queryFields() == null) {
					q.set_queryFields(new ArrayList<W5QueryField>());
				}
				q.get_queryFields().add(qf);
			}
		}
		
		q = null;
		for (W5QueryParam qp : querieParams) {
			if (q == null || qp.getQueryId() != q.getQueryId())
				q = queryMap.get(qp.getQueryId()); // tableMap.get(tf.getTableId());
			
			if (q != null) {
				if (q.get_queryParams() == null) {
					q.set_queryParams(new ArrayList<W5QueryParam>());
				}
				q.get_queryParams().add(qp);
			}
		}
		
		RMap<Integer, W5Query>  rqueryMap= redissonClient.getMap(String.format("icb-cache:%s:query", projectId));
		
		for (W5Query qx : queries) {
			rqueryMap.put(qx.getQueryId(), qx);
		}
		
	}


	private void loadGrids(String projectId){
		List<W5Grid> grids = entityManager.createQuery("select f from W5Grid f where f.projectUuid=?0 order by f.gridId", W5Grid.class).setParameter(0, projectId).getResultList();
		Map<Integer, W5Grid> gridMap = new HashMap(grids.size()*4/3);
		for(W5Grid g:grids)gridMap.put(g.getGridId(), g);

		List<W5GridColumn> gridColumns = entityManager.createQuery("select f from W5GridColumn f where f.projectUuid=?0 order by f.gridId, f.tabOrder", W5GridColumn.class).setParameter(0, projectId).getResultList();
		List<W5GridModule> gridModules = entityManager.createQuery("select f from W5GridModule f where f.projectUuid=?0 order by f.gridId, f.tabOrder", W5GridModule.class).setParameter(0, projectId).getResultList();
		
		W5Grid g = null;
		for (W5GridColumn gc : gridColumns) {
			if (g == null || gc.getGridId() != g.getGridId())
				g = gridMap.get(gc.getGridId()); // tableMap.get(tf.getTableId());
			
			if (g != null) {
				if (g.get_gridColumnList() == null) {
					g.set_gridColumnList(new ArrayList<W5GridColumn>());
				}
				g.get_gridColumnList().add(gc);
			}
		}
		
		g = null;
		for (W5GridModule gm : gridModules) {
			if (g == null || gm.getGridId() != g.getGridId())
				g = gridMap.get(gm.getGridId()); // tableMap.get(tf.getTableId());
			
			if (g != null) {
				if (g.get_gridModuleList() == null) {
					g.set_gridModuleList(new ArrayList<W5GridModule>());
				}
				g.get_gridModuleList().add(gm);
			}
		}
		
		RMap<Integer, W5Grid>  rgridMap= redissonClient.getMap(String.format("icb-cache:%s:grid", projectId));
		
		for (W5Grid gx : grids) {
			rgridMap.put(gx.getGridId(), gx);
		}		
	}
	
	private void loadConversions(String projectId){
		List<W5Conversion> conversions = entityManager.createQuery("select f from W5Conversion f where f.projectUuid=?0 order by f.gridId", W5Conversion.class).setParameter(0, projectId).getResultList();
		Map<Integer, W5Conversion> conversionMap = new HashMap(conversions.size()*4/3);
		for(W5Conversion c:conversions)conversionMap.put(c.getConversionId(), c);

		List<W5ConversionCol> conversionCols = entityManager.createQuery("select f from W5ConversionCol f where f.projectUuid=?0 order by f.conversionId, f.tabOrder", W5ConversionCol.class).setParameter(0, projectId).getResultList();
		
		W5Conversion c = null;
		for (W5ConversionCol cc : conversionCols) {
			if (c == null || cc.getConversionId() != c.getConversionId())
				c = conversionMap.get(cc.getConversionId()); // tableMap.get(tf.getTableId());
			
			if (c != null) {
				if (c.get_conversionColList()== null) {
					c.set_conversionColList(new ArrayList<W5ConversionCol>());
					c.set_conversionColMap(new HashMap());;
				}
				c.get_conversionColList().add(cc);
				c.get_conversionColMap().put(cc.getConversionColId(), cc);
			}
		}
		
		RMap<Integer, W5Conversion>  rconversionMap= redissonClient.getMap(String.format("icb-cache:%s:conversion", projectId));
		
		for (W5Conversion cx : conversions) {
			rconversionMap.put(cx.getConversionId(), cx);
		}		
	}
	
	private void loadForms(String projectId){
		List<W5Form> forms = entityManager.createQuery("select f from W5Form f where f.projectUuid=?0 order by f.formId", W5Form.class).setParameter(0, projectId).getResultList();
		Map<Integer, W5Form> formMap = new HashMap(forms.size()*4/3);
		for(W5Form f:forms)formMap.put(f.getFormId(), f);

		List<W5FormCell> formCells = entityManager.createQuery("select f from W5FormCell f where f.projectUuid=?0 order by f.formId, f.tabOrder", W5FormCell.class).setParameter(0, projectId).getResultList();
		List<W5FormModule> formModules = entityManager.createQuery("select f from W5FormModule f where f.projectUuid=?0 order by f.formId, f.tabOrder", W5FormModule.class).setParameter(0, projectId).getResultList();
		List<W5FormHint> formHints = entityManager.createQuery("select f from W5FormHint f where f.projectUuid=?0 order by f.formId, f.tabOrder", W5FormHint.class).setParameter(0, projectId).getResultList();
		
		W5Form f = null;
		for (W5FormCell fc : formCells) {
			if (f == null || fc.getFormId() != f.getFormId())
				f = formMap.get(fc.getFormId()); // tableMap.get(tf.getTableId());
			
			if (f != null) {
				if (f.get_formCells() == null) {
					f.set_formCells(new ArrayList<W5FormCell>());
				}
				f.get_formCells().add(fc);
			}
		}
		
		f = null;
		for (W5FormModule fm : formModules) {
			if (f == null || fm.getFormId() != f.getFormId())
				f = formMap.get(fm.getFormId()); // tableMap.get(tf.getTableId());
			
			if (f != null) {
				if (f.get_moduleList() == null) {
					f.set_moduleList(new ArrayList<W5FormModule>());
				}
				f.get_moduleList().add(fm);
			}
		}
		
		f = null;
		for (W5FormHint fh : formHints) {
			if (f == null || fh.getFormId() != f.getFormId())
				f = formMap.get(fh.getFormId()); // tableMap.get(tf.getTableId());
			
			if (f != null) {
				if (f.get_formHintList() == null) {
					f.set_formHintList(new ArrayList<W5FormHint>());
				}
				f.get_formHintList().add(fh);
			}
		}
		
		RMap<Integer, W5Form>  rformMap= redissonClient.getMap(String.format("icb-cache:%s:form", projectId));
		
		for (W5Form fx : forms) {
			rformMap.put(fx.getFormId(), fx);
		}		
	}
	

	private void loadCards(String projectId){
		List<W5Card> cards = entityManager.createQuery("select f from W5Card f where f.projectUuid=?0 order by f.dataViewId", W5Card.class).setParameter(0, projectId).getResultList();
		Map<Integer, W5Card> cardMap = new HashMap(cards.size()*4/3);
		for(W5Card c:cards)cardMap.put(c.getDataViewId(), c);

		
		RMap<Integer, W5Card>  rcardMap= redissonClient.getMap(String.format("icb-cache:%s:card", projectId));
		
		for (W5Card cx : cards) {
			rcardMap.put(cx.getDataViewId(), cx);
		}		
	}
	

	private void loadGlobalFuncs(String projectId){
		List<W5GlobalFunc> funcs = entityManager.createQuery("select f from W5GlobalFunc f where f.projectUuid=?0 order by f.dbFuncId", W5GlobalFunc.class).setParameter(0, projectId).getResultList();
		Map<Integer, W5GlobalFunc> funcMap = new HashMap(funcs.size()*4/3);
		for(W5GlobalFunc c:funcs)funcMap.put(c.getDbFuncId(), c);
		
		List<W5GlobalFuncParam> funcParams = entityManager.createQuery("select f from W5GlobalFuncParam f where f.projectUuid=?0 order by f.dbFuncId, f.tabOrder", W5GlobalFuncParam.class).setParameter(0, projectId).getResultList();


		W5GlobalFunc f = null;
		for (W5GlobalFuncParam fp : funcParams) {
			if (f == null || fp.getDbFuncId() != f.getDbFuncId())
				f = funcMap.get(fp.getDbFuncId()); // tableMap.get(tf.getTableId());
			
			if (f != null) {
				if (f.get_dbFuncParamList() == null) {
					f.set_dbFuncParamList(new ArrayList<W5GlobalFuncParam>());
				}
				f.get_dbFuncParamList().add(fp);
			}
		}
		
		
		RMap<Integer, W5GlobalFunc>  rfuncMap= redissonClient.getMap(String.format("icb-cache:%s:func", projectId));
		
		for (W5GlobalFunc cx : funcs) {
			rfuncMap.put(cx.getDbFuncId(), cx);
		}		
	}
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void work() {
		loadTables(projectId);
		loadForms(projectId);
		loadQueries(projectId);
		loadGrids(projectId);
		loadCards(projectId);
		loadGlobalFuncs(projectId);
		loadConversions(projectId);
		if(true)return;
		
		List<W5Form> forms = entityManager.createQuery("select f from W5Form f where f.projectUuid=?0", W5Form.class).setParameter(0, projectId).getResultList();
		RMap<String, RMap<Integer, W5Form>> formsMap = redissonClient.getMap("allForms");
		for (W5Form result : forms) {
			RMap<Integer, W5Form> projectFormsMap = formsMap.get(result.getProjectUuid());
			if (projectFormsMap == null) {
				projectFormsMap = redissonClient.getMap(String.format("project:%s:forms", result.getProjectUuid()));
				formsMap.put(result.getProjectUuid(), projectFormsMap);
			}
			projectFormsMap.put(result.getFormId(), result);
		}
		formsMap.values().iterator().next().values();
	}
}

