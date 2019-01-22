package iwb;

import iwb.domain.db.M5List;
import iwb.domain.db.W5Card;
import iwb.domain.db.W5Component;
import iwb.domain.db.W5Conversion;
import iwb.domain.db.W5ConversionCol;
import iwb.domain.db.W5Form;
import iwb.domain.db.W5FormCell;
import iwb.domain.db.W5FormHint;
import iwb.domain.db.W5FormModule;
import iwb.domain.db.W5FormSmsMail;
import iwb.domain.db.W5GlobalFunc;
import iwb.domain.db.W5GlobalFuncParam;
import iwb.domain.db.W5Grid;
import iwb.domain.db.W5GridColumn;
import iwb.domain.db.W5GridModule;
import iwb.domain.db.W5LookUp;
import iwb.domain.db.W5LookUpDetay;
import iwb.domain.db.W5ObjectMenuItem;
import iwb.domain.db.W5ObjectToolbarItem;
import iwb.domain.db.W5Page;
import iwb.domain.db.W5PageObject;
import iwb.domain.db.W5Project;
import iwb.domain.db.W5Query;
import iwb.domain.db.W5QueryField;
import iwb.domain.db.W5QueryParam;
import iwb.domain.db.W5Table;
import iwb.domain.db.W5TableChild;
import iwb.domain.db.W5TableEvent;
import iwb.domain.db.W5TableField;
import iwb.domain.db.W5TableParam;
import iwb.domain.db.W5Ws;
import iwb.domain.db.W5WsMethod;
import iwb.domain.db.W5WsMethodParam;
import iwb.util.GenericUtil;

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
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class LoaderApplication {
	public static String projectId = "6a38cf0c-2389-43d6-9e74-7d41746b1f8f"; // 22dbc523-80a9-4441-946f-7ccf8283c4cf
																				// //067e6162-3b6f-4ae2-a221-2470b63dff00
	public static String host = "35.226.30.186"; // 35.226.30.186
	
	public static boolean xtype = true;

	@Bean
	public RedissonClient redisson() {
		Config config = new Config();
		config.useSingleServer().setAddress(String.format("redis://%s:%s", host, 6379)).setTimeout(100000)
				.setConnectionMinimumIdleSize(2).setConnectionPoolSize(2);
		RedissonClient rc = Redisson.create(config);
		return rc;
	}

	public static void main(String[] args) {
		if (args != null && args.length > 0)
			projectId = args[0];
		SpringApplication.run(LoaderApplication.class, args);
	}

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private RedissonClient redissonClient;

	private Map<String, Object> loadTables(String projectId) {
		List<W5Table> tables = entityManager
				.createQuery("select f from W5Table f where f.projectUuid=?0 order by f.tableId", W5Table.class)
				.setParameter(0, projectId).getResultList();
		Map<Integer, W5Table> tableMap = new HashMap(tables.size() * 4 / 3);
		for (W5Table t : tables)
			tableMap.put(t.getTableId(), t);

		List<W5TableField> tableFields = entityManager.createQuery(
				"select f from W5TableField f where f.tabOrder>0 AND f.projectUuid=?0 order by f.tableId, f.tabOrder",
				W5TableField.class).setParameter(0, projectId).getResultList();
		List<W5TableParam> tableParams = entityManager
				.createQuery("select f from W5TableParam f where f.projectUuid=?0 order by f.tableId, f.tabOrder",
						W5TableParam.class)
				.setParameter(0, projectId).getResultList();
		List<W5TableChild> tableChilds = entityManager
				.createQuery("select f from W5TableChild f where f.projectUuid=?0 order by f.tableId, f.tableChildId",
						W5TableChild.class)
				.setParameter(0, projectId).getResultList();

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
			if (t != null && tableMap.get(tc.getRelatedTableId()) != null) {
				if (t.get_tableChildList() == null) {
					t.set_tableChildList(new ArrayList<W5TableChild>());
				}
				t.get_tableChildList().add(tc);
			}

			W5Table t2 = tableMap.get(tc.getRelatedTableId()); // tableMap.get(tf.getTableId());
			if (t2 != null && tableMap.get(tc.getTableId()) != null) {
				if (t2.get_tableParentList() == null) {
					t2.set_tableParentList(new ArrayList<W5TableChild>());
				}
				t2.get_tableParentList().add(tc);
			}

		}


		List<W5TableEvent> tableEvents = entityManager.createQuery(
				"select f from W5TableEvent f where f.activeFlag=1 AND f.projectUuid=?0 order by f.tableId, f.tabOrder",
				W5TableEvent.class).setParameter(0, projectId).getResultList();
		Map<Integer, List<W5TableEvent>> tableEventMap = new HashMap();
		t = null;
		for (W5TableEvent te : tableEvents) {
			if (t == null || te.getTableId() != t.getTableId())
				t = tableMap.get(te.getTableId()); // tableMap.get(tf.getTableId());
			if (t != null) {
				List<W5TableEvent> lte = tableEventMap.get(t.getTableId());
				if (lte == null) {
					lte = new ArrayList();
					tableEventMap.put(t.getTableId(), lte);
				}
				lte.add(te);
			}
		}

		if(xtype){
			Map<String, Object> r = new HashMap();
			r.put("table", tableMap);
			r.put("tableEvent", tableEventMap);
			return r;
		}
		if (!tables.isEmpty()) {
			RMap<Integer, W5Table> rtableMap = redissonClient.getMap(String.format("icb-cache2:%s:table", projectId));
	
			for (W5Table tx : tables) {
				rtableMap.put(tx.getTableId(), tx);
			}
		}
		if (!tableEventMap.isEmpty()) {// rgridMap.getName()
			RMap<Integer, List<W5TableEvent>> rtableEventMap = redissonClient
					.getMap(String.format("icb-cache2:%s:tableEvent", projectId));
			for (Integer key : tableEventMap.keySet())
				rtableEventMap.put(key, tableEventMap.get(key));
		}
		// rtableMap.values().iterator().next();
		return null;
	}

	private Map<String, Object>  loadQueries(String projectId) {
		List<W5Query> queries = entityManager
				.createQuery("select f from W5Query f where f.projectUuid=?0 order by f.queryId", W5Query.class)
				.setParameter(0, projectId).getResultList();
		Map<Integer, W5Query> queryMap = new HashMap(queries.size() * 4 / 3);
		for (W5Query q : queries)
			queryMap.put(q.getQueryId(), q);

		List<W5QueryField> querieFields = entityManager.createQuery(
				"select f from W5QueryField f where f.tabOrder>0 AND f.postProcessTip!=99 AND f.projectUuid=?0 order by f.queryId, f.tabOrder",
				W5QueryField.class).setParameter(0, projectId).getResultList();
		List<W5QueryParam> querieParams = entityManager
				.createQuery("select f from W5QueryParam f where f.projectUuid=?0 order by f.queryId, f.tabOrder",
						W5QueryParam.class)
				.setParameter(0, projectId).getResultList();

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
		if(xtype){
			Map<String, Object> r = new HashMap();
			for(Integer key:queryMap.keySet())
				r.put(projectId+":query:"+key, queryMap.get(key));
			return r;
		}
		
		RMap<Integer, W5Query> rqueryMap = redissonClient.getMap(String.format("icb-cache2:%s:query", projectId));

		for (W5Query qx : queries) {
			rqueryMap.put(qx.getQueryId(), qx);
		}
		// rqueryMap.values().iterator().next();
		return null;

	}

	private Map<String, Object>  loadLookups(String projectId) {
		List<W5LookUp> lookUps = entityManager
				.createQuery("select f from W5LookUp f where f.projectUuid=?0 order by f.lookUpId", W5LookUp.class)
				.setParameter(0, projectId).getResultList();
		Map<Integer, W5LookUp> lookUpMap = new HashMap(lookUps.size() * 4 / 3);
		for (W5LookUp l : lookUps)
			lookUpMap.put(l.getLookUpId(), l);

		List<W5LookUpDetay> lookUpDetails = entityManager
				.createQuery("select f from W5LookUpDetay f where f.projectUuid=?0 order by f.lookUpId, f.tabOrder",
						W5LookUpDetay.class)
				.setParameter(0, projectId).getResultList();

		W5LookUp l = null;
		for (W5LookUpDetay ld : lookUpDetails) {
			if (l == null || ld.getLookUpId() != l.getLookUpId())
				l = lookUpMap.get(ld.getLookUpId()); // tableMap.get(tf.getTableId());

			if (l != null) {
				if (l.get_detayList() == null) {
					l.set_detayList(new ArrayList<W5LookUpDetay>());
					l.set_detayMap(new HashMap());
				}
				l.get_detayList().add(ld);
				l.get_detayMap().put(ld.getVal(), ld);
			}
		}

		if(xtype){
			Map<String, Object> r = new HashMap();
			r.put("lookUp", lookUpMap);
			return r;
		}
		
		RMap<Integer, W5LookUp> rlookUpMap = redissonClient.getMap(String.format("icb-cache2:%s:lookUp", projectId));

		for (W5LookUp lx : lookUps) {
			rlookUpMap.put(lx.getLookUpId(), lx);
		}
		// rlookUpMap.values().iterator().next();
		return null;

	}

	private Map<String, Object>  loadComponents(String projectId) {
		List<W5Component> components = entityManager
				.createQuery("select f from W5Component f where f.projectUuid=?0 order by f.componentId",
						W5Component.class)
				.setParameter(0, projectId).getResultList();

		if(xtype){
			Map<Integer, W5Component> componentMap = new HashMap();
			for (W5Component cx : components) {
				componentMap.put(cx.getComponentId(), cx);
			}
			
			Map<String, Object> r = new HashMap();
			r.put("component", componentMap);
			return r;
		}
		RMap<Integer, W5Component> rcomponentMap = redissonClient
				.getMap(String.format("icb-cache2:%s:component", projectId));

		for (W5Component cx : components) {
			rcomponentMap.put(cx.getComponentId(), cx);
		}
		// rcomponentMap.values().iterator().next();
		return null;

	}

	private Map<String, Object>  loadPages(String projectId) {
		List<W5Page> pages = entityManager
				.createQuery("select f from W5Page f where f.projectUuid=?0 order by f.templateId", W5Page.class)
				.setParameter(0, projectId).getResultList();
		Map<Integer, W5Page> pageMap = new HashMap(pages.size() * 4 / 3);
		for (W5Page p : pages)
			pageMap.put(p.getTemplateId(), p);

		List<W5PageObject> pageObjects = entityManager
				.createQuery("select f from W5PageObject f where f.projectUuid=?0 order by f.templateId, f.tabOrder",
						W5PageObject.class)
				.setParameter(0, projectId).getResultList();

		W5Page p = null;
		for (W5PageObject ld : pageObjects) {
			if (p == null || ld.getTemplateId() != p.getTemplateId())
				p = pageMap.get(ld.getTemplateId()); // tableMap.get(tf.getTableId());

			if (p != null) {
				if (p.get_pageObjectList() == null) {
					p.set_pageObjectList(new ArrayList<W5PageObject>());
				}
				p.get_pageObjectList().add(ld);
			}
		}

		for (W5PageObject to : pageObjects)
			if (to.getSrcQueryFieldId() != null && to.getDstQueryParamId() != null) {
				List lp = new ArrayList();
				lp.add(projectId);
				lp.add(to.getSrcQueryFieldId());
				lp.add(projectId);
				lp.add(to.getDstQueryParamId());
				String sql = "select (select f1.dsc from iwb.w5_query_field f1 where f1.project_uuid=?0 AND f1.query_field_id=?1) x1, "
						+ "(select p1.dsc from iwb.w5_query_param p1 where p1.project_uuid=?2 AND p1.query_param_id=?3) x2 ";
				if (to.getDstStaticQueryParamId() != null && !GenericUtil.isEmpty(to.getDstStaticQueryParamVal())) {
					lp.add(projectId);
					lp.add(to.getDstStaticQueryParamId());
					sql += ",(select p1.dsc from iwb.w5_query_param p1 where p1.project_uuid=?4 AND p1.query_param_id=?5) x3";
				}
				sql += " from iwb.w5_table limit 1";

				Query q = entityManager.createNativeQuery(sql);
				int position = 0;
				for (Object pm : lp)
					q.setParameter(position++, pm);
				List l = q.getResultList();

				// List l = executeSQLQuery2Map(sql, lp);
				if (!GenericUtil.isEmpty(l)) {
					Object[] m = (Object[]) l.get(0);
					to.set_srcQueryFieldName((String) m[0]);
					to.set_dstQueryParamName((String) m[1]);
					if (m.length > 2)
						to.set_dstStaticQueryParamName((String) m[2]);
				}
			}

		if(xtype){
			Map<String, Object> r = new HashMap();
			for(Integer key:pageMap.keySet())
				r.put(projectId+":page:"+key, pageMap.get(key));
			return r;
		}
		
		RMap<Integer, W5Page> rpageMap = redissonClient.getMap(String.format("icb-cache2:%s:page", projectId));

		for (W5Page lx : pages) {
			rpageMap.put(lx.getTemplateId(), lx);
		}
		// rpageMap.values().iterator().next();
		return null;
	}

	private Map<String, Object>  loadGrids(String projectId) {
		List<W5Grid> grids = entityManager
				.createQuery("select f from W5Grid f where f.projectUuid=?0 order by f.gridId", W5Grid.class)
				.setParameter(0, projectId).getResultList();
		Map<Integer, W5Grid> gridMap = new HashMap(grids.size() * 4 / 3);
		for (W5Grid g : grids)
			gridMap.put(g.getGridId(), g);

		List<W5GridColumn> gridColumns = entityManager
				.createQuery("select f from W5GridColumn f where f.projectUuid=?0 order by f.gridId, f.tabOrder",
						W5GridColumn.class)
				.setParameter(0, projectId).getResultList();
		List<W5GridModule> gridModules = entityManager
				.createQuery("select f from W5GridModule f where f.projectUuid=?0 order by f.gridId, f.tabOrder",
						W5GridModule.class)
				.setParameter(0, projectId).getResultList();
		List<W5ObjectToolbarItem> gridToolbarItems = entityManager.createQuery(
				"select f from W5ObjectToolbarItem f where f.objectTip=5 AND f.projectUuid=?0 order by f.objectId, f.tabOrder",
				W5ObjectToolbarItem.class).setParameter(0, projectId).getResultList();
		List<W5ObjectMenuItem> gridMenuItems = entityManager.createQuery(
				"select f from W5ObjectMenuItem f where f.objectTip=5 AND f.projectUuid=?0 order by f.objectId, f.tabOrder",
				W5ObjectMenuItem.class).setParameter(0, projectId).getResultList();
		List<Object[]> gridSearchFormIds = entityManager.createQuery(
				"select f.formId, f.objectId from W5Form f where f.objectTip=1 AND f.projectUuid=?0 order by f.formId, f.tabOrder",
				Object[].class).setParameter(0, projectId).getResultList();

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

		g = null;
		for (W5ObjectToolbarItem gt : gridToolbarItems) {
			if (g == null || gt.getObjectId() != g.getGridId())
				g = gridMap.get(gt.getObjectId()); // tableMap.get(tf.getTableId());

			if (g != null) {
				if (g.get_toolbarItemList() == null) {
					g.set_toolbarItemList(new ArrayList<W5ObjectToolbarItem>());
				}
				g.get_toolbarItemList().add(gt);
			}
		}

		g = null;
		for (W5ObjectMenuItem gm : gridMenuItems) {
			if (g == null || gm.getObjectId() != g.getGridId())
				g = gridMap.get(gm.getObjectId()); // tableMap.get(tf.getTableId());

			if (g != null) {
				if (g.get_menuItemList() == null) {
					g.set_menuItemList(new ArrayList<W5ObjectMenuItem>());
				}
				g.get_menuItemList().add(gm);
			}
		}

		for (Object[] gsfi : gridSearchFormIds) {
			int gridId = (Integer) gsfi[1];
			g = gridMap.get(gridId); // tableMap.get(tf.getTableId());

			if (g != null) {
				g.set_searchFormId((Integer) gsfi[0]);
			}
		}
		if(xtype){
			Map<String, Object> r = new HashMap();
			for(Integer key:gridMap.keySet())
				r.put(projectId+":grid:"+key, gridMap.get(key));
			return r;
		}

		RMap<Integer, W5Grid> rgridMap = redissonClient.getMap(String.format("icb-cache2:%s:grid", projectId));

		for (W5Grid gx : grids) {
			rgridMap.put(gx.getGridId(), gx);
		}
		// rgridMap.values().iterator().next();
		return null;

	}

	private Map<String, Object>  loadMList(String projectId) {
		List<M5List> mlists = entityManager
				.createQuery("select f from M5List f where f.projectUuid=?0 order by f.listId", M5List.class)
				.setParameter(0, projectId).getResultList();
		Map<Integer, M5List> mlistMap = new HashMap(mlists.size() * 4 / 3);
		for (M5List ml : mlists)
			mlistMap.put(ml.getListId(), ml);

		List<W5ObjectToolbarItem> gridToolbarItems = entityManager.createQuery(
				"select f from W5ObjectToolbarItem f where f.objectTip=1345 AND f.projectUuid=?0 order by f.objectId, f.tabOrder",
				W5ObjectToolbarItem.class).setParameter(0, projectId).getResultList();
		List<W5ObjectMenuItem> gridMenuItems = entityManager.createQuery(
				"select f from W5ObjectMenuItem f where f.objectTip=1345 AND f.projectUuid=?0 order by f.objectId, f.tabOrder",
				W5ObjectMenuItem.class).setParameter(0, projectId).getResultList();
		List<Object[]> mlistSearchFormIds = entityManager.createQuery(
				"select f.formId, f.objectId from W5Form f where f.objectTip=10 AND f.projectUuid=?0 order by f.formId, f.tabOrder",
				Object[].class).setParameter(0, projectId).getResultList();

		M5List ml = null;
		for (W5ObjectToolbarItem gt : gridToolbarItems) {
			if (ml == null || gt.getObjectId() != ml.getListId())
				ml = mlistMap.get(gt.getObjectId()); // tableMap.get(tf.getTableId());

			if (ml != null) {
				if (ml.get_toolbarItemList() == null) {
					ml.set_toolbarItemList(new ArrayList<W5ObjectToolbarItem>());
				}
				ml.get_toolbarItemList().add(gt);
			}
		}

		ml = null;
		for (W5ObjectMenuItem gm : gridMenuItems) {
			if (ml == null || gm.getObjectId() != ml.getListId())
				ml = mlistMap.get(gm.getObjectId()); // tableMap.get(tf.getTableId());

			if (ml != null) {
				if (ml.get_menuItemList() == null) {
					ml.set_menuItemList(new ArrayList<W5ObjectMenuItem>());
				}
				ml.get_menuItemList().add(gm);
			}
		}

		ml = null;
		for (Object[] gsfi : mlistSearchFormIds) {
			int gridId = (Integer) gsfi[1];
			ml = mlistMap.get(gridId); // tableMap.get(tf.getTableId());

			if (ml != null) {
				ml.set_searchFormId((Integer) gsfi[0]);
			}
		}

		for (M5List gx : mlists)
			if (gx.getParentListId() != 0) {
				M5List pml = mlistMap.get(gx.getParentListId());
				if (pml != null) {
					if (pml.get_detailMLists() == null)
						pml.set_detailMLists(new ArrayList());
					pml.get_detailMLists().add(gx);
				}
			}

		if(xtype){
			Map<String, Object> r = new HashMap();
			for(Integer key:mlistMap.keySet())
				r.put(projectId+":mlist:"+key, mlistMap.get(key));
			return r;
		}
		
		RMap<Integer, M5List> rmlistMap = redissonClient.getMap(String.format("icb-cache2:%s:mlist", projectId));

		for (M5List gx : mlists) {
			rmlistMap.put(gx.getListId(), gx);
		}
		// rmlistMap.values().iterator().next();
		return null;

	}

	private Map<String, Object>  loadConversions(String projectId) {
		List<W5Conversion> conversions = entityManager
				.createQuery("select f from W5Conversion f where f.projectUuid=?0 order by f.conversionId",
						W5Conversion.class)
				.setParameter(0, projectId).getResultList();
		Map<Integer, W5Conversion> conversionMap = new HashMap(conversions.size() * 4 / 3);
		for (W5Conversion c : conversions)
			conversionMap.put(c.getConversionId(), c);

		List<W5ConversionCol> conversionCols = entityManager.createQuery(
				"select f from W5ConversionCol f where f.projectUuid=?0 order by f.conversionId, f.tabOrder",
				W5ConversionCol.class).setParameter(0, projectId).getResultList();

		W5Conversion c = null;
		for (W5ConversionCol cc : conversionCols) {
			if (c == null || cc.getConversionId() != c.getConversionId())
				c = conversionMap.get(cc.getConversionId()); // tableMap.get(tf.getTableId());

			if (c != null) {
				if (c.get_conversionColList() == null) {
					c.set_conversionColList(new ArrayList<W5ConversionCol>());
					c.set_conversionColMap(new HashMap());
					;
				}
				c.get_conversionColList().add(cc);
				c.get_conversionColMap().put(cc.getConversionColId(), cc);
			}
		}

		if(xtype){
			Map<String, Object> r = new HashMap();
			r.put("conversion", conversionMap);
			return r;
		}
		
		RMap<Integer, W5Conversion> rconversionMap = redissonClient
				.getMap(String.format("icb-cache2:%s:conversion", projectId));

		for (W5Conversion cx : conversions) {
			rconversionMap.put(cx.getConversionId(), cx);
		}
		return null;
	}

	private Map<String, Object>  loadForms(String projectId) {
		List<W5Form> forms = entityManager
				.createQuery("select f from W5Form f where f.projectUuid=?0 order by f.formId", W5Form.class)
				.setParameter(0, projectId).getResultList();
		Map<Integer, W5Form> formMap = new HashMap(forms.size() * 4 / 3);
		for (W5Form f : forms)
			formMap.put(f.getFormId(), f);

		List<W5FormCell> formCells = entityManager
				.createQuery("select f from W5FormCell f where f.projectUuid=?0 order by f.formId, f.tabOrder",
						W5FormCell.class)
				.setParameter(0, projectId).getResultList();
		List<W5FormModule> formModules = entityManager
				.createQuery("select f from W5FormModule f where f.projectUuid=?0 order by f.formId, f.tabOrder",
						W5FormModule.class)
				.setParameter(0, projectId).getResultList();
		List<W5FormHint> formHints = entityManager
				.createQuery("select f from W5FormHint f where f.projectUuid=?0 order by f.formId, f.tabOrder",
						W5FormHint.class)
				.setParameter(0, projectId).getResultList();
		List<W5ObjectToolbarItem> formToolbarItems = entityManager.createQuery(
				"select f from W5ObjectToolbarItem f where f.objectTip=15 AND f.projectUuid=?0 order by f.objectId, f.tabOrder",
				W5ObjectToolbarItem.class).setParameter(0, projectId).getResultList();
		List<W5FormSmsMail> formSmsMails = entityManager.createQuery(
				"select f from W5FormSmsMail f where f.activeFlag=1 AND f.projectUuid=?0 order by f.formId, f.smsMailSentTip, f.tabOrder",
				W5FormSmsMail.class).setParameter(0, projectId).getResultList();
		

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

		f = null;
		for (W5ObjectToolbarItem ft : formToolbarItems) {
			if (f == null || ft.getObjectId() != f.getFormId())
				f = formMap.get(ft.getObjectId()); // tableMap.get(tf.getTableId());

			if (f != null) {
				if (f.get_toolbarItemList() == null) {
					f.set_toolbarItemList(new ArrayList<W5ObjectToolbarItem>());
				}
				f.get_toolbarItemList().add(ft);
			}
		}
		
		f = null;
		for (W5FormSmsMail ft : formSmsMails) {
			if (f == null || ft.getFormId() != f.getFormId())
				f = formMap.get(ft.getFormId()); // tableMap.get(tf.getTableId());

			if (f != null) {
				if (f.get_formSmsMailList() == null) {
					f.set_formSmsMailList(new ArrayList<W5FormSmsMail>());
				}
				f.get_formSmsMailList().add(ft);
			}
		}
		if(xtype){
			Map<String, Object> r = new HashMap();
			for(Integer key:formMap.keySet())
				r.put(projectId+":form:"+key, formMap.get(key));
			return r;
		}
		
		RMap<Integer, W5Form> rformMap = redissonClient.getMap(String.format("icb-cache2:%s:form", projectId));

		for (W5Form fx : forms) {
			rformMap.put(fx.getFormId(), fx);
		}
		return null;

	}

	private Map<String, Object>  loadCards(String projectId) {
		List<W5Card> cards = entityManager
				.createQuery("select f from W5Card f where f.projectUuid=?0 order by f.dataViewId", W5Card.class)
				.setParameter(0, projectId).getResultList();
		Map<Integer, W5Card> cardMap = new HashMap(cards.size() * 4 / 3);
		for (W5Card c : cards)
			cardMap.put(c.getDataViewId(), c);
		List<W5ObjectToolbarItem> cardToolbarItems = entityManager.createQuery(
				"select f from W5ObjectToolbarItem f where f.objectTip=8 AND f.projectUuid=?0 order by f.objectId, f.tabOrder",
				W5ObjectToolbarItem.class).setParameter(0, projectId).getResultList();
		List<W5ObjectMenuItem> cardMenuItems = entityManager.createQuery(
				"select f from W5ObjectMenuItem f where f.objectTip=8 AND f.projectUuid=?0 order by f.objectId, f.tabOrder",
				W5ObjectMenuItem.class).setParameter(0, projectId).getResultList();
		List<Object[]> cardSearchFormsIds = entityManager.createQuery(
				"select f.formId, f.objectId from W5Form f where f.objectTip=8 AND f.projectUuid=?0 order by f.formId, f.tabOrder",
				Object[].class).setParameter(0, projectId).getResultList();

		W5Card c = null;
		for (W5ObjectToolbarItem gt : cardToolbarItems) {
			if (c == null || gt.getObjectId() != c.getDataViewId())
				c = cardMap.get(gt.getObjectId()); // tableMap.get(tf.getTableId());

			if (c != null) {
				if (c.get_toolbarItemList() == null) {
					c.set_toolbarItemList(new ArrayList<W5ObjectToolbarItem>());
				}
				c.get_toolbarItemList().add(gt);
			}
		}

		c = null;
		for (W5ObjectMenuItem gm : cardMenuItems) {
			if (c == null || gm.getObjectId() != c.getDataViewId())
				c = cardMap.get(gm.getObjectId()); // tableMap.get(tf.getTableId());

			if (c != null) {
				if (c.get_menuItemList() == null) {
					c.set_menuItemList(new ArrayList<W5ObjectMenuItem>());
				}
				c.get_menuItemList().add(gm);
			}
		}

		c = null;
		for (Object[] csfi : cardSearchFormsIds) {
			int cardId = (Integer) csfi[1];
			c = cardMap.get(cardId); // tableMap.get(tf.getTableId());

			if (c != null) {
				c.set_searchFormId((Integer) csfi[0]);
			}
		}

		if(xtype){
			Map<String, Object> r = new HashMap();
			for(Integer key:cardMap.keySet())
				r.put(projectId+":card:"+key, cardMap.get(key));
			return r;
		}
		
		RMap<Integer, W5Card> rcardMap = redissonClient.getMap(String.format("icb-cache2:%s:card", projectId));

		for (W5Card cx : cards) {
			rcardMap.put(cx.getDataViewId(), cx);
		}
		
		return null;

	}

	private Map<String, Object>  loadGlobalFuncs(String projectId) {
		List<W5GlobalFunc> funcs = entityManager
				.createQuery("select f from W5GlobalFunc f where f.projectUuid=?0 order by f.dbFuncId",
						W5GlobalFunc.class)
				.setParameter(0, projectId).getResultList();
		Map<Integer, W5GlobalFunc> funcMap = new HashMap(funcs.size() * 4 / 3);
		for (W5GlobalFunc c : funcs)
			funcMap.put(c.getDbFuncId(), c);

		List<W5GlobalFuncParam> funcParams = entityManager
				.createQuery("select f from W5GlobalFuncParam f where f.projectUuid=?0 order by f.dbFuncId, f.tabOrder",
						W5GlobalFuncParam.class)
				.setParameter(0, projectId).getResultList();

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

		if(xtype){
			Map<String, Object> r = new HashMap();
			for(Integer key:funcMap.keySet())
				r.put(projectId+":func:"+key, funcMap.get(key));
			return r;
		}
		
		RMap<Integer, W5GlobalFunc> rfuncMap = redissonClient.getMap(String.format("icb-cache2:%s:func", projectId));

		for (W5GlobalFunc cx : funcs) {
			rfuncMap.put(cx.getDbFuncId(), cx);
		}
		return null;
	}

	private Map<String, Object>  loadWsClients(String projectId) {
		List<W5Ws> wss = entityManager
				.createQuery("select f from W5Ws f where f.projectUuid=?0 order by f.wsId", W5Ws.class)
				.setParameter(0, projectId).getResultList();
		Map<Integer, W5Ws> wsMap = new HashMap(wss.size() * 4 / 3);
		for (W5Ws c : wss)
			wsMap.put(c.getWsId(), c);

		List<W5WsMethod> wsMethods = entityManager
				.createQuery("select f from W5WsMethod f where f.projectUuid=?0 order by f.wsId, f.wsMethodId",
						W5WsMethod.class)
				.setParameter(0, projectId).getResultList();
		Map<Integer, W5WsMethod> wsMethodMap = new HashMap(wsMethods.size() * 4 / 3);
		for (W5WsMethod c : wsMethods)
			wsMethodMap.put(c.getWsMethodId(), c);

		List<W5WsMethodParam> wsMethodParams = entityManager
				.createQuery("select f from W5WsMethodParam f where f.projectUuid=?0 order by f.wsMethodId, f.tabOrder",
						W5WsMethodParam.class)
				.setParameter(0, projectId).getResultList();

		W5Ws ws = null;
		for (W5WsMethod wsm : wsMethods) {
			if (ws == null || wsm.getWsId() != ws.getWsId())
				ws = wsMap.get(wsm.getWsId()); // tableMap.get(tf.getTableId());

			if (ws != null) {
				if (ws.get_methods() == null) {
					ws.set_methods(new ArrayList<W5WsMethod>());
				}
				ws.get_methods().add(wsm);
			}
		}
		W5WsMethod wsm = null;
		for (W5WsMethodParam wsmp : wsMethodParams) {
			if (wsm == null || wsm.getWsMethodId() != wsmp.getWsMethodId())
				wsm = wsMethodMap.get(wsmp.getWsMethodId()); // tableMap.get(tf.getTableId());

			if (wsm != null) {
				if (wsm.get_params() == null) {
					wsm.set_params(new ArrayList<W5WsMethodParam>());
					wsm.set_paramMap(new HashMap());
				}
				wsm.get_params().add(wsmp);
				wsm.get_paramMap().put(wsmp.getWsMethodParamId(), wsmp);
			}
		}

		if(xtype){
			Map<String, Object> r = new HashMap();
			r.put("ws", wsMap);
			return r;
		}
		
		RMap<Integer, W5Ws> rwsMap = redissonClient.getMap(String.format("icb-cache2:%s:ws", projectId));

		for (W5Ws cx : wss) {
			rwsMap.put(cx.getWsId(), cx);
		}
		return null;

	}

	@EventListener(ApplicationReadyEvent.class)
	public void work() {
		System.out.println("Start Loading");
		long mstartTime = System.currentTimeMillis();
		if (true) {
			List<W5Project> projects = entityManager.createQuery("select f from W5Project f", W5Project.class)
					.getResultList();
			Map<String, Object> projectMap = new HashMap();
			Map m = null;
			for(W5Project p:projects){
				System.out.println("Loading " + p.getDsc() + " : " + p.getProjectUuid());
				long startTime = System.currentTimeMillis();
				Map<String, Map> nodeMap = new HashMap();
				m = loadLookups(p.getProjectUuid());if(xtype)nodeMap.putAll(m);
				m = loadTables(p.getProjectUuid());if(xtype)nodeMap.putAll(m);
				m = loadComponents(p.getProjectUuid());if(xtype)nodeMap.putAll(m);
				m = loadWsClients(p.getProjectUuid());if(xtype)nodeMap.putAll(m);
				m = loadConversions(p.getProjectUuid());if(xtype)nodeMap.putAll(m);
				if(xtype)projectMap.put(p.getProjectUuid(), nodeMap);

				Map<String, Object> objMap = new HashMap();
				m = loadForms(p.getProjectUuid());if(xtype)objMap.putAll(m);
				m = loadQueries(p.getProjectUuid());if(xtype)objMap.putAll(m);
				m = loadGrids(p.getProjectUuid());if(xtype)objMap.putAll(m);
				m = loadCards(p.getProjectUuid());if(xtype)objMap.putAll(m);
				m = loadGlobalFuncs(p.getProjectUuid());if(xtype)objMap.putAll(m);
				m = loadPages(p.getProjectUuid());if(xtype)objMap.putAll(m);
				m = loadMList(p.getProjectUuid());if(xtype)objMap.putAll(m);
				if(xtype)projectMap.putAll(objMap);
				System.out.println("done in " + (System.currentTimeMillis() - startTime) + "ms");
			}
			
			if(xtype){
				redissonClient.getMap("icb-cache5").putAllAsync(projectMap);
			}

		} else {
			loadLookups(projectId);
			loadTables(projectId);
			loadForms(projectId);
			loadQueries(projectId);
			loadGrids(projectId);
			loadCards(projectId);
			loadGlobalFuncs(projectId);
			loadConversions(projectId);
			loadPages(projectId);
			loadComponents(projectId);
			loadMList(projectId);
			loadWsClients(projectId);
		}
		System.out.println("Finished Loading in " +(System.currentTimeMillis() - mstartTime) + "ms");

		/*
		 * List<W5Form> forms = entityManager.createQuery(
		 * "select f from W5Form f where f.projectUuid=?0",
		 * W5Form.class).setParameter(0, projectId).getResultList();
		 * RMap<String, RMap<Integer, W5Form>> formsMap =
		 * redissonClient.getMap("allForms"); for (W5Form result : forms) {
		 * RMap<Integer, W5Form> projectFormsMap =
		 * formsMap.get(result.getProjectUuid()); if (projectFormsMap == null) {
		 * projectFormsMap =
		 * redissonClient.getMap(String.format("project:%s:forms",
		 * result.getProjectUuid())); formsMap.put(result.getProjectUuid(),
		 * projectFormsMap); } projectFormsMap.put(result.getFormId(), result);
		 * } formsMap.values().iterator().next().values();
		 */
	}
}
