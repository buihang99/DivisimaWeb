package DAO;

import java.util.List;

import model.DoanhSo;
//import model.History;
import model.Order_List;

public interface Order_ListDAO {
	public List<DoanhSo> history();
	public void addOrder_List(Order_List kh);
}
