package jp.co.sakusaku.training.entity;

import java.time.LocalDate;

public class Kakei {

	//フィールドの生成
	Integer id;//ID
	Integer charge;//使用額
	Integer bfCalculation;//計算前残額
	Integer afCalculation;//計算後残額
	String clearance;//清算確認
	LocalDate recordDate;//記録日
	LocalDate checkDate;//チェック日

	public Kakei() {
	}

	//メソッドの生成
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCharge() {
		return charge;
	}

	public void setCharge(Integer charge) {
		this.charge = charge;
	}

	public Integer getBfCalculation() {
		return bfCalculation;
	}

	public void setBfCalculation(Integer bfCalculation) {
		this.bfCalculation = bfCalculation;
	}

	public Integer getAfCalculation() {
		return afCalculation;
	}

	public void setAfCalculation(Integer afCalculation) {
		this.afCalculation = afCalculation;
	}

	public String getClearance() {
		return clearance;
	}

	public void setClearance(String clearance) {
		this.clearance = clearance;
	}

	public LocalDate getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(LocalDate recordDate) {
		this.recordDate = recordDate;
	}

	public LocalDate getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(LocalDate checkDate) {
		this.checkDate = checkDate;
	}

}