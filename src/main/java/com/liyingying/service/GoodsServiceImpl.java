package com.liyingying.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liyingying.beans.Category;
import com.liyingying.beans.Goods;
import com.liyingying.mapper.GoodsMapper;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Resource
	private GoodsMapper goodsMapper;
	
	public List<Goods> queryGoodsAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return goodsMapper.queryGoodsAll(map);
	}

	@Override
	public List<Category> queryCategory() {
		// TODO Auto-generated method stub
		return goodsMapper.queryCategory();
	}

	@Override
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.addGoods(goods);
	}

	@Override
	public Goods queryGoodsById(Integer gid) {
		// TODO Auto-generated method stub
		return goodsMapper.queryGoodsById(gid);
	}

	@Override
	public void updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.updateGoods(goods);
	}

}
