package io.github.ihelin.demo.pattern.creational;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 原型模式
 * 即通过一个实例的原型来复制（克隆）出类似的实例，而不是去重新创建，这有
 * 点像克隆人。如果你使用过 Javascript ，你应该对 Prototype 很熟悉。
 * <p>
 * 总结：
 * 在开发过程中，有时会遇到为一个类创建多个实例的情况，这些实例内部成员往往完
 * 全相同或有细微的差异，而且实例的创建开销比较大或者需要输入较多参数，如果能通过复
 * 制一个已创建的对象实例来重复创建多个相同的对象，这就可以大大减少创建对象的开销，
 * 这个时候就需要原型模式。
 *
 * @author iHelin
 * @since 2017/8/3 15:37
 */
public class PrototypePattern {
    /**
     * 简单来说就是通过实现 Cloneable 接口来进行复制，这种复制方式为浅复制。
     *
     * @see Cloneable
     */
    static class Man implements Cloneable {
        private final String name = "高富帅";

        @Override
        protected Man clone() throws CloneNotSupportedException {
            return (Man) super.clone();
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Man man = new Man();
        System.out.println(man);
        System.out.println(man.clone());
        System.out.println(man.clone());
        System.out.println(man.clone());
    }
}
