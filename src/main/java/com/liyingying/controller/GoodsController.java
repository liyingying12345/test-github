package com.liyingying.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyingying.beans.Category;
import com.liyingying.beans.Goods;
import com.liyingying.service.GoodsService;

@Controller
public class GoodsController {

	@Resource
	private GoodsService goodsService;
	
	@RequestMapping("findAll")
	public String findAll(String gname, String startTime, String endTime, Integer cid,
			Model model, @RequestParam(defaultValue="1")Integer pageNum){
		System.out.println(gname);
		System.out.println(startTime);
		System.out.println(endTime);
		System.out.println(cid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gname", gname);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("cid", cid);
		PageHelper.startPage(pageNum, 3);
		List<Goods> list = goodsService.queryGoodsAll(map);
		PageInfo<Goods> page = new PageInfo<Goods>(list);
		model.addAttribute("page", page);
		model.addAttribute("map", map);
		return "index";
	}
	
	@RequestMapping("queryCategory")
	@ResponseBody
	public List<Category> queryCategory(){
		List<Category> list = goodsService.queryCategory();
		return list;
	}
	
	@RequestMapping("addGoods")
	@ResponseBody
	public boolean addGgoods(Goods goods){
		try {
			goodsService.addGoods(goods);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@RequestMapping("toUpdate")
	public String toUpdate(Integer gid,Model model){
		Goods goods = goodsService.queryGoodsById(gid);
		model.addAttribute("goods", goods);
		return "update";
	}
	
	@RequestMapping("updateGoods")
	@ResponseBody
	public boolean updateGgoods(Goods goods){
		try {
			goodsService.updateGoods(goods);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
