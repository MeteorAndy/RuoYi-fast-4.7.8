package com.zl.project.system.borrowrecords.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zl.framework.aspectj.lang.annotation.Excel;
import com.zl.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 图书借阅对象 borrowrecords
 * 
 * @author ruoyi
 * @date 2023-11-24
 */
public class Borrowrecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 借阅记录ID */
    private Long RecordID;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long UserID;

    /** 图书ID */
    @Excel(name = "图书ID")
    private Long BookID;

    /** 借阅日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "借阅日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date BorrowDate;

    /** 预计归还日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计归还日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date ExpectedReturnDate;

    /** 实际归还日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际归还日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date ActualReturnDate;

    /** 是否逾期 */
    @Excel(name = "是否逾期")
    private Integer Overdue;

    public void setRecordID(Long RecordID)
    {
        this.RecordID = RecordID;
    }

    public Long getRecordID()
    {
        return RecordID;
    }
    public void setUserID(Long UserID)
    {
        this.UserID = UserID;
    }

    public Long getUserID()
    {
        return UserID;
    }
    public void setBookID(Long BookID)
    {
        this.BookID = BookID;
    }

    public Long getBookID()
    {
        return BookID;
    }
    public void setBorrowDate(Date BorrowDate)
    {
        this.BorrowDate = BorrowDate;
    }

    public Date getBorrowDate()
    {
        return BorrowDate;
    }
    public void setExpectedReturnDate(Date ExpectedReturnDate)
    {
        this.ExpectedReturnDate = ExpectedReturnDate;
    }

    public Date getExpectedReturnDate()
    {
        return ExpectedReturnDate;
    }
    public void setActualReturnDate(Date ActualReturnDate)
    {
        this.ActualReturnDate = ActualReturnDate;
    }

    public Date getActualReturnDate()
    {
        return ActualReturnDate;
    }
    public void setOverdue(Integer Overdue)
    {
        this.Overdue = Overdue;
    }

    public Integer getOverdue()
    {
        return Overdue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("RecordID", getRecordID())
            .append("UserID", getUserID())
            .append("BookID", getBookID())
            .append("BorrowDate", getBorrowDate())
            .append("ExpectedReturnDate", getExpectedReturnDate())
            .append("ActualReturnDate", getActualReturnDate())
            .append("Overdue", getOverdue())
            .toString();
    }
}
