package com.m4th.merlot.flickr;

import java.io.IOException;
import java.net.URL;

import com.googlecode.flickrjandroid.Flickr;
import com.googlecode.flickrjandroid.FlickrException;
import com.googlecode.flickrjandroid.auth.Permission;
import com.googlecode.flickrjandroid.oauth.OAuth;
import com.googlecode.flickrjandroid.oauth.OAuthInterface;
import com.googlecode.flickrjandroid.oauth.OAuthToken;
import com.googlecode.flickrjandroid.people.User;

/**
 * shark
 * Key: e896dba1900a2994fad16cc18cb2cec2
 * Secret: c62bdf4ba24e4c7f
 * 
 * http://www.flickr.com/people/21040560@N03/
 * 
 * @author kaxu
 *
 */
public class Authenticator {
	static final String api_key= "e896dba1900a2994fad16cc18cb2cec2";
	static final String api_secret= "c62bdf4ba24e4c7f";
	static final String appcallbackurl = "flickrj-android-sample-oauth://oauth";

	private OAuthToken requestToken=null;
	private URL oauthUrl;
	
	private void initialOauth() throws IOException, FlickrException {
		String callBackUrl = appcallbackurl;
		Flickr f = new Flickr(api_key, api_secret);
		//get a request token from Flickr
		requestToken = f.getOAuthInterface().getRequestToken(callBackUrl);
		//you should save the request token and token secret to a preference store for later use.
		//saveToken(oauthToken);

		String oauthVerifier=""; //TODO
		//OAuth accessAuth = f.getOAuthInterface().getAccessToken(requestToken.getOauthToken(), requestToken.getOauthTokenSecret(), oauthVerifier);
		
		//build the Authentication URL with the required permission
		oauthUrl = f.getOAuthInterface().buildAuthenticationUrl(Permission.READ, requestToken);
		//oauthUrl.getQuery();

		//redirect user to the genreated URL.
		// redirect(oauthUrl);

		//getAccessToken(oauthUrl);
	}
	
	void dump(OAuth result) {        
		User user = result.getUser();
		user.getId();
		user.getUsername();
		
		OAuthToken accessToken=result.getToken();
		accessToken.getOauthToken();
		accessToken.getOauthTokenSecret();
	}

	public OAuthToken getAccessToken() throws IOException, FlickrException {
		OAuthToken accessToken = null;
		
		initialOauth();

		//todo provide user/password  
		
		
		String query = oauthUrl.getQuery();
		//the query format should be oauthToken=XXX&oauthVerifier=XXX
		String[] data = query.split("&");
		if (data != null && data.length == 2) {
			String oauthToken = data[0].substring(data[0].indexOf("=") + 1);
			String oauthVerifier = data[1].substring(data[1].indexOf("=") + 1);

			String requrestTokenSecret = requestToken.getOauthTokenSecret();
			if (requrestTokenSecret != null) {
				Flickr f = new Flickr(api_key, api_secret);
				OAuthInterface oauthApi = f.getOAuthInterface();


				//exchange for an AccessToken from Flickr
				//OAuth oauth = oauthApi.getAccessToken(oauthToken, requrestTokenSecret,oauthVerifier);
				//User user = oauth.getUser();
				//accessToken = oauth.getToken();
				
				//saveFlickrAuthToken(oauth);
			}
		}
		return accessToken;
	}
}
