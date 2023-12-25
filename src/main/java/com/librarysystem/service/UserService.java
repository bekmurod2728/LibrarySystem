package com.librarysystem.service;

import com.librarysystem.dto.UserDto;
import com.librarysystem.entity.User;
import com.librarysystem.entity.UserData;
import com.librarysystem.repasitory.UserDataRepository;
import com.librarysystem.repasitory.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserDataRepository userDataRepository;
    private  final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, UserDataRepository userDataRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userDataRepository = userDataRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void addUser(UserDto userDto){
        User user=new User();
        user.setUsername(userDto.getUsername());
        UserData userData=new UserData();
        userData.setAge(userDto.getAge());
        userData.setEmail(userDto.getEmail());
        userData.setCitizenship(userDto.getCitizenship());
        userData.setFirst_name(userDto.getFirst_name());
        userData.setLast_name(userDto.getLast_name());
        user.setUserData(userData);
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userData.setUser(user);
        userDataRepository.save(userData);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username).orElse(null);

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getUserData().getRole().getGrantedAuthority()

        );
    }
}
