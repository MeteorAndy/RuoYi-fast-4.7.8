package com.zl.project.system.books.controller;

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
import com.zl.project.system.books.domain.Books;
import com.zl.project.system.books.service.IBooksService;
import com.zl.framework.web.controller.BaseController;
import com.zl.framework.web.domain.AjaxResult;
import com.zl.common.utils.poi.ExcelUtil;
import com.zl.framework.web.page.TableDataInfo;

/**
 * 图书管理Controller
 * 
 * @author 王禧龙
 * @date 2023-11-24
 */
@Controller
@RequestMapping("/system/books")
public class BooksController extends BaseController
{
    private String prefix = "system/books";

    @Autowired
    private IBooksService booksService;

    @RequiresPermissions("system:books:view")
    @GetMapping()
    public String books()
    {
        return prefix + "/books";
    }

    /**
     * 查询图书管理列表
     */
    @RequiresPermissions("system:books:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Books books)
    {
        startPage();
        List<Books> list = booksService.selectBooksList(books);
        return getDataTable(list);
    }

    /**
     * 导出图书管理列表
     */
    @RequiresPermissions("system:books:export")
    @Log(title = "图书管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Books books)
    {
        List<Books> list = booksService.selectBooksList(books);
        ExcelUtil<Books> util = new ExcelUtil<Books>(Books.class);
        return util.exportExcel(list, "图书管理数据");
    }

    /**
     * 新增图书管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存图书管理
     */
    @RequiresPermissions("system:books:add")
    @Log(title = "图书管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Books books)
    {
        return toAjax(booksService.insertBooks(books));
    }

    /**
     * 修改图书管理
     */
    @RequiresPermissions("system:books:edit")
    @GetMapping("/edit/{BookID}")
    public String edit(@PathVariable("BookID") Long BookID, ModelMap mmap)
    {
        Books books = booksService.selectBooksByBookID(BookID);
        mmap.put("books", books);
        return prefix + "/edit";
    }

    /**
     * 修改保存图书管理
     */
    @RequiresPermissions("system:books:edit")
    @Log(title = "图书管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Books books)
    {
        return toAjax(booksService.updateBooks(books));
    }

    /**
     * 删除图书管理
     */
    @RequiresPermissions("system:books:remove")
    @Log(title = "图书管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(booksService.deleteBooksByBookIDs(ids));
    }
}
