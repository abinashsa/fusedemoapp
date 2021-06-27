package com.redhat.fuse.boosters.rest.http;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import twitter4j.Status;

public class TweetInfoProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Status bodyIn = (Status) exchange.getIn().getBody();
		
		Tweet tweetEntity = new Tweet();
		
		tweetEntity.setTweetId(bodyIn.getId());
		tweetEntity.setText(bodyIn.getText());
		
		if (bodyIn.getUser() != null) {
			tweetEntity.setUsername(bodyIn.getUser().getName());
			tweetEntity.setLanguage(bodyIn.getUser().getLang());
			tweetEntity.setLocation(bodyIn.getUser().getLocation());
		}

		tweetEntity.setFavouriteCount(bodyIn.getFavoriteCount());
		tweetEntity.setCreationDate(bodyIn.getCreatedAt());
		
		exchange.getIn().setBody(tweetEntity);
	}

}