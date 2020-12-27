package io.github.ihelin.demo.test.t1;

import java.util.StringJoiner;

/**
 * @author iHelin
 * @since 2019-03-12 10:39
 */
public class Request {

    private final String name;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Request.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
