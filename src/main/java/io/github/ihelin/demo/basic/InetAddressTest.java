package io.github.ihelin.demo.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author iHelin
 * @date 2019-05-21 18:55
 */
public class InetAddressTest {


    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
        System.out.println(address.getAddress());
        System.out.println(address.getCanonicalHostName());
    }
}
