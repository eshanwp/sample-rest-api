package lk.accio.sample.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Builder
public class ActionResponseDto implements Serializable {

	private static final long serialVersionUID = -8426928854530430529L;
	private List<?> items;
	private Object object;
	private String message;
	private Boolean actionStatus = Boolean.TRUE;

}
