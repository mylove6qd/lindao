package com.ldx.dao.export;

import java.util.List;

import com.ldx.domain.export.service;
import com.ldx.domain.export.serviceExample;
import org.apache.ibatis.annotations.Param;

public interface serviceDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbg.generated
     */
    long countByExample(serviceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbg.generated
     */
    int deleteByExample(serviceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String serviceId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbg.generated
     */
    int insert(service record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbg.generated
     */
    int insertSelective(service record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbg.generated
     */
    List<service> selectByExample(serviceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbg.generated
     */
    service selectByPrimaryKey(String serviceId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") service record, @Param("example") serviceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") service record, @Param("example") serviceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(service record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(service record);
}