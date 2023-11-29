package com.zl.project.system.books.service;

import java.util.List;
import com.zl.project.system.books.domain.Books;

/**
 * 图书管理Service接口
 * 
 * @author 王禧龙
 * @date 2023-11-24
 */
public interface IBooksService 
{
    /**
     * 查询图书管理
     * 
     * @param BookID 图书管理主键
     * @return 图书管理
     */
    public Books selectBooksByBookID(Long BookID);

    /**
     * 查询图书管理列表
     * 
     * @param books 图书管理
     * @return 图书管理集合
     */
    public List<Books> selectBooksList(Books books);

    /**
     * 新增图书管理
     * 
     * @param books 图书管理
     * @return 结果
     */
    public int insertBooks(Books books);

    /**
     * 修改图书管理
     * 
     * @param books 图书管理
     * @return 结果
     */
    public int updateBooks(Books books);

    /**
     * 批量删除图书管理
     * 
     * @param BookIDs 需要删除的图书管理主键集合
     * @return 结果
     */
    public int deleteBooksByBookIDs(String BookIDs);

    /**
     * 删除图书管理信息
     * 
     * @param BookID 图书管理主键
     * @return 结果
     */
    public int deleteBooksByBookID(Long BookID);
}
