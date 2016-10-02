package admin.sell.db;


import java.util.Map;

import admin.sell.mybatis.SimpleExample;


public class SellDAOImpl implements SellDAO{

	@Override
	public int countMonth(String date) {
		// TODO Auto-generated method stub
		int count = 0;
		count = SimpleExample.countingMonth(date);
		return count;
	}

	@Override
	public int countYear(String date) {
		// TODO Auto-generated method stub
		return SimpleExample.countingYear(date);
	}

	@Override
	public int countMovies(String title) {
		// TODO Auto-generated method stub
		return SimpleExample.countingMovies(title);
	}
	
	@Override
	public int sellMode(String mode, String date) {
		// TODO Auto-generated method stub
		return SimpleExample.sellMode(mode, date);
	}
	
	@Override
	public int sellMovieMode(String mode, Map<String, String> map) {
		// TODO Auto-generated method stub
		return SimpleExample.sellMovieMode(mode, map);
	}

}
