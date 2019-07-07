package com.ldx.dao.export;


import java.util.List;

import com.ldx.domain.export.Module;
import com.ldx.domain.export.ModuleExample;
import org.apache.ibatis.annotations.Param;

public interface ModuleDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table module
     *
     * @mbg.generated
     */
    long countByExample(ModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table module
     *
     * @mbg.generated
     */
    int deleteByExample(ModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table module
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String moduleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table module
     *
     * @mbg.generated
     */
    int insert(Module record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table module
     *
     * @mbg.generated
     */
    int insertSelective(Module record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table module
     *
     * @mbg.generated
     */
    List<Module> selectByExample(ModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table module
     *
     * @mbg.generated
     */
    Module selectByPrimaryKey(String moduleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table module
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Module record, @Param("example") ModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table module
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Module record, @Param("example") ModuleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table module
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Module record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table module
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Module record);
}