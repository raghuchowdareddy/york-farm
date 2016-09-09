/**
 * 
 */
package com.enuminfo.farm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.CredentialException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.enuminfo.farm.path.RedirectPath;
import com.enuminfo.farm.path.RequestPath;

/**
 * @author Kumar
 */
@Controller
@SessionAttributes ("authorizationRequest")
public class SecurityController {

	@Autowired 
	AuthenticationManager authenticationManager;
	
	@Autowired 
	ClientDetailsService clientDetailsService;
	
	@Autowired 
	HttpSessionSecurityContextRepository httpSessionSecurityContextRepository;
	
	@RequestMapping (value = RequestPath.LOGIN, method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String handleInternalRequestForLoginPage() {
		return RedirectPath.LOGIN;
	}
	
	private Map<String, String> getAuthParameters(DefaultSavedRequest defaultSavedRequest) {
		Map<String, String> authParams = new HashMap<>();
		authParams.put(OAuth2Utils.CLIENT_ID, defaultSavedRequest.getParameterMap().get(OAuth2Utils.CLIENT_ID)[0]);
        authParams.put(OAuth2Utils.REDIRECT_URI, defaultSavedRequest.getParameterMap().get(OAuth2Utils.REDIRECT_URI)[0]);
        if(defaultSavedRequest.getParameterMap().get(OAuth2Utils.STATE) != null)
            authParams.put(OAuth2Utils.STATE, defaultSavedRequest.getParameterMap().get(OAuth2Utils.STATE)[0]);
        authParams.put(OAuth2Utils.RESPONSE_TYPE, "code");
        authParams.put(OAuth2Utils.USER_OAUTH_APPROVAL, "true");
        authParams.put(OAuth2Utils.GRANT_TYPE, "authorization_code");
        return authParams;
	}
	
	@RequestMapping (value = RequestPath.LOGIN, method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	public String handleInternalRequestForAuthenticate(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpRequestResponseHolder httpRequestResponseHolder = new HttpRequestResponseHolder(request, response);
		httpSessionSecurityContextRepository.loadContext(httpRequestResponseHolder);
		try {
			List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
			Authentication auth = new UsernamePasswordAuthenticationToken(request.getParameter("username"), request.getParameter("password"), authorities);
			SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(auth));
			if(!authenticationManager.authenticate(auth).isAuthenticated())
				throw new CredentialException("User could not be authenticated");
		} catch (CredentialException e) {
			return RedirectPath.LOGIN;
		}
        DefaultSavedRequest defaultSavedRequest = ((DefaultSavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST"));
        Map<String, String> authParams = getAuthParameters(defaultSavedRequest);
        AuthorizationRequest authRequest = new DefaultOAuth2RequestFactory(clientDetailsService).createAuthorizationRequest(authParams);
        authRequest.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN"));
        httpSessionSecurityContextRepository.saveContext(SecurityContextHolder.getContext(), httpRequestResponseHolder.getRequest(), httpRequestResponseHolder.getResponse());
        model.addAttribute("authorizationRequest", authRequest);
		return RedirectPath.AUTHORIZE;
	}
}
