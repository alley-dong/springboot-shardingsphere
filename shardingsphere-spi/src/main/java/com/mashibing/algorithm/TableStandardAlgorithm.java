package com.mashibing.algorithm;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

/**
 * 自定义表分片算法策略
 * @author spikeCong
 * @date 2022/11/30
 **/
public class TableStandardAlgorithm implements StandardShardingAlgorithm<Long> {


    /**
     * @param collection 所有真实表的表名称集合
     * @param preciseShardingValue   条件值
     * @return: java.lang.String
     */
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {

        //分片的逻辑代码
        String logicTableName = preciseShardingValue.getLogicTableName();   //t_course

        //针对条件值取模,来确定具体表
        BigInteger suffix = BigInteger.valueOf(preciseShardingValue.getValue()).mod(new BigInteger("2"));

        //拼接真实表
        String actualTableName = logicTableName +"_" + suffix;

        if(collection.contains(actualTableName)){
            return actualTableName;
        }

        throw new RuntimeException("配置错误,表不存在");
    }

    /**
     * 确定范围查询时 要查询的表有哪些
     * @param collection
     * @param rangeShardingValue  分片值范围
     * @return: java.util.Collection<java.lang.String>
     */
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {

        String logicTableName = rangeShardingValue.getLogicTableName();
        return Arrays.asList(logicTableName +"_0",logicTableName + "_1");
    }

    @Override
    public void init() {

    }


    //返回在配置文件中定义的 type
    @Override
    public String getType() {

        return "STANDARD_TEST_TB";
    }
}
