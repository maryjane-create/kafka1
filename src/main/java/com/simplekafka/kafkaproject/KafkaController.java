package com.simplekafka.kafkaproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    private  KafkaTemplate<String, Model>kafkaTemplate;

    @Autowired
    public KafkaController(KafkaTemplate<String, Model> kafkaTemplate){
    this.kafkaTemplate=kafkaTemplate;
    }


    @PostMapping
    public  void  post(@RequestBody Model model){
        kafkaTemplate.send("my topic", model);
    }
}
