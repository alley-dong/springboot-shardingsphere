package com.mashibing.algorithm;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author spikeCong
 * @date 2022/11/30
 **/
public class DbStandardAlgorithm implements StandardShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {

        for (String actualDb : collection) {
            if(actualDb.endsWith(String.valueOf(preciseShardingValue.getValue() % 2))){
                return actualDb;
            }
        }

        throw new RuntimeException("配置错误,表不存在");
    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {

        return  Arrays.asList("db0","db1");
    }

    @Override
    public void init() {

    }

    @Override
    public String getType() {
        return "STANDARD_TEST_DB";
    }
}
