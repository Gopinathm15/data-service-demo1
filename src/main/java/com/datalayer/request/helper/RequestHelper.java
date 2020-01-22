package com.datalayer.request.helper;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RequestHelper {

	public static final Logger LOGGER = LoggerFactory.getLogger(RequestHelper.class);

	public String getRequestBody(HttpServletRequest request) {
		final StringBuilder builder = new StringBuilder();
		try (BufferedReader reader = request.getReader()) {
			if (reader == null) {
				LOGGER.debug("Request body could not be read because it's empty.");
				return null;
			}
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			return builder.toString();
		} catch (final Exception e) {
			LOGGER.trace("Could not obtain the saml request body from the http request", e);
			return null;
		}
	}

}
