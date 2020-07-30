package com.sudhir.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Transactions
 */
public class Tra extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
	            response.setContentType("text/html");
	            PrintWriter out = response.getWriter();
	            Connection con = ConnectionManager.getConnection();
	            ResultSet rs = null;
	            Statement st = con.createStatement();
	            String query = "select * from transactions order by tid desc limit 5";
	            rs = st.executeQuery(query);
	            out.print("<html><body>");
	            while(rs.next()){
	                out.print("<p>"+rs.getInt("transfer_amount")+" is transfered and the remaining balance is "+rs.getInt("account_balance")+"</p><br>");
	            
	            }
	            out.print("</body></html>");
	            
	            rs.close();
	            st.close();
	            con.close();
	            out.close();
	        } catch (SQLException ex) {
	            Logger.getLogger(Tra.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}

	
	
}
