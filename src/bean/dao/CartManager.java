package bean.dao;

import java.util.ArrayList;
import java.util.Iterator;

import bean.vo.GoodsVo;
import bean.vo.Item;

public class CartManager {
	private ArrayList<Item> cart = new ArrayList<Item>();

	public ArrayList<Item> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Item> cart) {
		this.cart = cart;
	}
	
	public void addToCart(String goodsId,int count){
		boolean foundFlag = false;
		if(cart != null){
			Iterator<Item> it = cart.iterator();
			while(it.hasNext()){
				Item oneItem = it.next();
				if(oneItem.getGoods().getGoodsId().equals(goodsId)){
					oneItem.setCount(oneItem.getCount() + count);
					foundFlag = true;
				}
			}
		}//while
		
		if(foundFlag = false){
			Item newItem = new Item();
			newItem.setCount(count);
			GoodsDAO gd = new GoodsDAO();
			GoodsVo newG = gd.getGoodsById(goodsId);
			newItem.setGoods(newG);
			
			this.getCart().add(newItem);
		}
		
	}
	
	

}
