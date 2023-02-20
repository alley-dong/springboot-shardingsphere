package com.mashibing.hint;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author spikeCong
 * @date 2022/11/15
 **/
public class MyHintShardingAlgorithm implements HintShardingAlgorithm<Long> {//泛型long表示传入的参数是long类型

    /**
     * 定义强制路由策略
     *      collection: 代表分片目标: 对哪些数据库 表进行分片,比如做分库路由,集合中就存储着 db0.t_course, db1
     *      hintShardingValue: 代表分片值, 指的是使用者对分片键赋的值
     */
    @Override
    public Collection<String> doSharding(Collection<String> collection,
                                         HintShardingValue<Long> hintShardingValue) {

        //保存分库分表路由的逻辑
        Collection<String> result = new ArrayList<>();

        for (String actualDb : collection) {  //actualDb = db1
            Collection<Long> values = hintShardingValue.getValues();
            for (Long value : values) {
                //分库路由 判断当前节点名称结尾 是否与取模结果一致
                if(actualDb.endsWith(String.valueOf(value % 2))){
                    result.add(actualDb);
                }
            }

        }

        return result;
    }

}
