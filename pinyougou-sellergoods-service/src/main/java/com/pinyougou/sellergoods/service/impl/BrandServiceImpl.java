package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<TbBrand> findAll() {

        return tbBrandMapper.selectByExample(null);   //返回全部列表
    }

    /**
     * 进行分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        //按照传的参数进行分页
        PageHelper.startPage(pageNum, pageSize);
        //返回值为page对象
        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(null);
        //将返回值封装到自定义的pageResult对象中
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 根据传进去的条件进行分页查询
     * @param tbBrand  传入的查询条件，因为传进去的条件个数可能不一致所以直接将对象传进去
     * @param page  当前页
     * @param size   每页显示条数
     * @return
     */
    @Override
    public PageResult findPage(TbBrand tbBrand, int page, int size) {
        //按照传的参数进行分页
        PageHelper.startPage(page, size);
        //将查询条件封装成一个对象
        TbBrandExample tbBrandExample = new TbBrandExample();

        TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();
        if (tbBrand != null){
            if (tbBrand.getName()!=null && tbBrand.getName().length()>0){
                //构造条件：根据品牌名称进行模糊查询
                criteria.andNameLike("%"+tbBrand.getName()+"%");
            }
            if (tbBrand.getFirstChar()!=null && tbBrand.getFirstChar().length()>0){
                //构造条件：根据首字母进行模糊查询
                criteria.andFirstCharLike("%"+tbBrand.getFirstChar()+"%");
            }
        }
        //返回值为page对象
        Page<TbBrand> page1 = (Page<TbBrand>) tbBrandMapper.selectByExample(tbBrandExample);
        //将返回值封装到自定义的pageResult对象中
        return new PageResult(page1.getTotal(),page1.getResult());
    }

    /**
     * 添加品牌
     * @param tbBrand
     */
    @Override
    public void add(TbBrand tbBrand) {
        tbBrandMapper.insert(tbBrand);
    }

    /**
     * 根据id进行查询
     * @param id
     */
    @Override
    public TbBrand findOne(Long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新一个对象
     * @param tbBrand
     */
    @Override
    public void update(TbBrand tbBrand) {
        tbBrandMapper.updateByPrimaryKey(tbBrand);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }


}
