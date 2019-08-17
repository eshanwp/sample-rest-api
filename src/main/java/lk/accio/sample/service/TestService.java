package lk.accio.sample.service;

import lk.accio.sample.dto.request.save.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Esh
 */

@Transactional
public interface TestService {
    ResponseEntity<String> findUserByUserId(StringBuilder chainLog, Long userId);

    ResponseEntity<String> findUserByUserName(StringBuilder chainLog, String userName);

    ResponseEntity<String> saveUser(StringBuilder chainLog, UserDto userDto);
}
