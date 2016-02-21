package me.kipchakbaev.liferay.spittr.data;

import java.util.List;

import me.kipchakbaev.liferay.spittr.Spittle;

public interface SpittleRepository {
	
	List<Spittle> findRecentSpittles();

	List<Spittle> findSpittles(long max, int count);

	Spittle findOne(long id);

	void save(Spittle spittle);
}
