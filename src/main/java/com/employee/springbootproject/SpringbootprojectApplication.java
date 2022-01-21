package com.employee.springbootproject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.config.CacheConfiguration;

@Slf4j
@EnableCaching
@SpringBootApplication

public class SpringbootprojectApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringbootprojectApplication.class, args);
	}
}
