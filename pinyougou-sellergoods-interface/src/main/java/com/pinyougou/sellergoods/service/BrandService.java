package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;

/**
 * 品牌接口
 */
public interface BrandService {

    /**
     * 查看全部品牌
     * @return
     */
    public List<TbBrand> findAll();

    /**
     * 返回分页列表
     * @return
     */
    public PageResult findPage(int pageNum,int pageSize);

    /**
     * 按条件进行分页查询
     * @param tbBrand  传入的查询条件，因为传进去的条件个数可能不一致所以直接将对象传进去
     * @param page  当前页
     * @param size   每页显示条数
     * @return
     */
    public PageResult findPage(TbBrand tbBrand, int page,int size);

    /**
     * 添加品牌
     * @param tbBrand
     */
    public void add(TbBrand tbBrand);

    /**
     * 根据id值进行查询对象
     * @param id
     * @return
     */
    public TbBrand findOne(Long id);

    /**
     * 修改一个品牌
     * @param tbBrand
     */
    public void update(TbBrand tbBrand);

    /**
     * 批量删除
     * @param ids
     */
    public void delete(Long[] ids);



}
