package com.ycloud.security;

import com.ycloud.exception.client.ClientNotFoundException;
import com.ycloud.model.Client;
import com.ycloud.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service("userDetailsServiceImpl")
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {  //перевір. під час log in по email чи існує такий клієнт

    private final ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.getOneByEmail(email);
        if (client == null){
            throw new UsernameNotFoundException(ClientNotFoundException.DEFAULT_MESSAGE);
        }
        return SecurityUser.fromClient(client);
    }
}
