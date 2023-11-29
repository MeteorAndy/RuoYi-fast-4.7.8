package com.zl.project.system.borrowrecords.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zl.project.system.borrowrecords.mapper.BorrowrecordsMapper;
import com.zl.project.system.borrowrecords.domain.Borrowrecords;
import com.zl.project.system.borrowrecords.service.IBorrowrecordsService;
import com.zl.common.utils.text.Convert;

/**
 * 图书借阅Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-11-24
 */
@Service
public class BorrowrecordsServiceImpl implements IBorrowrecordsService 
{
    @Autowired
    private BorrowrecordsMapper borrowrecordsMapper;

    /**
     * 查询图书借阅
     * 
     * @param RecordID 图书借阅主键
     * @return 图书借阅
     */
    @Override
    public Borrowrecords selectBorrowrecordsByRecordID(Long RecordID)
    {
        return borrowrecordsMapper.selectBorrowrecordsByRecordID(RecordID);
    }

    /**
     * 查询图书借阅列表
     * 
     * @param borrowrecords 图书借阅
     * @return 图书借阅
     */
    @Override
    public List<Borrowrecords> selectBorrowrecordsList(Borrowrecords borrowrecords)
    {
        return borrowrecordsMapper.selectBorrowrecordsList(borrowrecords);
    }

    /**
     * 新增图书借阅
     * 
     * @param borrowrecords 图书借阅
     * @return 结果
     */
    @Override
    public int insertBorrowrecords(Borrowrecords borrowrecords)
    {
        return borrowrecordsMapper.insertBorrowrecords(borrowrecords);
    }

    /**
     * 修改图书借阅
     * 
     * @param borrowrecords 图书借阅
     * @return 结果
     */
    @Override
    public int updateBorrowrecords(Borrowrecords borrowrecords)
    {
        return borrowrecordsMapper.updateBorrowrecords(borrowrecords);
    }

    /**
     * 批量删除图书借阅
     * 
     * @param RecordIDs 需要删除的图书借阅主键
     * @return 结果
     */
    @Override
    public int deleteBorrowrecordsByRecordIDs(String RecordIDs)
    {
        return borrowrecordsMapper.deleteBorrowrecordsByRecordIDs(Convert.toStrArray(RecordIDs));
    }

    /**
     * 删除图书借阅信息
     * 
     * @param RecordID 图书借阅主键
     * @return 结果
     */
    @Override
    public int deleteBorrowrecordsByRecordID(Long RecordID)
    {
        return borrowrecordsMapper.deleteBorrowrecordsByRecordID(RecordID);
    }
}
