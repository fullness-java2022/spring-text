package com.example.demo.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountUserDetailService implements UserDetailsService{
	@Autowired
	private AccountRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// DBから取得したAccountレコードからAccountUserDetailsインスタンスを生成してreturn
		Account account = repository.selectByUserName(username);
		if(account == null) throw new UsernameNotFoundException("ユーザが存在しません");
		return new AccountUserDetails(account, this.getAuthorities(account.getRole().getName()));
	}
	/**
	 * DBから取得したロール文字列からCollection<GrantedAuthority>インスタンスを返却するメソッド
	 * @param role DBから取得した権限
	 * @return Collection<GrantedAuthority> SpringSecurityで必要な権限オブジェクト
	 */
	private Collection<GrantedAuthority> getAuthorities(String role){
		switch(role) {
		case "admin":
			return AuthorityUtils.createAuthorityList("ROLE_ADMIN","ROLE_USER","ROLE_GUEST");
		case "user":
			return AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_GUEST");
		case "guest":
			return AuthorityUtils.createAuthorityList("ROLE_GUEST");
		default:
			return null;
		}
	}
}
