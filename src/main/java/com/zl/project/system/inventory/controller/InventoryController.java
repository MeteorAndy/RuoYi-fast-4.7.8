package com.zl.project.system.inventory.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zl.framework.aspectj.lang.annotation.Log;
import com.zl.framework.aspectj.lang.enums.BusinessType;
import com.zl.project.system.inventory.domain.Inventory;
import com.zl.project.system.inventory.service.IInventoryService;
import com.zl.framework.web.controller.BaseController;
import com.zl.framework.web.domain.AjaxResult;
import com.zl.common.utils.poi.ExcelUtil;
import com.zl.framework.web.page.TableDataInfo;

/**
 * 库存管理Controller
 * 
 * @author ruoyi
 * @date 2023-11-24
 */
@Controller
@RequestMapping("/system/inventory")
public class InventoryController extends BaseController
{
    private String prefix = "system/inventory";

    @Autowired
    private IInventoryService inventoryService;

    @RequiresPermissions("system:inventory:view")
    @GetMapping()
    public String inventory()
    {
        return prefix + "/inventory";
    }

    /**
     * 查询库存管理列表
     */
    @RequiresPermissions("system:inventory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Inventory inventory)
    {
        startPage();
        List<Inventory> list = inventoryService.selectInventoryList(inventory);
        return getDataTable(list);
    }

    /**
     * 导出库存管理列表
     */
    @RequiresPermissions("system:inventory:export")
    @Log(title = "库存管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Inventory inventory)
    {
        List<Inventory> list = inventoryService.selectInventoryList(inventory);
        ExcelUtil<Inventory> util = new ExcelUtil<Inventory>(Inventory.class);
        return util.exportExcel(list, "库存管理数据");
    }

    /**
     * 新增库存管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存库存管理
     */
    @RequiresPermissions("system:inventory:add")
    @Log(title = "库存管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Inventory inventory)
    {
        return toAjax(inventoryService.insertInventory(inventory));
    }

    /**
     * 修改库存管理
     */
    @RequiresPermissions("system:inventory:edit")
    @GetMapping("/edit/{BookID}")
    public String edit(@PathVariable("BookID") Long BookID, ModelMap mmap)
    {
        Inventory inventory = inventoryService.selectInventoryByBookID(BookID);
        mmap.put("inventory", inventory);
        return prefix + "/edit";
    }

    /**
     * 修改保存库存管理
     */
    @RequiresPermissions("system:inventory:edit")
    @Log(title = "库存管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Inventory inventory)
    {
        return toAjax(inventoryService.updateInventory(inventory));
    }

    /**
     * 删除库存管理
     */
    @RequiresPermissions("system:inventory:remove")
    @Log(title = "库存管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(inventoryService.deleteInventoryByBookIDs(ids));
    }
}
