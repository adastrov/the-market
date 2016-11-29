package market.pavelpadalka.u.com.gitlab.service.api;

import market.pavelpadalka.u.com.gitlab.dto.HistoryDTO;

import java.util.List;

public interface HistoryService {

    HistoryDTO create(HistoryDTO history);
    List<HistoryDTO> findAllByUserId(Integer userId);

}
