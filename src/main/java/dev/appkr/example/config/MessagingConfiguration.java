package dev.appkr.example.config;

import dev.appkr.example.stream.ProducerChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(value = {ProducerChannel.class})
public class MessagingConfiguration {
}