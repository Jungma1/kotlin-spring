package study.jungma.kotlinspring.controller

import org.springframework.web.bind.annotation.*
import study.jungma.kotlinspring.dto.UserRequest
import study.jungma.kotlinspring.dto.UserResponse
import study.jungma.kotlinspring.service.UserService

@RestController()
class UserController(val userService: UserService) {

    @PostMapping("/users")
    fun save(@RequestBody request: UserRequest): UserResponse {
        return userService.save(request)
    }

    @GetMapping("/users/{id}")
    fun find(@PathVariable id: Long): UserResponse {
        return userService.find(id)
    }
}
