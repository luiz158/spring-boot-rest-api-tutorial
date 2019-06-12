/*
 *
 *  Copyright (c) 2018-2020 Givantha Kalansuriya, This source is a part of
 *   Staxrt - sample application source code.
 *   http://staxrt.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.staxrt.tutorial.user;

import com.staxrt.tutorial.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsers() {

        return new ResponseEntity(userService.findAll(), HttpStatus.OK);

    }

    /**
     * 유저를 생성한다
     * @param dto   :: 유저 요청 객체
     * @return      :: 유저
     */
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequestDto dto) {

        return new ResponseEntity(userService.save(dto), HttpStatus.OK);

    }

    /**
     * id 값을 통해 유저를 획득한다.
     *
     * @param userId the user id
     * @return the users by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {

        User findUser = userService.findById(userId);

        return new ResponseEntity(findUser, HttpStatus.OK);
    }

    /**
     * 유저 정보를 업데이트 한다.
     * @param userId
     * @param dto
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                           @Valid @RequestBody UserRequestDto dto) throws ResourceNotFoundException {

        final User updatedUser = userService.update(userId, dto);

        return new ResponseEntity(updatedUser, HttpStatus.OK);
    }

    /**
     * Delete user map.
     *
     * @param userId the user id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {

        userService.delete(userId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
