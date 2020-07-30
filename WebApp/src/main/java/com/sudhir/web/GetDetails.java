package com.sudhir.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDetails
 */
public class GetDetails extends HttpServlet {
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
	            response.setContentType("text/html");
	            PrintWriter out = response.getWriter();
	            int transfer_amount = Integer.parseInt(request.getParameter("transfer_amount"));
	            Connection con = ConnectionManager.getConnection();
	            ResultSet rs = null;
	            Statement st = con.createStatement();
	            String query = "select tid,account_balance from transactions order by tid desc limit 1";
	            rs = st.executeQuery(query);
	            int ab=0,id=0;
	          
	                if(rs.next()){
	                    ab = rs.getInt("account_balance");
	                    id=rs.getInt("tid");
	                }
	 
	            ab = ab - transfer_amount;
	            id=id+1;
	      
	            st.executeUpdate("insert into transactions (tid,transfer_amount,account_balance) values("+id+","+transfer_amount+","+ab+")");
	          
	            out.println("successfully transfered "+transfer_amount+".Rs");
	            out.println("remaining balance in the account is "+ab+".Rs");
	            
	            rs.close();
	            st.close();
	            con.close();
	            out.close();
	        } catch (SQLException ex) {
	            Logger.getLogger(GetDetails.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        }
	    

}
