package me.ianhe.test.my.transaction;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author iHelin
 * @since 2017/8/2 15:09
 */
public class UserService {

    private UserAccountDao userAccountDao;
    private UserOrderDao userOrderDao;
    private TransactionManager transactionManager;

    public UserService(DataSource dataSource) {
        userAccountDao = new UserAccountDao(dataSource);
        userOrderDao = new UserOrderDao(dataSource);
        transactionManager = new TransactionManager(dataSource);
    }

    public void action() {
        try {
            transactionManager.start();
            userOrderDao.buy();
            userAccountDao.buy();
            transactionManager.close();
        } catch (SQLException e) {
            e.printStackTrace();
            transactionManager.rollback();
        }
    }
}
