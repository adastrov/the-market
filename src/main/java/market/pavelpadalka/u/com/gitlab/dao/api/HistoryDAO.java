package market.pavelpadalka.u.com.gitlab.dao.api;

import market.pavelpadalka.u.com.gitlab.entity.History;

import java.util.List;

public interface HistoryDAO {

    History create(History history);
    List<History> findAllByUserId(Integer id);

}
