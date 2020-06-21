package com.liyingying.mapper;

import java.util.List;
import java.util.Map;

import com.liyingying.beans.Category;
import com.liyingying.beans.Goods;

public interface GoodsMapper {

	public List<Goods> queryGoodsAll(Map<String, Object> map);
	
	public List<Category> queryCategory();

	public void addGoods(Goods goods);
	
	public Goods queryGoodsById(Integer gid);

	public void updateGoods(Goods goods);
}
