package bean.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.DBBean;
import bean.vo.GoodsVo;

public class GoodsDAO {

	int numberPage = 2;

	public ArrayList getGoodsByPage(int pageNo) {
		ArrayList goodsList = null;

		DBBean db = new DBBean();
		Connection con = db.getConnection();
		ResultSet rs = null;

		try {
			rs = db.exectueQuery("select * from goods limit " + (pageNo - 1)
					* 2 + "," + numberPage, null);

			if (rs != null) {
				goodsList = new ArrayList();
				while (rs.next()) {
					GoodsVo g = new GoodsVo();
					g.setGoodsId(rs.getString("goodsid"));
					g.setGoodsName(rs.getString("goodsname"));
					g.setPrice(rs.getFloat("price"));
					goodsList.add(g);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return goodsList;
	}

	public GoodsVo getGoodsById(String goodsId) {
		GoodsVo g = null;

		DBBean db = new DBBean();
		Connection con = db.getConnection();
		ResultSet rs = null;
		ArrayList params = new ArrayList();
		params.add(goodsId);
		try {
			rs = db.exectueQuery("select * from goods where goodsid = ?",
					params);
			if (rs != null) {
				rs.next();
				g = new GoodsVo();
				g.setGoodsId(rs.getString("goodsid"));
				g.setGoodsName(rs.getString("goodsname"));
				g.setPrice(rs.getFloat("price"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
	}

}
