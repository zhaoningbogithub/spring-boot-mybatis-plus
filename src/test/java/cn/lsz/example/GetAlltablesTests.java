package cn.lsz.example;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetAlltablesTests {

	@Autowired
	@Qualifier("sqlSessionFactory")
	SqlSessionFactory sqlSessionFactory;

	@Test
	/*
	* 查询所有表名，做网页版代码生成器可以使用这个做个下拉框选择表GetAlltablesTests
	* */
	public void contextLoads() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			List<String> tables = new ArrayList<>();
			Connection conn =sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection();
			DatabaseMetaData dbmd = conn.getMetaData();
			String database = conn.getCatalog();
			ResultSet rs = dbmd.getTables(database, null, null, new String[]{"TABLE"});
			while (rs.next()) {
				tables.add(rs.getString("TABLE_NAME"));
			}
			conn.close();

			tables.forEach(name->{
				System.out.println(name);
			});
		} catch (SQLException e) {
			System.out.println("查询数据库出错");
		}

	}

}
