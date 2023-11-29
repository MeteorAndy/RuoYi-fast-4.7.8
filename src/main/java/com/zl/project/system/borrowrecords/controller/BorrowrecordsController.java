package com.zl.project.system.borrowrecords.controller;

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
import com.zl.project.system.borrowrecords.domain.Borrowrecords;
import com.zl.project.system.borrowrecords.service.IBorrowrecordsService;
import com.zl.framework.web.controller.BaseController;
import com.zl.framework.web.domain.AjaxResult;
import com.zl.common.utils.poi.ExcelUtil;
import com.zl.framework.web.page.TableDataInfo;

/**
 * 图书借阅Controller
 * 
 * @author ruoyi
 * @date 2023-11-24
 */
@Controller
@RequestMapping("/system/borrowrecords")
public class BorrowrecordsController extends BaseController
{
    private String prefix = "system/borrowrecords";

    @Autowired
    private IBorrowrecordsService borrowrecordsService;

    @RequiresPermissions("system:borrowrecords:view")
    @GetMapping()
    public String borrowrecords()
    {
        return prefix + "/borrowrecords";
    }

    /**
     * 查询图书借阅列表
     */
    @RequiresPermissions("system:borrowrecords:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Borrowrecords borrowrecords)
    {
        startPage();
        List<Borrowrecords> list = borrowrecordsService.selectBorrowrecordsList(borrowrecords);
        return getDataTable(list);
    }

    /**
     * 导出图书借阅列表
     */
    @RequiresPermissions("system:borrowrecords:export")
    @Log(title = "图书借阅", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Borrowrecords borrowrecords)
    {
        List<Borrowrecords> list = borrowrecordsService.selectBorrowrecordsList(borrowrecords);
        ExcelUtil<Borrowrecords> util = new ExcelUtil<Borrowrecords>(Borrowrecords.class);
        return util.exportExcel(list, "图书借阅数据");
    }

    /**
     * 新增图书借阅
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存图书借阅
     */
    @RequiresPermissions("system:borrowrecords:add")
    @Log(title = "图书借阅", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Borrowrecords borrowrecords)
    {
        return toAjax(borrowrecordsService.insertBorrowrecords(borrowrecords));
    }

    /**
     * 修改图书借阅
     */
    @RequiresPermissions("system:borrowrecords:edit")
    @GetMapping("/edit/{RecordID}")
    public String edit(@PathVariable("RecordID") Long RecordID, ModelMap mmap)
    {
        Borrowrecords borrowrecords = borrowrecordsService.selectBorrowrecordsByRecordID(RecordID);
        mmap.put("borrowrecords", borrowrecords);
        return prefix + "/edit";
    }

    /**
     * 修改保存图书借阅
     */
    @RequiresPermissions("system:borrowrecords:edit")
    @Log(title = "图书借阅", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Borrowrecords borrowrecords)
    {
        return toAjax(borrowrecordsService.updateBorrowrecords(borrowrecords));
    }

    /**
     * 删除图书借阅
     */
    @RequiresPermissions("system:borrowrecords:remove")
    @Log(title = "图书借阅", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(borrowrecordsService.deleteBorrowrecordsByRecordIDs(ids));
    }
}
