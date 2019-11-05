package cn.ibm.com.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cn.ibm.com.auth.client.AccountServiceClient;
import cn.ibm.com.module.SbaUser;
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AccountServiceClient accountclient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			ResponseEntity<Object> result = accountclient.getUser(username);
			JsonObject accountresult = getResult(result);

			if (accountresult.get("code").getAsInt() == 404) {
				throw new UsernameNotFoundException("用户 " + username + " 不存在");
			} else {
				SbaUser user = getAccount(accountresult);
				
				List<GrantedAuthority> grantedAuthorities = AuthorityUtils
	                	.commaSeparatedStringToAuthorityList("ROLE_"+user.getRole());
				return new User(user.getName(), user.getPassword(), grantedAuthorities);
			}

		} catch (Exception ex) {

			throw new UsernameNotFoundException(ex.getMessage());
		}

	}

	public JsonObject getResult(ResponseEntity<Object> result) {
		Gson gson = new Gson();
		String jsonResultStr = gson.toJson(result.getBody());
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser.parse(jsonResultStr);

		return object;

	}

	public SbaUser getAccount(JsonObject result) {
		Gson gson = new Gson();

		SbaUser user = gson.fromJson(result.get("data").toString(), SbaUser.class);

		return user;

	}
}
