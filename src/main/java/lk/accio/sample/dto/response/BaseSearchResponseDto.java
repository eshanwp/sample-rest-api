package lk.accio.sample.dto.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class BaseSearchResponseDto implements Serializable {

	private static final long serialVersionUID = 1976580727534340915L;

	private Long totalItems;
	private Long totalPages;
	private Integer currentPage;
	private List<?> items;

}
