import java.sql.Connection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.dbutils.AsyncQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class Test {

	public static void main(String[] args) throws Exception {
		Connection conn = JDBCTools.getConnection();
		System.out.println(conn);
		BeanListHandler<IniBean> h = new BeanListHandler<IniBean>(
				IniBean.class);
		QueryRunner run = new QueryRunner();
		String sql = "select ini_name as iniName, ini_value as iniValue from tb_ini";
		List<IniBean> result = run.query(conn, sql, h);
		// 增加异步处理
		int taskSize = 5;
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		AsyncQueryRunner asyncRun = new AsyncQueryRunner(pool, run);
		Future<List<IniBean>> temp = asyncRun.query(conn, sql, h);

		BeanListHandler h2 = new BeanListHandler(IniBean.class);
		Future<IniBean> temp2 = asyncRun.<IniBean> query(conn, sql, h2);

	}

}
