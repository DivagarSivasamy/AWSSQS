package com.clarivate.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.model.SendMessageResult;
import com.clarivate.client.ClarivateAwsConfig;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AwsclientService {

	@Autowired
	private ClarivateAwsConfig clarivateAwsConfig;
	
	private int i=0;
	@Scheduled(fixedRate = 1000)
	private void sendmessage () {
		SendMessageResult result=  clarivateAwsConfig.getBasicsqsClient().sendMessage(clarivateAwsConfig.getAwsUrl(),"Hello"+i);
	log.info("message published "+ result.getMessageId());
		i++;
	}
}
