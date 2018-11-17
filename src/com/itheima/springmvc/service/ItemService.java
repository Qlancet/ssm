package com.itheima.springmvc.service;

import java.util.List;

import com.itheima.springmvc.pojo.Items;

public interface ItemService {

	//查询商品列表
	List<Items> getItemList();
	
	//商品修改  /itemEdit.action?id=${item.id}">修改</a></td>
	Items getItemById(int id);
	
	//表单提交  pojo的方式进行提交
	void updateItem(Items Item );
}
