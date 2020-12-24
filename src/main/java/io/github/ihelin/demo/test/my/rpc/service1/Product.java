package io.github.ihelin.demo.test.my.rpc.service1;

import java.io.Serializable;

/**
 * @author iHelin
 * @since 2018/4/12 09:44
 */
public class Product implements Serializable {

    private static final long serialVersionUID = -5995861643939496648L;

    private long id;
    private String name;
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
