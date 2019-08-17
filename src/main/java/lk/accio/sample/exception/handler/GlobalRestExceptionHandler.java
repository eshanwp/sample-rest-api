package lk.accio.sample.exception.handler;

import lk.accio.sample.exception.ForbiddenAccessException;
import lk.accio.sample.exception.RecordAlreadyExistsException;
import lk.accio.sample.exception.RecordNotFoundException;
import lk.accio.sample.exception.dto.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ApiErrorResponse defaultExceptionHandler(Exception ex) {

		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
				.withError_code(HttpStatus.INTERNAL_SERVER_ERROR.value()).withMessage(ex.getMessage()).build();

		return response;
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(RecordNotFoundException.class)
	public ApiErrorResponse handleNotFoundException(RecordNotFoundException ex) {

		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.NOT_FOUND)
				.withError_code(HttpStatus.NOT_FOUND.value()).withMessage(ex.getMessage()).build();

		return response;
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(RecordAlreadyExistsException.class)
	public ApiErrorResponse handleAlreadyExistsException(RecordAlreadyExistsException ex) {

		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.ALREADY_REPORTED)
				.withError_code(HttpStatus.ALREADY_REPORTED.value()).withMessage(ex.getMessage()).build();

		return response;
	}
	
	
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(ForbiddenAccessException.class)
	public ApiErrorResponse handleForbiddenAccessException(ForbiddenAccessException ex) {

		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder().withStatus(HttpStatus.FORBIDDEN)
				.withError_code(HttpStatus.FORBIDDEN.value()).withMessage(ex.getMessage()).build();

		return response;
	}

}
