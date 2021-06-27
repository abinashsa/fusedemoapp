package com.redhat.fuse.boosters.rest.http;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbRoute  extends RouteBuilder{

	@Autowired
	TweetRepository repo;
	@Override
	public void configure() throws Exception {
		from("direct:dbroute")
		.log(LoggingLevel.INFO, "DbRoute: Received at DbRoute")
		.process(exchange ->{
			Tweet t = (Tweet) exchange.getIn().getBody();
			repo.save(t);
		})
		.log(LoggingLevel.INFO, "DbRoute: Persisted to DB")
		.to("log:DbRoute");
	}
}
