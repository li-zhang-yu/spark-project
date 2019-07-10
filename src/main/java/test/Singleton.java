package test;

/**
 * 单例模式
 *
 * @author lizhangyu
 * @Date 2019-07-10
 */
public class Singleton {

    private static Singleton instance = null;

    public Singleton() {
    }

    private static Singleton getInstance() {
        // 两步检查机制
        // 首先第一步，多个线程过来的时候，判断instance是否为null
        // 如果为null再往下走
        if (instance == null) {
            // 在这里，进行多个线程的同步
            // 同一时间，只能有一个线程获取到Singleton Class对象的锁
            // 进入后续的代码
            // 其他线程，都是只能够在原地等待，获取锁
            synchronized (Singleton.class) {
                // 只有第一个获取到锁的线程，进入到这里，会发现是instance是null
                // 然后才会去创建这个单例
                // 此后，线程，哪怕是走到了这一步，也会发现instance已经不是null了
                // 就不会反复创建一个单例
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
