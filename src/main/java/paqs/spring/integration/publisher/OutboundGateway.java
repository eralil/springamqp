package paqs.spring.integration.publisher;

import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "amqpOutboundChannel")
public interface OutboundGateway {
	void sendToRabbit(byte[] message);
}
