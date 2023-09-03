package jp.co.sakusaku.training.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sakusaku.training.entity.Kakei;

@Repository
public class KakeiRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * DBの全てのレコードを取得するメソッドを作成
	 * @return List<Kakei>
	 */
	public List<Kakei> findAll() {
		final String SELECT_SQL = "select id, charge, bf_calculation, af_calculation, clearance, record_date, check_date from kakei";
		return jdbcTemplate.query(
				SELECT_SQL, new BeanPropertyRowMapper<Kakei>(Kakei.class));
	}

	/**
	 * 最新のidにおける計算後残高（af_calculation）を取得する
	 * @return Kakei
	 */
	public Kakei findAfCalById() {
		final String SELECT_SQL = "select af_calculation from kakei where id = (select max(id)from kakei)";
		return jdbcTemplate.queryForObject(
				SELECT_SQL, new BeanPropertyRowMapper<Kakei>(Kakei.class));
	}

	/**
	 * 新しレコードを挿入するメソッドを作成
	 */
	public int insertRecord(Kakei kakei) {
		final String INSERT_SQL = "insert into kakei(charge, bf_calculation, af_calculation, clearance, record_date) "
				+ "values (:charge, :bfCalculation, :afCalculation, :clearance, current_timestamp)";

		try {
			SqlParameterSource param = new BeanPropertySqlParameterSource(kakei);
			return jdbcTemplate.update(INSERT_SQL, param);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * レコードを削除するメソッドを作成
	 */
	public int deleteById(Integer id) {
		final String DELETE_SQL = "delete from kakei where id = :id";

		Kakei kakei = new Kakei();
		kakei.setId(id);

		try {
			SqlParameterSource paramMap = new BeanPropertySqlParameterSource(kakei);
			return jdbcTemplate.update(DELETE_SQL, paramMap);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
