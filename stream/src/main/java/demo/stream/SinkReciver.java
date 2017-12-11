package demo.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

/**
 * Created by Administrator on 2017/12/10 0010.
 */
@EnableBinding(Sink.class)
public class SinkReciver {
    Logger log = LoggerFactory.getLogger(SinkReciver.class);
    @StreamListener(Sink.INPUT)
    public void process(Message<?> message) {
        log.info(message.getPayload().toString());
        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        if (acknowledgment != null) {
            log.info("Acknowledgment provided");
            acknowledgment.acknowledge();
        }
    }
}
