package np.com.rabin.kafkaspring.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @KafkaListener(topics = {"hobbit"}, groupId = "sb-kafka")
    public void consume(String qoute) {
        System.out.println("received qoute = "+qoute);
    }
}
