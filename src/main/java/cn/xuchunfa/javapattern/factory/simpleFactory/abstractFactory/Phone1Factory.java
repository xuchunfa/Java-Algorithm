package cn.xuchunfa.javapattern.factory.simpleFactory.abstractFactory;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-11-14 11:14
 **/
public class Phone1Factory implements PhoneFactory {
    @Override
    public HUAWEI produceHW() {
        return new HUAWEI1();
    }

    @Override
    public XIAOMI produceXM() {
        return new XIAOMI1();
    }
}
