package datastruct;

/**
 * @author：Cheng.
 * @date：Created in 16:55 2019/10/17
 */
public class HashMapTest {
    //HashMap的链表插入是后插入，因为HashMap的发明者认为，后插入的Entry被查找的可能性更大。

    //面试题1.HashMap的默认初始长度是16，并且每次自动扩展或者手动初始化的时候，长度必须是2的幂。为什么？？
        //之所以选择16，是为了服务于从Key映射到index的Hash算法，从Key映射到HashMap数组的对应位置，会用到一个Hash函数
        //HashMap的发明者采用了位运算的方式实现一个尽量均匀分布的Hash函数。 index = HashCode(Key) & (Length-1)
        //这样做不但效果等于取模，而且还大大提高了性能。，长度为16或者其他2的幂，Length-1的值是所有二进制位全部为1，
        // 这种情况下，index的结果等同于HashCode后几位的值，只要输入HashCode本身分布均匀，Hash算法的结果就是均匀的。

    //面试题2：高并发情况下HashMap可能会出现的问题
    //在多线程环境中，Hash的Rehash操作可能会带来什么样的问题？

}
