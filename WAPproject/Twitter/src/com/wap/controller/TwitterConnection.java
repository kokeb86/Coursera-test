package com.wap.controller;

import java.util.Map;

import twitter4j.*;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConnection {
	private static final String CONSUMER_KEY		= "uaKSIbP0pakyJMwuaBESstdfn";
	private static final String CONSUMER_SECRET 	= "6AFjGXgIk9yEONI6eeiDkln23ouuKXfKzzD4SghOhIk0I7G6Kb";

	public static OAuth2Token getOAuth2Token()
	{
		OAuth2Token token = null;
		ConfigurationBuilder cb;

		cb = new ConfigurationBuilder();
		cb.setApplicationOnlyAuthEnabled(true);

		cb.setOAuthConsumerKey(CONSUMER_KEY).setOAuthConsumerSecret(CONSUMER_SECRET);

		try
		{
			token = new TwitterFactory(cb.build()).getInstance().getOAuth2Token();
		}
		catch (Exception e)
		{
			System.out.println("Could not get OAuth2 token");
			e.printStackTrace();
			System.exit(0);
		}

		return token;
	}
	
	public static Twitter getInstance() {

		OAuth2Token token;

		token = getOAuth2Token();

		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setApplicationOnlyAuthEnabled(true);
		cb.setOAuthConsumerKey(CONSUMER_KEY);
		cb.setOAuthConsumerSecret(CONSUMER_SECRET);
		cb.setOAuth2TokenType(token.getTokenType());
		cb.setOAuth2AccessToken(token.getAccessToken());
		Twitter twitter = new TwitterFactory(cb.build()).getInstance();

		Map<String, RateLimitStatus> rateLimitStatus;
		try {
			rateLimitStatus = twitter.getRateLimitStatus("search");
			RateLimitStatus searchTweetsRateLimit = rateLimitStatus.get("/search/tweets");
			
			System.out.printf("You have %d calls remaining out of %d, Limit resets in %d seconds\n",
					  searchTweetsRateLimit.getRemaining(),
					  searchTweetsRateLimit.getLimit(),
					  searchTweetsRateLimit.getSecondsUntilReset());
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return twitter;
    }
}
