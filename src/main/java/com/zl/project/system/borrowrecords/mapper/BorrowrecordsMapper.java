package com.zl.project.system.borrowrecords.mapper;

import java.util.List;
import com.zl.project.system.borrowrecords.domain.Borrowrecords;

/**
 * 图书借阅Mapper接口
 * 
 * @author ruoyi
 * @date 2023-11-24
 */
public interface BorrowrecordsMapper 
{
    /**
     * 查询图书借阅
     * 
     * @param RecordID 图书借阅主键
     * @return 图书借阅
     */
    public Borrowrecords selectBorrowrecordsByRecordID(Long RecordID);

    /**
     * 查询图书借阅列表
     * 
     * @param borrowrecords 图书借阅
     * @return 图书借阅集合
     */
    public List<Borrowrecords> selectBorrowrecordsList(Borrowrecords borrowrecords);

    /**
     * 新增图书借阅
     * 
     * @param borrowrecords 图书借阅
     * @return 结果
     */
    public int insertBorrowrecords(Borrowrecords borrowrecords);

    /**
     * 修改图书借阅
     * 
     * @param borrowrecords 图书借阅
     * @return 结果
     */
    public int updateBorrowrecords(Borrowrecords borrowrecords);

    /**
     * 删除图书借阅
     * 
     * @param RecordID 图书借阅主键
     * @return 结果
     */
    public int deleteBorrowrecordsByRecordID(Long RecordID);

    /**
     * 批量删除图书借阅
     * 
     * @param RecordIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBorrowrecordsByRecordIDs(String[] RecordIDs);
}
