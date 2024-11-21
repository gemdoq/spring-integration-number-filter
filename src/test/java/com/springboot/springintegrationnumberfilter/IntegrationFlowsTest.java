package com.springboot.springintegrationnumberfilter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {SubflowsConfiguration.class, IntegrationFlowsConfig.class})
public class IntegrationFlowsTest {

	@Autowired
	private QueueChannel multipleOfThreeChannel;

	@Autowired
	private QueueChannel remainderIsOneChannel;

	@Autowired
	private QueueChannel remainderIsTwoChannel;

	@Autowired
	private NumbersClassifier numbersClassifier;

	@Test
	public void whenSendMessagesToMultipleOfThreeFlow_thenOutputMultiplesOfThree() {
		numbersClassifier.multipleOfThree(Arrays.asList(1, 2, 3, 4, 5, 6));

		Message<?> message = multipleOfThreeChannel.receive(0);
		assertEquals(3, message.getPayload());
		message = multipleOfThreeChannel.receive(0);
		assertEquals(6, message.getPayload());
		message = multipleOfThreeChannel.receive(0);
		assertNull(message);
	}

	@Test
	public void whenSendMessagesToRemainderIsOneFlow_thenOutputCorrect() {
		numbersClassifier.remainderIsOne(Arrays.asList(1, 2, 3, 4, 5, 6));

		Message<?> message = remainderIsOneChannel.receive(0);
		assertEquals(1, message.getPayload());
		message = remainderIsOneChannel.receive(0);
		assertEquals(4, message.getPayload());
		message = remainderIsOneChannel.receive(0);
		assertNull(message);
	}

	@Test
	public void whenSendMessagesToRemainderIsTwoFlow_thenOutputCorrect() {
		numbersClassifier.remainderIsTwo(Arrays.asList(1, 2, 3, 4, 5, 6));

		Message<?> message = remainderIsTwoChannel.receive(0);
		assertEquals(2, message.getPayload());
		message = remainderIsTwoChannel.receive(0);
		assertEquals(5, message.getPayload());
		message = remainderIsTwoChannel.receive(0);
		assertNull(message);
	}
}
