package io.github.ihelin.demo.basic.domain;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @author iHelin
 * @since 2017/11/27 14:05
 */
public class Apple implements Serializable {

    private static final long serialVersionUID = 6435702077689357740L;

    private Integer id;
    private int price;
    private String name;

    public Apple(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 重写hashCode，只对id做hash
     *
     * @return
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Apple other = (Apple) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Apple.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("price=" + price)
                .add("name='" + name + "'")
                .toString();
    }
}
