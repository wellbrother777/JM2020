package net.pros.springsecuritydemo.security;

import net.pros.springsecuritydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import net.pros.springsecuritydemo.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user= userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exist"));
        return SecurityUser.fromUser(user);
    }
}
