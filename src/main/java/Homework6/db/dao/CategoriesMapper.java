package Homework6.db.dao;

import db.model.Categories;
import db.model.CategoriesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoriesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    long countByExample(CategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    int deleteByExample(CategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    int insert(Categories record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    int insertSelective(Categories record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    List<Categories> selectByExample(CategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    Categories selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    int updateByExampleSelective(@Param("record") Categories record, @Param("example") CategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    int updateByExample(@Param("record") Categories record, @Param("example") CategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    int updateByPrimaryKeySelective(Categories record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Sat Mar 04 20:53:44 VLAT 2023
     */
    int updateByPrimaryKey(Categories record);
}
