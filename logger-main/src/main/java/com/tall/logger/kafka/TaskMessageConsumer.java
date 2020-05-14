package com.tall.logger.kafka;

import com.alibaba.fastjson.JSON;
import com.xinyan.qz.logger.service.impl.TaskStatusServiceImpl;
import com.xinyan.qz.model.bean.repository.log.LogMongoObject;
import com.xinyan.qz.model.bean.repository.task.status.TaskStatusDetail;
import com.xinyan.qz.util.common.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.xinyan.qz.logger.util.BeanMapperUtil.objConvert;

/**
 * kafka消息消费
 * @author lituo
 * @date 2019/8/9
 */
@Component
@Slf4j
public class TaskMessageConsumer {

    @Autowired
    private TaskStatusServiceImpl taskStatusServiceImpl;

    @KafkaListener(topics = "${kafka-topic.task-status}")
    public void consumeTaskStatus(ConsumerRecord<?,	String> record)	{
        Optional<String> kafkaMessage =	Optional.ofNullable(record.value());
        if(kafkaMessage.isPresent()){
            String taskStatus = kafkaMessage.get();
            log.info("保存和更新任务状态明细：{}", taskStatus);
            taskStatusServiceImpl.shardingSave(taskStatus);
        }
    }

}
