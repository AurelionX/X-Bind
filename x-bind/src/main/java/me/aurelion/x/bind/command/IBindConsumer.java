package me.aurelion.x.bind.command;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/11/8
 */
public interface IBindConsumer<T> {

    void accept(T t);

}
