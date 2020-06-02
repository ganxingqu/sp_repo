package cn.tedu.Thread;

public class Demo01 implements Runnable{


    public static void main(String[] args){
        Demo01 demo01 = new Demo01();
        Thread t1 = new Thread(demo01,"线程1-");
//        Thread t2 = new Thread(demo01,"线程2-");
//        t2.setDaemon(true);
        t1.start();
//        t2.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println(Thread.currentThread().getName() + ":In Main");
            e.printStackTrace();
        }
        t1.interrupt();
        System.err.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.err.println(Thread.currentThread().getName());
//        if (Thread.currentThread().getName().equals("线程2-")){
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                System.err.println(1111111111);
//                e.printStackTrace();
//            }
//        }
        try {
            for (int i=0;i<8;i++) {
                System.out.println(Thread.currentThread().getName() + i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e) {
            System.err.println(Thread.currentThread().getName()+":" +Thread.currentThread().isAlive());
            System.err.println(Thread.currentThread().getName()+":" +Thread.currentThread().isInterrupted());
            System.err.println(Thread.currentThread().getName()+":In Run");
            e.printStackTrace();
        }
    }
}
