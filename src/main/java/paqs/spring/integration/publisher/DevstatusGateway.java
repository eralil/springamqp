package paqs.spring.integration.publisher;

import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "devStatusChannel")
public interface DevstatusGateway {
	void sendToRabbit(byte[] message);
}
