package com.zl.project.system.books.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zl.framework.aspectj.lang.annotation.Excel;
import com.zl.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 图书管理对象 books
 * 
 * @author 王禧龙
 * @date 2023-11-24
 */
public class Books extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图书ID */
    private Long BookID;

    /** 图书标题 */
    @Excel(name = "图书标题")
    private String Title;

    /** 作者 */
    @Excel(name = "作者")
    private String Author;

    /** 出版商 */
    @Excel(name = "出版商")
    private String Publisher;

    /** 出版日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出版日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date PublishDate;

    /** 国际标准书号 */
    @Excel(name = "国际标准书号")
    private String ISBN;

    /** 图书类别 */
    @Excel(name = "图书类别")
    private String Category;

    public void setBookID(Long BookID)
    {
        this.BookID = BookID;
    }

    public Long getBookID()
    {
        return BookID;
    }
    public void setTitle(String Title)
    {
        this.Title = Title;
    }

    public String getTitle()
    {
        return Title;
    }
    public void setAuthor(String Author)
    {
        this.Author = Author;
    }

    public String getAuthor()
    {
        return Author;
    }
    public void setPublisher(String Publisher)
    {
        this.Publisher = Publisher;
    }

    public String getPublisher()
    {
        return Publisher;
    }
    public void setPublishDate(Date PublishDate)
    {
        this.PublishDate = PublishDate;
    }

    public Date getPublishDate()
    {
        return PublishDate;
    }
    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }

    public String getISBN()
    {
        return ISBN;
    }
    public void setCategory(String Category)
    {
        this.Category = Category;
    }

    public String getCategory()
    {
        return Category;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("BookID", getBookID())
            .append("Title", getTitle())
            .append("Author", getAuthor())
            .append("Publisher", getPublisher())
            .append("PublishDate", getPublishDate())
            .append("ISBN", getISBN())
            .append("Category", getCategory())
            .toString();
    }
}
