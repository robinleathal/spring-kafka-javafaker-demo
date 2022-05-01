package np.com.rabin.kafkaspring.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;

import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

public class KafkaConsumerConfig {
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {

        return new DefaultKafkaConsumerFactory<>(consumerProperties());
    }
    @Bean
    public Map<String, Object> consumerProperties() {
        return Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                GROUP_ID_CONFIG, "sb-kafka",
                ENABLE_AUTO_COMMIT_CONFIG, false,
                SESSION_TIMEOUT_MS_CONFIG, 15000,
                KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class
        );
    }
}
