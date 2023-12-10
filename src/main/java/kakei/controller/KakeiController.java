package kakei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kakei.entity.Kakei;
import kakei.form.KakeiForm;
import kakei.repository.KakeiRepository;

@Controller
public class KakeiController {

	@Autowired
	KakeiRepository kakeiRepository;

	/**
	 * 初期画面にStringメソッドをマッピングするGETメソッド（完了）
	 * @param model
	 * @return 遷移先：家計リスト画面
	 */
	@GetMapping(value = "kakei")
	public String index(Model model) {

		//Formの初期値を生成
		KakeiForm kakeiForm = new KakeiForm();
		model.addAttribute(kakeiForm);

		//DBのレコード一覧をListで取得
		List<Kakei> kakeiList = kakeiRepository.findAll();
		model.addAttribute(kakeiList);

		return "kakei";
	}

	/**
	 * 清算ボタン押下後に清算済みに変更（途中）
	 * @param model
	 * @return 遷移先：家計リスト画面
	 */
	@PostMapping(value = "operation", params = "clearance")
	public String clearance(@RequestParam Integer id, Model model, KakeiForm kakeiForm) {

		//清算ボタンがあるレコードの情報を取得して清算済みに変更（JavaSctript)

		return "redirect:/kakei";

	}

	/**
	 * 新規作成ボタン押下後に画面遷移するためのメソッドを作成（完了）
	 * @return 遷移先：新規登録画面
	 */
	@PostMapping(value = "operation", params = "insert")
	public String record() {
		return "redirect:/kakeimanagement";
	}

	/**
	 * 編集ボタン押下後に選択していたIdの編集画面を表示するためのメソッド
	 * @param model
	 * @return 遷移先：編集画面
	 */
	@PostMapping(value = "operation", params = "edit")
	public String edit(Model model, KakeiForm kakeiForm) {
		model.addAttribute(kakeiForm.getId());
		return "edit";
	}

	/**
	 * レコードを削除するためのメソッドを作成（完了）
	 * @param kakeiForm
	 * @return 遷移先：家計リスト画面
	 */
	@PostMapping(value = "operation", params = "delete")
	public String delete(KakeiForm kakeiForm) {

		Kakei kakei = new Kakei();
		kakei.setId(kakeiForm.getId());
		kakeiRepository.deleteById(kakeiForm.getId());

		return "kakei";
	}

	//登録されたレコードを編集するメソッドを作成（編集画面に遷移）
}
