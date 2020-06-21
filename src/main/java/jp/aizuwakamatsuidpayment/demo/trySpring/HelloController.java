package jp.aizuwakamatsuidpayment.demo.trySpring;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Springでは、コントローラークラスに@Controllerアノテーションを付ける
// ⇒@Controllerアノテーションを付けることでDI(依存性の注入)が利用できるようになる
@Controller
public class HelloController {

  // DBへの処理(以下、2つ目のPOSTメソッド)を実施する際にHelloServiceを呼び出しているので追加されている
  // DIコンテナがやっていること 1. インスタンスの生成 2. インスタンスのライフサイクル管理
  // ⇒クラスをnewしたり、使い終わった変数にnullを入れる必要が無くなる
  // ⇒nullの入れ忘れを防止できたり、コードの可読性が上がる
  // @Autowired
  // private HelloService helloService;

  /**
   * GET用の処理.
   */
  // @GetMappingアノテーションをメソッドに付けるとHTTPリクエストのGETメソッドを処理できるようになる
  // GETリクエストの場合、メソッド名の最初にgetを付けるのが慣習になっている。
  // メソッドの戻り値には拡張子無しのHTMLファイル名を指定する
  // ★HTMLファイルは resources\templates\フォルダからのパスを指定する
  @GetMapping("/hello")
  public String getHello() {
    // hello.htmlに画面遷移
    return "hello";
  }

  /**
   * POST用の処理.
   */
  // @PostMappingアノテーションを使うとPOSTメソッドで送られてきた場合の処理ができるようになる
  // @RequestParam
  // ：メソッドの引数に付けることで画面からの入力内容を受け取ることができる
  // ：アノテーションの引数にはhtmlのname属性の値を指定する
  // ：参考→ <input type="text name="text1"th:value="${text1_value}"/>
  @PostMapping("/hello")
  public String postRequest(@RequestParam("text1") String str, Model model) {

    // 画面から受け取った文字列をModelに登録
    // キー「sample」はThymeleaf側で呼び出す時に使用する---------------①
    model.addAttribute("sample", str);

    // helloResponse.htmlに画面遷移
    return "helloResponse";
  }

  // /**
  // * POST用の処理（DB）.
  // */
  // // @RequestParam
  // // ：メソッドの引数に付けることで画面からの入力内容を受け取ることができる
  // // ：アノテーションの引数にはhtmlのname属性の値を指定する
  // // ①遷移前ページから受け取ったtext2の情報をこのメソッド(postDbRequest)内で処理
  // // ②このメソッド(postDbRequest)のreturnとして遷移先ページを指定する
  // // ③遷移先ページに渡す情報はmodelにaddAttributeメソッドで仕込んでおく
  // @PostMapping("/hello/db")
  // public String postDbRequest(@RequestParam("text2") String str, Model model) {

  // // Stringからint型に変換
  // int id = Integer.parseInt(str);

  // // １件検索
  // Employee employee = helloService.findOne(id);

  // // 検索結果をModelに登録
  // // 検索結果をmodelオブジェクトに登録しておくことで画面側で受け取ることができるようになる
  // model.addAttribute("id", employee.getEmployeeId());
  // model.addAttribute("name", employee.getEmployeeName());
  // model.addAttribute("age", employee.getAge());

  // // helloResponseDB.htmlに画面遷移
  // return "helloResponseDB";
  // }
}
