/*
ProducterConsumerDemo解决了只有两个线程共享资源的生产消费问题，主要利用标志位的互斥解决

本程序致力于解决多出现多个生产者，多个消费者的时候，依然能够达到生产一次，消费一次的功能
：
解决的方法就是：1)在被唤醒之后仍然进行条件判断，去检查要改的数字是否满足条件，如果不满足条件就继续睡眠。把两个方法中的if改为while即可。
当然，此时仍会出现问题，就是所以线程都等待，失去资格
                2)需要将notify()改成notifyAll()
*/

class  ProducterConsumerDemo2
{
    public static void main(String[] args) 
    {
        Resources  r =new Resources();
        Productor  pro =new Productor(r);
        Consumer   con = new Consumer(r);
        
        Thread t1 =new Thread(pro);
        Thread t2 =new Thread(pro);//多个生产者
        Thread t3 =new Thread(con);
        Thread t4 =new Thread(con);//多个消费者
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("Hello World!");
    }
}

class Resources
{
    private String name;
    private int count =1;
    private boolean flag =false;

    public synchronized void set(String name)
    {  //1)循环判断
       while(flag)
           try{this.wait();}catch(Exception e){}
       this.name = name+"--"+count++;

       System.out.println(Thread.currentThread().getName()+"生产者"+this.name);
       flag =true;
       //2)唤醒所有进程
       this.notifyAll();

    }
    public synchronized void out()
    {
       //1)循环判断
       while(!flag)
           try{this.wait();}catch(Exception e){}
       
       System.out.println(Thread.currentThread().getName()+" ....消费者...."+this.name);
       flag =false;
       //2)唤醒所有进程
       this.notifyAll();

    }
}

class Productor implements Runnable
{
    private Resources res;
    Productor(Resources res){
        this.res =res;
    }
    public void run(){
        while(true){
            res.set("++商品++");
        }
    }

}

class Consumer  implements Runnable
{
    private Resources res;
    Consumer(Resources res){
        this.res =res;
    }
    public void run(){
        while(true){
            res.out();
        }
    }

}
