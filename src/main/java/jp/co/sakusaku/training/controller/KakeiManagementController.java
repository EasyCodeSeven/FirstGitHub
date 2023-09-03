package jp.co.sakusaku.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sakusaku.training.entity.Kakei;
import jp.co.sakusaku.training.form.KakeiForm;
import jp.co.sakusaku.training.repository.KakeiRepository;

@Controller
public class KakeiManagementController {

	@Autowired
	KakeiRepository kakeiRepository;

	/**
	 * 新規作成を行う画面の初期画面を表示するGETメソッド
	 * @param model
	 * @return 遷移先：新規登録画面
	 */
	@RequestMapping(value = "kakeimanagement", method = RequestMethod.GET)
	public String index(Model model) {
		KakeiForm kakeiForm = new KakeiForm();
		model.addAttribute(kakeiForm);
		return "kakeimanagement";
	}

	/**
	 * レコードの新規作成および更新を行うPOSTメソッド
	 * @param model
	 * @param kakeiForm
	 * @return 遷移先：家計リスト画面
	 */
	@RequestMapping(value = "operation", params = "create", method = RequestMethod.POST)
	public String create(Model model, KakeiForm kakeiForm) {

		Kakei kakei = new Kakei();
		kakei.setCharge(kakeiForm.getCharge());
		kakei.setClearance(kakeiForm.getClearance());
		//最新のレコードにおける計算後残高を取得してbfCalculationに格納
		kakei.setBfCalculation(kakeiRepository.findAfCalById().getAfCalculation());
		//残高から使用金額を引いた値を格納
		kakei.setAfCalculation(kakei.getBfCalculation() - kakeiForm.getCharge());
		kakeiRepository.insertRecord(kakei);

		return "redirect:/kakei";
	}
}
