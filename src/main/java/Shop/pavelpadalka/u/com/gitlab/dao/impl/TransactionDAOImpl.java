package Shop.pavelpadalka.u.com.gitlab.dao.impl;

import Shop.pavelpadalka.u.com.gitlab.dao.api.TransactionDAO;
import Shop.pavelpadalka.u.com.gitlab.entity.Transaction;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO {


    public Transaction create(Transaction transaction) {
        return transaction;
    }

    public List<Transaction> findAllByUserId(Integer id) {

        List<Transaction> transactions = new LinkedList<Transaction>();

        Transaction transaction        = new Transaction();

        transaction.setDate(new Date());

        transactions.add(transaction);

        return transactions;

    }
}
