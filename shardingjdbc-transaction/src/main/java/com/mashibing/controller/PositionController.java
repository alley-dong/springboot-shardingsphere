package com.mashibing.controller;

import com.mashibing.entity.Position;
import com.mashibing.entity.PositionDetail;
import com.mashibing.mapper.PositionDetailMapper;
import com.mashibing.mapper.PositionMapper;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author spikeCong
 * @date 2022/11/22
 **/
@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    private PositionDetailMapper positionDetailMapper;

    @RequestMapping("/show")
    public String show(){

        return "SUCCESS";
    }

    @Transactional
//    @ShardingTransactionType(TransactionType.XA)
    @RequestMapping("/save")
    public String savePosition(){

        for (int i = 0; i < 4 ; i++) {
            Position position = new Position();
            position.setName("C++_dev" + i);
            position.setSalary("20000");
            position.setCity("北京");
            positionMapper.insert(position);

            if(i == 3){
                throw new RuntimeException("人为制造异常!");
            }

            PositionDetail positionDetail = new PositionDetail();
            positionDetail.setPid(position.getId());
            positionDetail.setDescription("C++_dev" + i);
            positionDetailMapper.insert(positionDetail);
        }

        return "SUCCESS";
    }
}
