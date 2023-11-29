package com.zl.project.system.inventory.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zl.project.system.inventory.mapper.InventoryMapper;
import com.zl.project.system.inventory.domain.Inventory;
import com.zl.project.system.inventory.service.IInventoryService;
import com.zl.common.utils.text.Convert;

/**
 * 库存管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-11-24
 */
@Service
public class InventoryServiceImpl implements IInventoryService 
{
    @Autowired
    private InventoryMapper inventoryMapper;

    /**
     * 查询库存管理
     * 
     * @param BookID 库存管理主键
     * @return 库存管理
     */
    @Override
    public Inventory selectInventoryByBookID(Long BookID)
    {
        return inventoryMapper.selectInventoryByBookID(BookID);
    }

    /**
     * 查询库存管理列表
     * 
     * @param inventory 库存管理
     * @return 库存管理
     */
    @Override
    public List<Inventory> selectInventoryList(Inventory inventory)
    {
        return inventoryMapper.selectInventoryList(inventory);
    }

    /**
     * 新增库存管理
     * 
     * @param inventory 库存管理
     * @return 结果
     */
    @Override
    public int insertInventory(Inventory inventory)
    {
        return inventoryMapper.insertInventory(inventory);
    }

    /**
     * 修改库存管理
     * 
     * @param inventory 库存管理
     * @return 结果
     */
    @Override
    public int updateInventory(Inventory inventory)
    {
        return inventoryMapper.updateInventory(inventory);
    }

    /**
     * 批量删除库存管理
     * 
     * @param BookIDs 需要删除的库存管理主键
     * @return 结果
     */
    @Override
    public int deleteInventoryByBookIDs(String BookIDs)
    {
        return inventoryMapper.deleteInventoryByBookIDs(Convert.toStrArray(BookIDs));
    }

    /**
     * 删除库存管理信息
     * 
     * @param BookID 库存管理主键
     * @return 结果
     */
    @Override
    public int deleteInventoryByBookID(Long BookID)
    {
        return inventoryMapper.deleteInventoryByBookID(BookID);
    }
}
