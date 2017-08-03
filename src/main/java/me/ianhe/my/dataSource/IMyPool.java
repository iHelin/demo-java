package me.ianhe.my.dataSource;

/**
 * @author iHelin
 * @since 2017/8/2 17:45
 */
public interface IMyPool {

    MyPooledConnection getMyPooledConnection();

    void createMyPooledConnection(int count);

}
