import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class Test
{

	public static void main(String[] args) throws Exception
	{
		Connection conn = JDBCTools.getConnection();
		System.out.println(conn);
		BeanListHandler<IniBean> h = new BeanListHandler<IniBean>(IniBean.class);
		QueryRunner run = new QueryRunner();
		String sql = "select ini_name as iniName, ini_value as iniValue from tb_ini";
		List<IniBean> result = run.query(conn, sql, h);
	}

}
