package lk.accio.sample.exception.dto;

import org.springframework.http.HttpStatus;

public class ApiErrorResponse {

	private HttpStatus status;
	private int error_code;
	private String message;
	private String detail;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	// Builder
	public static final class ApiErrorResponseBuilder {

		private HttpStatus status;
		private int error_code;
		private String message;
		private String detail;

		public ApiErrorResponseBuilder() {
		}

		public static ApiErrorResponseBuilder anApiErrorResponse() {
			return new ApiErrorResponseBuilder();
		}

		public ApiErrorResponseBuilder withStatus(HttpStatus status) {
			this.status = status;
			return this;
		}

		public ApiErrorResponseBuilder withError_code(int error_code) {
			this.error_code = error_code;
			return this;
		}

		public ApiErrorResponseBuilder withMessage(String message) {
			this.message = message;
			return this;
		}

		public ApiErrorResponseBuilder withDetail(String detail) {
			this.detail = detail;
			return this;
		}

		public ApiErrorResponse build() {
			ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
			apiErrorResponse.status = this.status;
			apiErrorResponse.error_code = this.error_code;
			apiErrorResponse.detail = this.detail;
			apiErrorResponse.message = this.message;
			return apiErrorResponse;
		}
	}

	@Override
	public String toString() {
		return "ApiErrorResponse{" +
				"status=" + status +
				", error_code=" + error_code +
				", message='" + message + '\'' +
				", detail='" + detail + '\'' +
				'}';
	}
}
