package com.datalayer.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.datalayer.response.CommonResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author gopinath
 */
@RestController
public class AuthorizeController {
	public static final Logger LOGGER = LoggerFactory.getLogger(AuthorizeController.class);

	@RequestMapping(value = "/authorize", method = RequestMethod.GET)
	public ResponseEntity<?> generateBearerToken(HttpServletRequest request) {
		String authorizeKey = request.getHeader("X-Authorization");
		String bearerToken = "";
		if (StringUtils.isNotEmpty(authorizeKey)) {
			LOGGER.debug("X-Authorization Key Present in Header");
			try {
				String host = request.getRemoteHost();
				String userAgent = request.getHeader("user-agent");
				if (!userAgent.isEmpty() && userAgent.length() > 242) {
					userAgent = userAgent.substring(0, 242);
				}

				bearerToken = Jwts.builder().setSubject(authorizeKey).claim("roles", "user")
						.claim("transKey", "xxxxxxxx").setIssuedAt(new Date())
						.setExpiration(new Date(System.currentTimeMillis() + Long.parseLong("0000")))
						.signWith(SignatureAlgorithm.HS256, "smeSecretKey").compact();
				Map<String, String> tokenResponse = new HashMap();
				tokenResponse.put("token", bearerToken);
				LOGGER.info("Bearer Token Generated");
				LOGGER.debug(bearerToken);
				return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse(null));
			} catch (Exception e) {
				LOGGER.info("Error While generating Bearer Token");
				LOGGER.error(e.getMessage());
				LOGGER.error("Exception " + e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body(new CommonResponse("FAILURE", HttpStatus.INTERNAL_SERVER_ERROR.value()));
			}
		} else {
			LOGGER.info("X-Authorization Key Not Present");
			LOGGER.debug("X-Authorization Key Not Present in Header");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new CommonResponse("FAILURE", HttpStatus.UNAUTHORIZED.value()));
		}
	}
}
