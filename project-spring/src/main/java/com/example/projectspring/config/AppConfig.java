package com.example.projectspring.config;

import com.example.projectspring.services.loggers.Logger;
import com.example.projectspring.services.loggers.LoggerImplFile;
import com.example.projectspring.services.loggers.LoggerImplStd;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "conf")
@Configuration
public class AppConfig {

    private String bean;

    @Bean
    public Logger logger() {
        if (bean.equals("File")) {
            return new LoggerImplFile();
        }

        return new LoggerImplStd();
    }

    private LoggerConfig loggerConfig = new LoggerConfig();

    public String getBean() {
        return bean;
    }

    public void setBean(String bean) {
        this.bean = bean;
    }

    public class LoggerConfig {
        private String level;

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }
    }

    public LoggerConfig getLoggerConfig() {
        return loggerConfig;
    }

}
