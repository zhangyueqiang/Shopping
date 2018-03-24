package com.stu.ShoppingManagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stu.ShoppingManagement.entity.TbOrderItem;
import com.stu.ShoppingManagement.entity.TbOrderItemExample;

@Mapper
public interface TbOrderItemMapper {
    int countByExample(TbOrderItemExample example);

    int deleteByExample(TbOrderItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbOrderItem record);

    int insertSelective(TbOrderItem record);

    List<TbOrderItem> selectByExample(TbOrderItemExample example);

    TbOrderItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbOrderItem record, @Param("example") TbOrderItemExample example);

    int updateByExample(@Param("record") TbOrderItem record, @Param("example") TbOrderItemExample example);

    int updateByPrimaryKeySelective(TbOrderItem record);

    int updateByPrimaryKey(TbOrderItem record);
}