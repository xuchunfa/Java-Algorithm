package cn.xuchunfa.javapattern.factory.simpleFactory.abstractFactory;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-11-14 11:16
 **/
public class Test {

    @org.junit.Test
    public void test(){
        PhoneFactory pf1 = new Phone1Factory();
        HUAWEI huawei = pf1.produceHW();
        XIAOMI xiaomi = pf1.produceXM();

        huawei.huaweiInfo();
        xiaomi.xiaomiInfo();

        PhoneFactory pf2 = new Phone2Factory();
        huawei = pf2.produceHW();
        xiaomi = pf2.produceXM();

        huawei.huaweiInfo();
        xiaomi.xiaomiInfo();
    }
}
