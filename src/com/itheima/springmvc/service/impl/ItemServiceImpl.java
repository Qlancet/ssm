package com.itheima.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.springmvc.mapper.ItemsMapper;
import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.pojo.ItemsExample;
import com.itheima.springmvc.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private  ItemsMapper itemsMapper;
	
	//商品列表展示
	@Override
	public List<Items> getItemList() {
		ItemsExample example = new  ItemsExample();
		List<Items> list = itemsMapper.selectByExampleWithBLOBs(example);
		return list;
	}


	//商品修改
	@Override
	public Items getItemById(int id) {
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}


	//商品提交 pojo的方式
	@Override
	public void updateItem(Items Item) {
		
		//是否有text格式的
		//itemsMapper.updateByPrimaryKeyWithBLOBs(Item)
		//判断提交的数据是否为空,如果为空就不更新
		itemsMapper.updateByPrimaryKeySelective(Item);
	}
}
