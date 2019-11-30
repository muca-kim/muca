// package com.project.service;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import com.project.entity.UserEntity;
// import com.project.repository.UserRepository;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import lombok.AllArgsConstructor;

// @Service
// @AllArgsConstructor
// public class UserService implements UserDetailsService {
//     private UserRepository userRepository;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
//         Optional<UserEntity> userEntityWrapper = userRepository.findById(username);
//         UserEntity userEntity = userEntityWrapper.get();

//         List<GrantedAuthority> authorities = new ArrayList<>();

//         if (("muca0127").equals(username)) {
//             authorities.add(new SimpleGrantedAuthority("ADMIN"));
//         } else {
//             authorities.add(new SimpleGrantedAuthority("PERSONAL"));
//         }

//         // return new User(userEntity.getId(), userEntity.getPassword(), authorities);
//         return new User("", "", authorities);
//     }

// }