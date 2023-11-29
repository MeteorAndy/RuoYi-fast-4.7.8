package com.zl.project.system.inventory.mapper;

import java.util.List;
import com.zl.project.system.inventory.domain.Inventory;

/**
 * 库存管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-11-24
 */
public interface InventoryMapper 
{
    /**
     * 查询库存管理
     * 
     * @param BookID 库存管理主键
     * @return 库存管理
     */
    public Inventory selectInventoryByBookID(Long BookID);

    /**
     * 查询库存管理列表
     * 
     * @param inventory 库存管理
     * @return 库存管理集合
     */
    public List<Inventory> selectInventoryList(Inventory inventory);

    /**
     * 新增库存管理
     * 
     * @param inventory 库存管理
     * @return 结果
     */
    public int insertInventory(Inventory inventory);

    /**
     * 修改库存管理
     * 
     * @param inventory 库存管理
     * @return 结果
     */
    public int updateInventory(Inventory inventory);

    /**
     * 删除库存管理
     * 
     * @param BookID 库存管理主键
     * @return 结果
     */
    public int deleteInventoryByBookID(Long BookID);

    /**
     * 批量删除库存管理
     * 
     * @param BookIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInventoryByBookIDs(String[] BookIDs);
}
