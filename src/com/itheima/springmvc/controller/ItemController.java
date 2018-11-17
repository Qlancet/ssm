package com.itheima.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/itemList")
	public ModelAndView getItemList() {
		List<Items> list = itemService.getItemList();
		// 结果传递给页面
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList", list);
		modelAndView.setViewName("itemList");
		return modelAndView;
	}

	/// itemEdit.action?id=${item.id}">修改</a></td>
	/**
	 * @RequestMapping("/itemEdit") public ModelAndView
	 * geteditItem(HttpServletRequest request) { // 从request中获取参数 String strId =
	 * request.getParameter("id"); int id = new Integer(strId); Items item =
	 * itemService.getItemById(id); ModelAndView modelAndView = new
	 * ModelAndView(); //modelAndView.addObject(item);
	 * modelAndView.addObject("item", item);
	 * modelAndView.setViewName("editItem"); return modelAndView; }
	 * 
	 * 
	 * @RequestMapping("/itemEdit") public String geteditItem(HttpServletRequest
	 * request,Model model) { // 从request中获取参数 String strId =
	 * request.getParameter("id"); int id = new Integer(strId); Items item =
	 * itemService.getItemById(id); model.addAttribute("item", item); return
	 * "editItem"; }
	 **/

	@RequestMapping("/itemEdit")
	public String geteditItem(@RequestParam(required = false, value = "id", defaultValue = "1") Integer ids,
			Model model) {
		Items item = itemService.getItemById(ids);
		model.addAttribute("item", item);
		return "editItem";
	}

	// 表单提交 pojo方式提交
	@RequestMapping("/updateitem")
	public String updateIttem(Items Item) {
		itemService.updateItem(Item); 
		//返回成功页面
		return "success";
	}
}
