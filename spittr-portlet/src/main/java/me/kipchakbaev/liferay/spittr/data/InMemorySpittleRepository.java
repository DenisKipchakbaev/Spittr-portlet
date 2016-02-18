package me.kipchakbaev.liferay.spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import me.kipchakbaev.liferay.spittr.Spittle;

@Repository
public class InMemorySpittleRepository implements SpittleRepository {

	List<Spittle> spittleList = new ArrayList<>();
	
	@Override
	public List<Spittle> findSpittles(long max, int count) {
		
		return generateSpittleList();
	}

	@Override
	public List<Spittle> findRecentSpittles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spittle findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Spittle spittle) {
		spittleList.add(spittle);
	}
	
	private List<Spittle> generateSpittleList() {
		Spittle spittle = new Spittle("Test message", new Date());
		Spittle spittle2 = new Spittle("Testing 2", new Date());
		Spittle spittle3 = new Spittle("Testing 3", new Date());
		
		spittleList.add(spittle);
		spittleList.add(spittle2);
		spittleList.add(spittle3);
		
		return spittleList;
		
	}

}
