package com.springboot.springintegrationnumberfilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;

/**
 * 채널을 정의하는 설정
 * Queue채널을 정의(채널은 메시지를 수신하는 객체)
 * 3의 배수일 경우 채널
 * 나머지가 1일 경우 채널
 * 나머지가 2일 경우 채널
 */
@EnableIntegration
@IntegrationComponentScan
@Configuration
public class SubflowsConfiguration {

	@Bean
	public QueueChannel multipleOfThreeChannel() {
		return new QueueChannel();
	}

	@Bean
	public QueueChannel remainderIsOneChannel() {
		return new QueueChannel();
	}

	@Bean
	public QueueChannel remainderIsTwoChannel() {
		return new QueueChannel();
	}

	boolean isMultipleOfThree(Integer number) {
		return number % 3 == 0;
	}

	boolean isRemainderOne(Integer number) {
		return number % 3 == 1;
	}

	boolean isRemainderTwo(Integer number) {
		return number % 3 == 2;
	}
}
