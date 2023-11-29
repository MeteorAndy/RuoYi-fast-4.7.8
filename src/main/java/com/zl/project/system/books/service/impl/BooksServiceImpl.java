package com.zl.project.system.books.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zl.project.system.books.mapper.BooksMapper;
import com.zl.project.system.books.domain.Books;
import com.zl.project.system.books.service.IBooksService;
import com.zl.common.utils.text.Convert;

/**
 * 图书管理Service业务层处理
 * 
 * @author 王禧龙
 * @date 2023-11-24
 */
@Service
public class BooksServiceImpl implements IBooksService 
{
    @Autowired
    private BooksMapper booksMapper;

    /**
     * 查询图书管理
     * 
     * @param BookID 图书管理主键
     * @return 图书管理
     */
    @Override
    public Books selectBooksByBookID(Long BookID)
    {
        return booksMapper.selectBooksByBookID(BookID);
    }

    /**
     * 查询图书管理列表
     * 
     * @param books 图书管理
     * @return 图书管理
     */
    @Override
    public List<Books> selectBooksList(Books books)
    {
        return booksMapper.selectBooksList(books);
    }

    /**
     * 新增图书管理
     * 
     * @param books 图书管理
     * @return 结果
     */
    @Override
    public int insertBooks(Books books)
    {
        return booksMapper.insertBooks(books);
    }

    /**
     * 修改图书管理
     * 
     * @param books 图书管理
     * @return 结果
     */
    @Override
    public int updateBooks(Books books)
    {
        return booksMapper.updateBooks(books);
    }

    /**
     * 批量删除图书管理
     * 
     * @param BookIDs 需要删除的图书管理主键
     * @return 结果
     */
    @Override
    public int deleteBooksByBookIDs(String BookIDs)
    {
        return booksMapper.deleteBooksByBookIDs(Convert.toStrArray(BookIDs));
    }

    /**
     * 删除图书管理信息
     * 
     * @param BookID 图书管理主键
     * @return 结果
     */
    @Override
    public int deleteBooksByBookID(Long BookID)
    {
        return booksMapper.deleteBooksByBookID(BookID);
    }
}
