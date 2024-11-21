package com.springboot.springintegrationnumberfilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;

/**
 * 흐름을 정의하는 설정
 * IntegrationFlow(메시지의 시작점, 분리, 필터링, 핸들링, 전달 등의 흐름)를 정의
 * 3의 배수일 경우 필터링해서 3의 배수일 경우 채널에 전달
 * 나머지가 1일 경우 필터링해서 나머지가 1일 경우 채널에 전달
 * 나머지가 2일 경우 필터링해서 나머지가 2일 경우 채널에 전달
 */
@Configuration
public class IntegrationFlowsConfig {

	@Bean
	public IntegrationFlow multipleOfThreeFlow(SubflowsConfiguration config) {
		return flow -> flow.split()
				.<Integer>filter(config::isMultipleOfThree)
				.channel(config.multipleOfThreeChannel());
	}

	@Bean
	public IntegrationFlow remainderIsOneFlow(SubflowsConfiguration config) {
		return flow -> flow.split()
				.<Integer>filter(config::isRemainderOne)
				.channel(config.remainderIsOneChannel());
	}

	@Bean
	public IntegrationFlow remainderIsTwoFlow(SubflowsConfiguration config) {
		return flow -> flow.split()
				.<Integer>filter(config::isRemainderTwo)
				.channel(config.remainderIsTwoChannel());
	}
}