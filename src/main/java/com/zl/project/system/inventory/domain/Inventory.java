package com.zl.project.system.inventory.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zl.framework.aspectj.lang.annotation.Excel;
import com.zl.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 库存管理对象 inventory
 * 
 * @author ruoyi
 * @date 2023-11-24
 */
public class Inventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图书ID */
    @Excel(name = "图书ID")
    private Long BookID;

    /** 是否在库 */
    @Excel(name = "是否在库")
    private Integer InStock;

    /** 是否被借阅 */
    @Excel(name = "是否被借阅")
    private Integer Borrowed;

    /** 预计归还日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计归还日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date ExpectedReturnDate;

    public void setBookID(Long BookID)
    {
        this.BookID = BookID;
    }

    public Long getBookID()
    {
        return BookID;
    }
    public void setInStock(Integer InStock)
    {
        this.InStock = InStock;
    }

    public Integer getInStock()
    {
        return InStock;
    }
    public void setBorrowed(Integer Borrowed)
    {
        this.Borrowed = Borrowed;
    }

    public Integer getBorrowed()
    {
        return Borrowed;
    }
    public void setExpectedReturnDate(Date ExpectedReturnDate)
    {
        this.ExpectedReturnDate = ExpectedReturnDate;
    }

    public Date getExpectedReturnDate()
    {
        return ExpectedReturnDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("BookID", getBookID())
            .append("InStock", getInStock())
            .append("Borrowed", getBorrowed())
            .append("ExpectedReturnDate", getExpectedReturnDate())
            .toString();
    }
}
