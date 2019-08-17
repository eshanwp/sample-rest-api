package lk.accio.sample.config.log4j;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

/**
 * @author Esh
 */
@JsonPropertyOrder({"code", "msg", "data"})
public class ResponsePayload {

    private static Logger LOGGER = LogManager.getLogger(ResponsePayload.class.getSimpleName());

    @JsonProperty("data")
    private Object data;

    @JsonProperty("httpStatus")
    private Object httpStatus;

    @JsonProperty("msg")
    private String msg;

    public ResponsePayload(Object data, Object httpStatus, String msg) {
        this.data = data;
        this.httpStatus = httpStatus;
        this.msg = msg;
    }

    @Data
    @ToString
    public static class Builder {

        private Object data;
        private Object httpStatus;
        private String msg;
        private StringBuilder chainLog;
        private int httpCode;

        public Builder(HttpStatus httpSt, StringBuilder chainLog, String msg) {
            HashMap hashMap = new HashMap();
            hashMap.put("code", httpSt.value());
            hashMap.put("msg", httpSt.getReasonPhrase());

            setHttpStatus(hashMap);
            setMsg(msg);
            setChainLog(chainLog);
            setHttpCode(httpSt.value());
        }

        public Builder addPayloadAttr(Object object) {
            setData(object);
            return this;
        }

        public ResponseEntity<String> build() {

            JSONObject response = new JSONObject();
            response.put("data", getData());
            response.put("httpStatus", getHttpStatus());
            response.put("msg", getMsg());
            chainLog.append("|FinalResponse:").append(response);
            LOGGER.info(chainLog.toString());
            return ResponseEntity.status((Integer) getHttpCode()).body(response.toString());
        }

    }
}
