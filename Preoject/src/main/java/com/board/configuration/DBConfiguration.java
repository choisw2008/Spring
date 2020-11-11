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
//�������� @Configuration�� ������ Ŭ������ �ڹ� ����� ���� ���Ϸ� �ν��մϴ�.
@PropertySource("classpath:/application.properties")
//�ش� Ŭ�������� ������ properties ������ ��ġ�� �����մϴ�.
public class DBConfiguration {
	
	@Autowired
	//��(Bean)���� ��ϵ� �ν��Ͻ�(���� ��ü)�� Ŭ������ �����ϴ� �� ����մϴ�
	private ApplicationContext applicationContext;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
		//��ī��CP ��ü�� �����մϴ�.
		//��ī��CP�� Ŀ�ؼ� Ǯ(Connection Pool) ���̺귯�� �� �ϳ��ε���,
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
		//�ش� �޼���� getResources �޼����� ���ڷ� ������ 
		//���Ͽ� ���ԵǴ� XML Mapper�� �ν��ϵ��� �ϴ� ����
		factoryBean.setTypeAliasesPackage("com.board.domain");
		//BoardMapper XML���� parameterType�� resultType��
		//Ŭ������ Ǯ ��Ű�� ��ΰ� ���ԵǾ�� ������
	    //�ش� �޼��带 ����ؼ� Ǯ ��Ű�� ��θ� ������ �� �ֽ��ϴ�.
		factoryBean.setConfiguration(mybatisConfg());
		//application.properties���� mybatis.configuration���� �����ϴ�
		//��� ������ �о� �鿩 ��(Bean)���� ����մϴ�.
		
		//(setConfiguration) = 51~55�� ���ο� �߰��� ���̹�Ƽ�� ������ ���õ� ��(Bean)�� ���� ���Ϸ� ����
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
















