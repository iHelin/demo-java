package me.ianhe.test.my.datasource;

/**
 * @author iHelin
 * @since 2017/8/2 17:45
 */
public interface IMyPool {

    MyPooledConnection getMyPooledConnection();

    void createMyPooledConnection(int count);

}
