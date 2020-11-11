package com.board.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
//스프링은 @Configuration이 지정된 클래스를 자바 기반의 설정 파일로 인식합니다.
@PropertySource("classpath:/application.properties")
//해당 클래스에서 참조할 properties 파일의 위치를 지정합니다.
public class DBConfiguration {
	
	@Autowired
	//빈(Bean)으로 등록된 인스턴스(이하 객체)를 클래스에 주입하는 데 사용합니다
	private ApplicationContext applicationContext;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
		//히카리CP 객체를 생성합니다.
		//히카리CP는 커넥션 풀(Connection Pool) 라이브러리 중 하나인데요,
	}
	
	@Bean
	public DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/**/*Mapper.xml"));
		//해당 메서드는 getResources 메서드의 인자로 지정된 
		//패턴에 포함되는 XML Mapper를 인식하도록 하는 역할
		factoryBean.setTypeAliasesPackage("com.board.domain");
		//BoardMapper XML에서 parameterType과 resultType은
		//클래스의 풀 패키지 경로가 포함되어야 하지만
	    //해당 메서드를 사용해서 풀 패키지 경로를 생략할 수 있습니다.
		factoryBean.setConfiguration(mybatisConfg());
		//application.properties에서 mybatis.configuration으로 시작하는
		//모든 설정을 읽어 들여 빈(Bean)으로 등록합니다.
		
		//(setConfiguration) = 51~55번 라인에 추가된 마이바티스 설정과 관련된 빈(Bean)을 설정 파일로 지정
		return factoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	public org.apache.ibatis.session.Configuration mybatisConfg() {
		return new org.apache.ibatis.session.Configuration();
	}
}
















