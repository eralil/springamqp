package paqs.spring.integration.publisher;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PubSub {

	@Autowired
	private OutboundGateway gateway;

	@Test
	public void pubToServer() {

		List<String> msg = new ArrayList<>(
				Arrays.asList("mathew", "rajan", "is", "sick", "of", "waiting", "in", "queueue"));
		msg.stream()//.map(e -> new StringBuilder().append("\"name\":").append("\"").append(e).append("\"").toString())
				.forEach(e -> {
					try {
						System.out.println("sending data packet " + e);

						gateway.sendToRabbit(e.getBytes("UTF-8"));
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});

	}
}
