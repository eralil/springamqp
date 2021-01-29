package paqs.spring.integration.subscribe;

import org.springframework.messaging.Message;

public interface MessageHandler {
	public void handleMessage(Message<byte[]> message) ;
}
