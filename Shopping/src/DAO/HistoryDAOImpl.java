package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DoanhSo;
import model.History;
import model.MyConnectDB;

public class HistoryDAOImpl implements HistoryDAO {

	@Override
	public List<History> getHistory(String user_id) {
		Connection cnn = MyConnectDB.getConnecttion();
		String sql = "select [History].order_id from [Order], [History] where [History].order_id = [Order].order_id and "
				+ "[Order].user_id = N'"+user_id+"'";
		List<History> list = new ArrayList<History>();
		try {
			ResultSet rst = MyConnectDB.chonDuLieu(sql);
			while(rst.next()) {
				String order_id = rst.getString(1);
				list.add(new History(order_id,user_id));
			}
			cnn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<DoanhSo> getListProduct(String order_id){
		List<DoanhSo> list = new ArrayList<DoanhSo>();
		String sql = "select [Order_List].MaSP,[Product].TenSP,[Order_List].soluong,[Order_List].price"
				+ "   from [Order_List],[Product] where [Order_List].order_id ="+order_id+
				"and [Order_List].MaSP = [Product].MaSP";
		ResultSet rs;
		try {
			rs = MyConnectDB.chonDuLieu(sql);
			while(rs.next()){
				String maSP = rs.getString(1);
				String tenSP = rs.getNString(2);
				int soluong = rs.getInt(3);
				int price = rs.getInt(4);
				list.add(new DoanhSo(maSP,tenSP,soluong,price));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		List<History> h = new ArrayList<History>();
		HistoryDAOImpl t = new HistoryDAOImpl();
		h = t.getHistory("hang");
		System.out.println(h.get(0).order_id);
	}

}
