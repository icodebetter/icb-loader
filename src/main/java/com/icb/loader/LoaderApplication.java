package com.icb.loader;

import com.icb.loader.domain.db.W5Form;
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
import java.util.List;

@SpringBootApplication
public class LoaderApplication {

	@Bean
	public RedissonClient redisson() {
		Config config = new Config();
		config.useSingleServer().setAddress(String.format("redis://%s:%s", "localhost", 6379));
		return Redisson.create(config);
	}

	public static void main(String[] args) {
		SpringApplication.run(LoaderApplication.class, args);
	}

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private RedissonClient redissonClient;

	private RMap<String, RMap<Integer, W5Form>> formsMap;

	@EventListener(ApplicationReadyEvent.class)
	public void work() {
		List<W5Form> results = entityManager.createQuery("select f from W5Form f", W5Form.class).getResultList();
		formsMap = redissonClient.getMap("allForms");
		for (W5Form result : results) {
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

