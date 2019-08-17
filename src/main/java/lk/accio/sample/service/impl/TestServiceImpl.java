package lk.accio.sample.service.impl;

import lk.accio.sample.config.log4j.ResponsePayload;
import lk.accio.sample.dto.request.save.UserDto;
import lk.accio.sample.exception.RecordAlreadyExistsException;
import lk.accio.sample.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Esh
 */

@Service
public class TestServiceImpl implements TestService {

    @Override
    public ResponseEntity<String> findUserByUserId(StringBuilder chainLog, Long userId) {

        List<HashMap> hashMap = new ArrayList<>();
        HashMap h = new HashMap();
        h.put("id", 1);
        hashMap.add(h);

        if (userId ==1) {
            throw new RecordAlreadyExistsException("msg");
        }
        return new ResponsePayload.Builder(HttpStatus.OK, chainLog, "Success")
                .addPayloadAttr(hashMap)
                .build();
    }

    @Override
    public ResponseEntity<String> findUserByUserName(StringBuilder chainLog, String userName) {
        return new ResponsePayload.Builder(HttpStatus.OK, chainLog, "Success")
                .addPayloadAttr(userName)
                .build();
    }

    @Override
    public ResponseEntity<String> saveUser(StringBuilder chainLog, UserDto userDto) {
        return new ResponsePayload.Builder(HttpStatus.OK, chainLog, "Success")
                .addPayloadAttr(userDto)
                .build();
    }
}
