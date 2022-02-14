package ru.gb.rest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.persist.User;
import ru.gb.persist.UserRepository;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserResource {

    UserRepository userRepository;

    @GetMapping("/all")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}/id")
    public User findById(@PathVariable("id") long id) {
        return userRepository
                .findById(id).orElseThrow(() -> new NotFoundException("User with id = " + id + " not exists"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        if (user.getId() != null) {
            throw new IllegalArgumentException("Can't create user with id not null");
        }
        return userRepository.save(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User update(@RequestBody User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("Can't update user with id null");
        }
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        userRepository.deleteById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto notFoundExceptionHandler(NotFoundException exception) {
        return new ErrorDto(exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto notFoundExceptionHandler(IllegalArgumentException exception) {
        return new ErrorDto(exception.getMessage());
    }
}
