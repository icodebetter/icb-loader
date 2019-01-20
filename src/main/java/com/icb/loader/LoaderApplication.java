package com.icb.loader;

import com.icb.loader.domain.db.W5Form;
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
	public static String projectId="1bf77646-3045-4e87-9251-df035a969458";

	@Bean
	public RedissonClient redisson() {
		Config config = new Config();
		config.useSingleServer().setAddress(String.format("redis://%s:%s", "35.226.30.186", 6379)).setTimeout(100000).setConnectionMinimumIdleSize(10).setConnectionPoolSize(10);
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
		RMap<Integer, W5Table>  rtableMap= redissonClient.getMap(String.format("icb-project:%s:table", projectId));
		
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
		
		RMap<Integer, W5Query>  rqueryMap= redissonClient.getMap(String.format("icb-project:%s:query", projectId));
		
		for (W5Query qx : queries) {
			rqueryMap.put(qx.getQueryId(), qx);
		}
		
	}


	private void loadGrids(String projectId){
		List<W5Grid> grids = entityManager.createQuery("select f from W5Grid f where f.projectUuid=?0 order by f.queryId", W5Grid.class).setParameter(0, projectId).getResultList();
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
		
		RMap<Integer, W5Grid>  rgridMap= redissonClient.getMap(String.format("icb-project:%s:grid", projectId));
		
		for (W5Grid gx : grids) {
			rgridMap.put(gx.getGridId(), gx);
		}		
	}
	@EventListener(ApplicationReadyEvent.class)
	public void work() {
		loadTables(projectId);
		loadQueries(projectId);
		loadGrids(projectId);
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

