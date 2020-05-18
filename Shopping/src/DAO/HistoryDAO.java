package DAO;

import java.util.List;

import model.History;

public interface HistoryDAO {
	public List<History> getHistory(String user_id);
}
