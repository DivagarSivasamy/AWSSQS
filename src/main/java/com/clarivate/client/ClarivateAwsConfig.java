package com.clarivate.client;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

import lombok.Getter;

@Component
@Scope("singleton")
public class ClarivateAwsConfig {

	@Value("${cloud.aws.region.static}")
	@Getter
	private String region;
	@Value("${cloud.aws.end-point.uri}")
	@Getter
	private String awsUrl;
	@Getter
	private AmazonSQS basicsqsClient;
	@Value("${cloud.aws.credentials.access-key}")
	private String awsAccessKey;

	@Value("${cloud.aws.credentials.secret-key}")
	private String awsSecretKey;
	@PostConstruct
	private void init() {
		BasicAWSCredentials awsCreds = new BasicAWSCredentials("awsAccessKey", "awsSecretKey");

		
		
		basicsqsClient = AmazonSQSClientBuilder.standard().withRegion(region).withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
	}
	
	
}
