package paqs.spring.integration.publisher;

import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "devDataChannel")
public interface OutboundGateway {
	void sendToRabbit(byte[] message);
}
