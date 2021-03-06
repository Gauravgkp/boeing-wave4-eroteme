package com.stackroute.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    //Search Service
    @Value("${jsa.rabbitmq.queue}")
    private String queueName;

    @Value("${jsa.rabbitmq.exchange}")
    private String exchange;

    @Value("${jsa.rabbitmq.routingkey}")
    private String routingKey;

    //Notification service
    @Value("${jsd.rabbitmq.queue}")
    private String queueName1;

    @Value("${jsd.rabbitmq.exchange}")
    private String exchange1;

    @Value("${jsd.rabbitmq.routingkey}")
    private String routingKey1;

    //Recommendation Command Service
    @Value("${jse.rabbitmq.queue}")
    private String queueName2;

    @Value("${jse.rabbitmq.exchange}")
    private String exchange2;

    @Value("${jse.rabbitmq.routingkey}")
    private String routingKey2;

    //Recommendation query service
    @Value("${jsf.rabbitmq.queue}")
    private String queueName3;

    @Value("${jsf.rabbitmq.exchange}")
    private String exchange3;

    @Value("${jsf.rabbitmq.routingkey}")
    private String routingKey3;

    @Bean
    Queue queue1() {
        return new Queue(queueName1, false);
    }

    @Bean
    DirectExchange exchange1() {
        return new DirectExchange(exchange1);
    }

    @Bean
    Binding binding1(Queue queue1, DirectExchange exchange1) {
        return BindingBuilder.bind(queue1).to(exchange1).with(routingKey1);
    }

    @Bean
    Queue queue2() {
        return new Queue(queueName2, false);
    }

    @Bean
    DirectExchange exchange2() {
        return new DirectExchange(exchange2);
    }

    @Bean
    Binding binding2(Queue queue2, DirectExchange exchange2) {
        return BindingBuilder.bind(queue2).to(exchange2).with(routingKey2);
    }

    @Bean
    Queue queue3() {
        return new Queue(queueName3, false);
    }

    @Bean
    DirectExchange exchange3() {
        return new DirectExchange(exchange3);
    }

    @Bean
    Binding binding3(Queue queue3, DirectExchange exchange3) {
        return BindingBuilder.bind(queue3).to(exchange3).with(routingKey3);
    }

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}