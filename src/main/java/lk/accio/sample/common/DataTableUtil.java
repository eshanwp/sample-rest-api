package lk.accio.sample.common;

import lk.accio.sample.dto.request.search.BaseSearchRequestDto;
import lk.accio.sample.enums.SortingDirection;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class DataTableUtil {
	
	public static Pageable createPageRequest(final BaseSearchRequestDto searchDTO, final String sortBy,
											 final Direction sortOrder) {
		return new PageRequest(searchDTO.getPageIndex(), Constant.ITEMS_PER_PAGE, new Sort(sortOrder, sortBy));
	}

	public static Pageable createReadMorePageRequest(final BaseSearchRequestDto searchDTO, final String sortBy) {
		return new PageRequest(searchDTO.getPageIndex(), Constant.READ_MORE_ITEMS_PER_PAGE,
				new Sort(Sort.Direction.ASC, sortBy));
	}

	public static Pageable createPageRequest(final BaseSearchRequestDto searchDTO) {
		return new PageRequest(searchDTO.getPageIndex(), Constant.ITEMS_PER_PAGE);
	}

	public static Pageable createPageRequest(final BaseSearchRequestDto searchDTO, final String sortBy) {
		if (SortingDirection.ASC.equals(searchDTO.getSortingDirection())) {
			return new PageRequest(searchDTO.getPageIndex(), Constant.ITEMS_PER_PAGE,
					new Sort(Sort.Direction.ASC, sortBy));
		} else {
			return new PageRequest(searchDTO.getPageIndex(), Constant.ITEMS_PER_PAGE,
					new Sort(Sort.Direction.DESC, sortBy));
		}

	}

	public static Pageable createPageRequest(final BaseSearchRequestDto searchDTO, final String sortBy, final String type) {
		if (SortingDirection.ASC.equals(searchDTO.getSortingDirection())) {
			return new PageRequest(searchDTO.getPageIndex(), Constant.READ_MORE_ITEMS_PER_PAGE,
					new Sort(Sort.Direction.ASC, sortBy));
		} else {
			return new PageRequest(searchDTO.getPageIndex(), Constant.READ_MORE_ITEMS_PER_PAGE,
					new Sort(Sort.Direction.DESC, sortBy));
		}

	}

	public static Pageable createPageGridRequest(final BaseSearchRequestDto searchDTO, final String sortBy) {
		if (SortingDirection.ASC.equals(searchDTO.getSortingDirection())) {
			return new PageRequest(searchDTO.getPageIndex(), Constant.ITEMS_PER_GRID_PAGE,
					new Sort(Sort.Direction.ASC, sortBy));
		} else {
			return new PageRequest(searchDTO.getPageIndex(), Constant.ITEMS_PER_GRID_PAGE,
					new Sort(Sort.Direction.DESC, sortBy));
		}

	}
	
	public static Long calculateTotalNumberOfPages(final Long totalItemCount){
		return (long) Math.ceil((double)totalItemCount/Constant.ITEMS_PER_PAGE);
	}
}
