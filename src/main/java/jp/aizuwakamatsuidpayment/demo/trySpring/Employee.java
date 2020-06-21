package jp.aizuwakamatsuidpayment.demo.trySpring;

import lombok.Data;

/* 
  
@Dataアノテーションを付けると、getterやsetterなどを自動で作成してくれる
これはSpringでは無くLombokの機能
Lombokには他にも便利な機能がたくさんある模様
参考：[Lombok使い方メモ](https://qiita.com/opengl-8080/items/671ffd4bf84fe5e32557) 

domainクラス(ドメインクラス)
：リポジトリクラスやサービスクラス等の間で渡すクラスのことをSpringではdomainクラスと呼ぶ
：他にはモデルクラスやDTO(Data Transfer Objet)という呼び方もある

*/
@Data
public class Employee {

  private int employeeId; // 従業員ID
  private String employeeName; // 従業員名
  private int age; // 年齢
}
