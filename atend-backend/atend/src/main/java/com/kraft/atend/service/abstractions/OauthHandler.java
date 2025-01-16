package com.kraft.atend.service.abstractions;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.*;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;

@Service
public abstract class OauthHandler {

	@Value("${google.client.id}")
	private String clientId;
	private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

	public GoogleIdToken.Payload getPayloadFromToken(String token) throws GeneralSecurityException, IOException {
		var verifier = new GoogleIdTokenVerifier.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY)
				.setAudience(Collections.singletonList(clientId)).build();
		var result = verifier.verify(token);
		return result.getPayload();
	}
}
