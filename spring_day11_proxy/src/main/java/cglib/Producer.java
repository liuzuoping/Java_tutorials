package cglib;

import proxy.IProducer;

public class Producer {
    public void saleProduct(float money){
        System.out.println("销售产品，并且拿到钱"+money);
    }
    public void afterService(float money){
        System.out.println("提供售后服务，并且拿到钱"+money);
    }
}