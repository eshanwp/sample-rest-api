package lk.accio.sample.dto.request.search;

import lk.accio.sample.enums.SortingDirection;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class BaseSearchRequestDto implements Serializable {

    private static final long serialVersionUID = -2704666961608970866L;

    private Integer pageIndex = 0;
    private String sortingField;
    private SortingDirection sortingDirection = SortingDirection.ASC;

}
