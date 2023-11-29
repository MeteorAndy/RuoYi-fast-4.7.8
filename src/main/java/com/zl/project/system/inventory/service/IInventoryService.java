package com.zl.project.system.inventory.service;

import java.util.List;
import com.zl.project.system.inventory.domain.Inventory;

/**
 * 库存管理Service接口
 * 
 * @author ruoyi
 * @date 2023-11-24
 */
public interface IInventoryService 
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
     * 批量删除库存管理
     * 
     * @param BookIDs 需要删除的库存管理主键集合
     * @return 结果
     */
    public int deleteInventoryByBookIDs(String BookIDs);

    /**
     * 删除库存管理信息
     * 
     * @param BookID 库存管理主键
     * @return 结果
     */
    public int deleteInventoryByBookID(Long BookID);
}
