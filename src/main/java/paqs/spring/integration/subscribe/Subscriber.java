package paqs.spring.integration.subscribe;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import paqs.spring.integration.publisher.DevstatusGateway;

@Component

public class Subscriber implements MessageHandler {

	@Autowired
	DevstatusGateway gateway;

	@Override
	@ServiceActivator(inputChannel = "amqpInputChannel")
	public void handleMessage(Message<byte[]> message) throws MessagingException {

		String msg = new String(message.getPayload());
		System.out.println("Input message : " + msg);
		System.out.println(message.getHeaders());
		if (message.getHeaders().get(AmqpHeaders.RECEIVED_ROUTING_KEY).equals("devdata")) {
			try {
				gateway.sendToRabbit(new StringBuilder().append("{\"name\":").append("\"").append(msg).append("\"}")
						.toString().getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
