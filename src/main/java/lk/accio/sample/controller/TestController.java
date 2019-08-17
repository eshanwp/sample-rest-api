package lk.accio.sample.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lk.accio.sample.common.Constant;
import lk.accio.sample.dto.request.save.UserDto;
import lk.accio.sample.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lk.accio.sample.config.log4j.Monitor.LogExecutionTime;

/**
 * @author Esh
 */

@Api(description="Operations pertaining to employee in Employee Management System")
@RequestMapping(Constant.API_ROOT)
@RestController
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    /**
     * get user name by user id
     *
     * @param userId
     * @return
     * @author Esh
     */
    @LogExecutionTime
    @ApiOperation(
            value = "Find User By User Id",
            notes = "Find the user details according to the given userId"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 403, message = "Forbidden Access"),
            @ApiResponse(code = 404, message = "Record Not Found"),
            @ApiResponse(code = 409, message = "Record Already Exists"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @GetMapping(value = Constant.FIND_USER_BY_USER_ID, produces = "application/json")
    public ResponseEntity<String> findUserByUserId(@PathVariable("userId") Long userId) {

        StringBuilder chainLog = new StringBuilder()
                .append("|ReqBdy: userId" + userId);
        return testService.findUserByUserId(chainLog, userId);
    }

    @LogExecutionTime
    @ApiOperation(
            value = "Find User By User Name",
            notes = "Find the user details according to the given user name"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 403, message = "Forbidden Access"),
            @ApiResponse(code = 404, message = "Record Not Found"),
            @ApiResponse(code = 409, message = "Record Already Exists"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @GetMapping(value = Constant.FIND_USER_BY_USER_NAME, produces = "application/json")
    public ResponseEntity<String> findUserByUserName(@PathVariable("userName") String userName) {

        StringBuilder chainLog = new StringBuilder()
                .append("|ReqBdy: userName" + userName);
        return testService.findUserByUserName(chainLog, userName);
    }

    @LogExecutionTime
    @ApiOperation(
            value = "Save User",
            notes = "Save user details according to the given data"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 403, message = "Forbidden Access"),
            @ApiResponse(code = 404, message = "Record Not Found"),
            @ApiResponse(code = 409, message = "Record Already Exists"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @PostMapping(value = Constant.FIND_USER_BY_USER_NAME, produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> saveUser(
            @ApiParam(value = "Save User Object", required = true) @RequestBody UserDto userDto
    ) {

        StringBuilder chainLog = new StringBuilder()
                .append("|ReqBdy: userDto" + userDto.toString());
        return testService.saveUser(chainLog, userDto);
    }


}
