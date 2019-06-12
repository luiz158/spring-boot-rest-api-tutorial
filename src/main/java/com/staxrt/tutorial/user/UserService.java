package com.staxrt.tutorial.user;

import com.staxrt.tutorial.exception.ResourceNotFoundException;
import com.staxrt.tutorial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    User save(UserRequestDto dto){
        return userRepository.save(dto.toEntity());
    }

    List<User> findAll(){

        List<User> users = userRepository.findAll();

        return users;
    }

    User findById(Long id) throws ResourceNotFoundException {

        return userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
    }

    User update(Long id, UserRequestDto dto) throws ResourceNotFoundException {

        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));

        user.updateName(dto.getName());
        user.updateEmail(dto.getEmail());

        return userRepository.save(user);
    }

    void delete(Long id) throws ResourceNotFoundException {

        User user =
                userRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));

        userRepository.delete(user);
    }
}
