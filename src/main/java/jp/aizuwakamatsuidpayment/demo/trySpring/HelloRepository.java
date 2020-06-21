package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// Controllerクラスに@Controllerアノテーションを付けたように、
// リポジトリクラスにも@Repositoryクラスを付ける
// →こうすることでDIに登録される
@Repository
public class HelloRepository {

  // jdbcTemplate(Springが用意しているJDBC接続用のクラス)を使ってSELECT文を実行している
  // jdbcTemplateを使う場合は@Autowiredアノテーションを付ける
  // ⇒現時点では、この@Autowiredを付けることでインスタンスを生成していると考える
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public Map<String, Object> findOne(int id) {

    // SELECT文
    String query = "SELECT " + " employee_id," + " employee_name," + " age " + "FROM employee " + "WHERE employee_id=?";

    // 検索実行
    // jdbcTemplateが実際に使われているところ
    Map<String, Object> employee = jdbcTemplate.queryForMap(query, id);

    return employee;
  }
}