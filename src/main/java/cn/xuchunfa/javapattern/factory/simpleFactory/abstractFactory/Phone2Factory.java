package cn.xuchunfa.javapattern.factory.simpleFactory.abstractFactory;

/**
 * @description:
 * @author: Xu chunfa
 * @create: 2018-11-14 11:15
 **/
public class Phone2Factory implements PhoneFactory {
    @Override
    public HUAWEI produceHW() {
        return new HUAWEI2();
    }

    @Override
    public XIAOMI produceXM() {
        return new XIAOMI2();
    }
}
