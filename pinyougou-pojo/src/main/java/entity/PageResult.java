package entity;

import com.pinyougou.pojo.TbBrand;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果实体类
 */
public class PageResult implements Serializable {
    //总记录数
    private Long total;
    //每页显示的内容
    private List<TbBrand> rows;

    public PageResult(Long total, List<TbBrand> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<TbBrand> getRows() {
        return rows;
    }

    public void setRows(List<TbBrand> rows) {
        this.rows = rows;
    }
}
