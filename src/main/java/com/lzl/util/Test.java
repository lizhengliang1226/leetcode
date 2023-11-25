package com.lzl.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 版权声明：本程序模块属于后台业务系统（FSPT）的一部分
 * 金证科技股份有限公司 版权所有<br>
 * <p>
 * 模块名称：期权业务-<br>
 * 模块描述：期权业务-<br>
 * 开发作者：李正良<br>
 * 创建日期：2023/02/04<br>
 * 模块版本：1.0.0.0<br>
 * ----------------------------------------------------------------<br>
 * 修改日期      版本       作者      备注<br>
 * 2023/02/04   1.0.0.0   李正良      创建<br>
 * -----------------------------------------------------------------</p>
 */
public class Test {
    public static void main(String[] args) {
        List<Map> result=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map m=new HashMap();
            m.put("MARKET","05");
            m.put("STK_CODE","600447");
            m.put("STK_RIGHTS",i*2);
            Map m1=new HashMap();
            m1.put("MARKET","15");
            m1.put("STK_CODE","60044");
            m1.put("STK_RIGHTS",i);
            result.add(m);
            result.add(m1);
        }
        Map<Object, Map<Object, List<Map>>> collect = result
                                                            .stream()
                                                            .collect(Collectors.groupingBy((m) -> m.get("MARKET"), Collectors.groupingBy(v -> v.get("STK_CODE"))));
        int i=0;
        int j=0;
        label1:
        for (; i < 10; i++) {
            System.out.println("i:"+i);
            System.out.println("====================");
            for (; j < 10; j++) {
            System.out.println("j:"+j);
                if(j>5)continue label1;
            }
            break;
        }
        System.out.println();
    }

}