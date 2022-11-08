package study.jungma.kotlinspring.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import study.jungma.kotlinspring.domain.User
import study.jungma.kotlinspring.domain.UserRepository
import study.jungma.kotlinspring.dto.UserRequest
import study.jungma.kotlinspring.dto.UserResponse

@Transactional
@Service
class UserService(val userRepository: UserRepository) {

    fun save(userRequest: UserRequest): UserResponse {
        val result = userRepository.save(User(name = userRequest.name, email = userRequest.email))
        return UserResponse(id = result.id!!, name = result.name, email = result.email)
    }

    @Transactional(readOnly = true)
    fun find(id: Long): UserResponse {
        val result = userRepository.findById(id).orElseThrow { RuntimeException("해당하는 유저가 없습니다.") }
        return UserResponse(id = result.id!!, name = result.name, email = result.email)
    }
}
