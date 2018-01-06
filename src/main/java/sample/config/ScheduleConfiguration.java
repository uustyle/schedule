package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

import sample.MyScheduleTask;

@Configuration
@PropertySource("classpath:jsonMake3.properties")
@EnableScheduling
public class ScheduleConfiguration {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public MyScheduleTask myScheduledTask() {
		return new MyScheduleTask();
	}
}
