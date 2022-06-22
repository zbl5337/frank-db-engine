package com.frank.common.odps;

import com.aliyun.odps.Odps;
import com.aliyun.odps.Table;
import com.aliyun.odps.account.Account;
import com.aliyun.odps.account.AliyunAccount;

public class Main {

    /**
     * ODPS 数据库信息
     *
     *  Maxtest1@1644565260386613.onaliyun.com  密码：Maxtest1
     *
     *  Maxtest2@1644565260386613.onaliyun.com  密码：Maxtest2
     *
     *  Maxtest3@1644565260386613.onaliyun.com  密码：Maxtest3
     *
     * Endpoint： http://service.cn.maxcompute.aliyun-inc.com/api
     * 项目名称：mctest3
     * 地域：cn-shanghai
     * AccessKey ID： LTAI5tQQ35nN9Li2oiZAPRkg		AccessKey Secret：	  XLm3HJ7ftZTZUgtyzH4RxVFz30FJqY
     *
     * Endpoint： http://service.cn.maxcompute.aliyun-inc.com/api
     * 项目名称：HzmcTest
     * 地域：cn-hangzhou
     * AccessKey ID： LTAI5tH4wmhoMsNz4BfYdMQ3		AccessKey Secret：   VGhQIOE8PlSYu6puR89mtbO8lfcOAP
     *
     * Endpoint： http://service.cn.maxcompute.aliyun-inc.com/api
     * 项目名称：mctest2
     * 地域：cn-hangzhou
     * AccessKey ID： LTAI5tLd18byLWoT8zp4hhNf		AccessKey Secret：	 rFAg7fJ588hjiIzUNCADxofqoDb6dB
     * @param args
     */
    public static void main(String[] args) {
        Account account = new AliyunAccount("LTAI5tQQ35nN9Li2oiZAPRkg", "XLm3HJ7ftZTZUgtyzH4RxVFz30FJqY");
        Odps odps = new Odps(account);
        odps.setEndpoint("http://service.cn.maxcompute.aliyun-inc.com/api");
        odps.setDefaultProject("HzmcTest");
        //odps 忽略https验证
        odps.getRestClient().setIgnoreCerts(true);

//        System.out.println(odps.tables());
        for (Table table : odps.tables()) {
            System.out.println(table.getName());
        }
    }

}
