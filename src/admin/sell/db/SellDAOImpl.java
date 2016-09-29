package admin.sell.db;


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

}
