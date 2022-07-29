package com.lzl;

import cn.hutool.core.util.RandomUtil;



import java.util.ArrayList;
import java.util.List;

/**
 * 模板类
 *
 * @author LZL
 * @version v1.0
 * @date 2022/7/18-17:34
 */
public abstract class ModuleClass {
    protected  List<Integer> intList = new ArrayList<>();

    {
        for (int i = 0; i < 10; i++) {
            intList.add(RandomUtil.randomInt(1,100));
        }
    }

}