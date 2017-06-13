package ru.project.currency.rates.data.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ru.project.currency.rates.data.dao.BaseRepository;
import ru.project.currency.rates.data.dao.RedisRepository;
import ru.project.currency.rates.utils.UniCast;
import ru.project.currency.rates.xml.model.Valute;

@Repository
@Service
public class XmlRedisRepository extends BaseRepository implements RedisRepository<Valute> {

	private final static String KEY = "XML";

	@Override
	public void saveAllValutes(List<Valute> valutes) {
		valutes.forEach(valute -> this.hashOps.put(KEY, valute.getID(), valute));
	}

	@Override
	public void saveValute(Valute valute) {
		this.hashOps.put(KEY, valute.getID(), valute);
	}

	@Override
	public Valute getValute(String id) {
		return UniCast.cast(Valute.class, this.hashOps.get(KEY, id));
	}

	@Override
	public List<Valute> getAllValutes() {
		return this.hashOps.entries(KEY).entrySet().parallelStream()
				.map(entry -> UniCast.cast(Valute.class, entry.getValue())).collect(Collectors.toList());
	}

	@Override
	public void removeValute(String id) {
		this.hashOps.delete(KEY, id);
	}

	@Override
	public void removeValutes(Iterable<String> ids) {
		this.hashOps.delete(KEY, ids);
	}

}
