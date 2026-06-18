package org.scoula.carrotmarket.config;
// HikariCP 기반 DB 설정

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class RootConfig {
    // application.properties에서 MySQL 접속 정보를 읽어옴
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    // db.properties에서 Hikari 설정값 읽어옴
    // 풀에 최대 몇 개까지 연결을 만들어둘지
    @Value("${hikari.maximumPoolSize:10}")
    private int maximumPoolSize;

    // 평소에 미리 대기시켜둘 최소 연결 개수
    @Value("${hikari.minimumIdle:2}")
    private int minimumIdle;

    // 연결 요청 후 이 시간안에 못 받으면 타임아웃
    @Value("${hikari.connectionTimeout:30000}")
    private long connectionTimeout;

    // 위에서 읽은 값들로 DB 빈을 하나 만들어서 등록
    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setMaximumPoolSize(maximumPoolSize);
        config.setMinimumIdle(minimumIdle);
        config.setConnectionTimeout(connectionTimeout);
        config.setPoolName("ccarrot-hikari-pool");
        return new HikariDataSource(config);
    }
}
