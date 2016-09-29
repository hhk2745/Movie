package admin.sell.db;

import java.util.List;

public interface SellDAO {
	public int countMonth(String date);
	public int countYear(String date);
	public int countMovies(String title);

}
