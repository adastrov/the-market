package Shop.pavelpadalka.u.com.gitlab.dao.api;

import Shop.pavelpadalka.u.com.gitlab.entity.Transaction;

import java.util.List;

public interface TransactionDAO {

    Transaction create(Transaction transaction);
    List<Transaction> findAllByUserId(Integer id);

}
