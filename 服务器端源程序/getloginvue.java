package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
public class getloginvue extends HttpServlet {
	Connection conn=null;//数据库连接
	Statement stmt =null;//数据库与处理
	ResultSet rs=null;//处理类
	String sql;
	Connection conn2=null;//数据库连接
	Statement stmt2 =null;//数据库与处理
	ResultSet rs2=null;//处理类
	String sql2;
	/**
	 * Constructor of the object.
	 */
	public getloginvue() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 //解决跨域问题
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setContentType("application/json;charset=utf-8");//以utf-8响应回前端
		response.setCharacterEncoding("UTF-8");//处理其他数据
//拿到前端数据		
//		int id=Interger.parseInt(request.getParameter("id"));
//		String name=request.getParameter("name");
//		System.out.println(id);
//		System.out.println(name);
		try{
			stmt=conn.createStatement();
			sql="select * from users;";
			rs=stmt.executeQuery(sql);
			JSONArray array=new JSONArray();
			array=resultSetToJsonArry(rs);
			out.print(array);
		}catch(SQLException e){
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}
	public static JSONArray resultSetToJsonArry(ResultSet rs) throws SQLException,JSONException{
		//json数组
		JSONArray array=new JSONArray();
		//获取列数
		java.sql.ResultSetMetaData metaData = rs.getMetaData();
		int columnCount=metaData.getColumnCount();
		//遍历ResultSet中的每条数据
		while(rs.next()){
			JSONObject jsonObj=new JSONObject();
			//遍历每一列
			for(int i=1;i<=columnCount;i++){
				String columnName=metaData.getColumnLabel(i);
				String value=rs.getString(columnName);
				jsonObj.put(columnName, value);
			}
			array.put(jsonObj);
		}
		return array;
	} 
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				doGet(request,response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		//初始化现在init方法里面
		//连接数据库
		try{
			//连接驱动class
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("ok1");
		//连接数据库
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodb?characterEncoding=UTF-8&useOldAliasMetadataBehavior=true&serverTimezone=GMT","root","sql2008");
		System.out.println("ok2");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
