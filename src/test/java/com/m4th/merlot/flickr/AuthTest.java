package com.m4th.merlot.flickr;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.googlecode.flickrjandroid.FlickrException;
import com.googlecode.flickrjandroid.oauth.OAuthToken;
import com.m4th.merlot.flickr.Authenticator;

public class AuthTest {
	@BeforeClass
	static public void beforeTestClass()   {
	}

	@AfterClass
	static public void afterTestClass() {
	}



	@Before
	public void beforeRunTestCase()  {
	}

	@After
	public void aferRunTestCase() {
	}

	@Test
	public void getMessageTest() throws IOException, FlickrException {
    	Authenticator oauth= new Authenticator();
    	OAuthToken accessToken = oauth.getAccessToken();
        assertTrue( accessToken==null );
	}
	
}
