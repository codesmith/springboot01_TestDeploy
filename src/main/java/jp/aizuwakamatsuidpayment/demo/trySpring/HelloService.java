package jp.aizuwakamatsuidpayment.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// コントローラークラスなどと同様にサービスクラスには@Serviceアノテーションを付ける
@Service
public class HelloService {

  // HelloRepositoryクラスを使うために@Autowiredを付けている
  // イメージ→ private HelloRepository helloRepository = new HelloRepository();
  @Autowired
  private HelloRepository helloRepository;

  // DTO(Employeeクラス)を先に作成しておく必要がある。
  public Employee findOne(int id) {

    // １件検索実行
    Map<String, Object> map = helloRepository.findOne(id);

    // Mapから値を取得
    // map.get(<キー名>); のキー名にはSQLで指定したテーブルの属性名が入るイメージ
    int employeeId = (Integer) map.get("employee_id");
    String employeeName = (String) map.get("employee_name");
    int age = (Integer) map.get("age");

    // Employeeクラスに値をセット
    Employee employee = new Employee();
    employee.setEmployeeId(employeeId);
    employee.setEmployeeName(employeeName);
    employee.setAge(age);

    return employee;
  }
}
