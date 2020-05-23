package com.forum.forum.service;


import com.forum.forum.dto.UserDTO;
import com.forum.forum.exception.CustomerAlreadyRegisteredException;
import com.forum.forum.exception.CustomerNotFoundException;
import com.forum.forum.model.User;
import com.forum.forum.model.UserRegisterForm;
import com.forum.forum.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepo userRepository;
    private final PasswordEncoder encoder;


    public void saveUser(UserRegisterForm form) {
        User u = new User();
        u.setEmail(form.getEmail());
        u.setName(form.getName());
        u.setPassword(form.getPassword());
        userRepository.save(u);
    }

    public boolean checkUser(UserRegisterForm form) {
        return userRepository.existsByNameAndEmail(form.getName(), form.getEmail());
    }
    public boolean check(String email){
        return userRepository.existsByEmail(email);
    }

    public UserDTO register(UserRegisterForm userRegisterForm){
        if(userRepository.existsByEmail(userRegisterForm.getEmail())){
            throw new CustomerAlreadyRegisteredException();
        }

        var user = User.builder()
                .email(userRegisterForm.getEmail())
                .name(userRegisterForm.getName())
                .password(encoder.encode(userRegisterForm.getPassword()))
                .build();

        userRepository.save(user);
        return UserDTO.from(user);
    }

    public UserDTO getByEmail(String email){
        var user = userRepository.findByEmail(email);
        return UserDTO.from(user);
    }

public  User findByUserName(String email){
        return  userRepository.findByEmail(email);
}
}
