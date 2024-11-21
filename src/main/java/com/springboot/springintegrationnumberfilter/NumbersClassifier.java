package com.springboot.springintegrationnumberfilter;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import java.util.Collection;


/**
 * (외부에서는 메시지 API를 호출하는 대신, 일반 메서드를 호출하는 것처럼 추상화된 인터페이스)
 * 채널에 메시지가 들어갈 플로우를 지정하여 맵핑하는 인터페이스
 * 즉, 사용자가 어떤 비즈니스 로직(플로우)을 실행하고 싶은지 결정할 수 있는 진입점 역할
 */
@MessagingGateway
public interface NumbersClassifier {

	@Gateway(requestChannel = "multipleOfThreeFlow.input")
	void multipleOfThree(Collection<Integer> numbers);

	@Gateway(requestChannel = "remainderIsOneFlow.input")
	void remainderIsOne(Collection<Integer> numbers);

	@Gateway(requestChannel = "remainderIsTwoFlow.input")
	void remainderIsTwo(Collection<Integer> numbers);
}
