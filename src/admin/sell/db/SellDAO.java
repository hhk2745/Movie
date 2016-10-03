package admin.sell.db;

import java.util.Map;

public interface SellDAO {
	public int countMonth(String date);
	public int countYear(String date);
	public int countMovies(String title);
	public int sellMode(String mode,String date);
	public int sellMovieMode(String mode,Map<String, String> map);

}
