package market.pavelpadalka.u.com.gitlab.service.impl;

import market.pavelpadalka.u.com.gitlab.dao.api.HistoryDAO;
import market.pavelpadalka.u.com.gitlab.dao.impl.HistoryDAOImpl;
import market.pavelpadalka.u.com.gitlab.dto.HistoryDTO;
import market.pavelpadalka.u.com.gitlab.entity.History;
import market.pavelpadalka.u.com.gitlab.helper.Transformer;
import market.pavelpadalka.u.com.gitlab.service.api.HistoryService;

import java.util.LinkedList;
import java.util.List;

public class HistoryServiceImpl implements HistoryService {

    private static volatile HistoryService instance;
    private HistoryDAO historyDAO = HistoryDAOImpl.getInstance();

    private HistoryServiceImpl() {
    }

    public static HistoryService getInstance() {
        if (instance == null) {
            synchronized (HistoryServiceImpl.class) {
                if (instance == null)
                    instance = new HistoryServiceImpl();
            }
        }
        return instance;
    }


    public HistoryDTO create(HistoryDTO historyDTO) {

        historyDAO.create(Transformer.transformHistoryDTOToHistory(historyDTO));

        return historyDTO;

    }

    public List<HistoryDTO> findAllByUserId(Integer userId) {

        List<HistoryDTO> historyDTOList = new LinkedList<HistoryDTO>();
        List<History> historyList = historyDAO.findAllByUserId(userId);

        for(History history : historyList) {
            historyDTOList.add(Transformer.transformHistoryToHistoryDTO(history));
        }

        return historyDTOList;

    }
}
