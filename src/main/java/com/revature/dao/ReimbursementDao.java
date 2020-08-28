package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class ReimbursementDao implements ReimbursementDaoIf{

	
		@Override
		public List<Reimbursement> findAll() {
			try(Connection conn= HibernateUtil.getConnection()){
				String sql = "SELECT * FROM reimbursement;";
				Statement statement = conn.createStatement();
				List<Reimbursement> list = new ArrayList<>();
				
				ResultSet result = statement.executeQuery(sql);
				
				while(result.next()) {
					Reimbursement r = new Reimbursement(result.getInt("reimb_id"),
							result.getDouble("reimb_amount"),
							result.getString("reimb_submitted"),
							result.getString("reimb_resolved"),
							result.getString("reimb_description"),
							result.getInt("reimb_author"),
							result.getInt("reim_resolver"),
							result.getInt("reim_status_id"),
							result.getInt("reim_type_id"));
					
					list.add(r);
				}
				
				return list;
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public Reimbursement findById(int id) {
			try(Connection conn= HibernateUtil.getConnection()){
				String sql = "SELECT * FROM reimbursement WHERE reimb_id =" +id+";";
				Statement statement = conn.createStatement();
				
				ResultSet result = statement.executeQuery(sql);
				
				if (result.next()) {
					Reimbursement r = new Reimbursement(result.getInt("reimb_id"),
							result.getDouble("reimb_amount"),
							result.getString("reimb_submitted"),
							result.getString("reimb_resolved"),
							result.getString("reimb_description"),
							result.getInt("reimb_author"),
							result.getInt("reim_resolver"),
							result.getInt("reim_status_id"),
							result.getInt("reim_type_id"));
					
					return r;
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		public List<Reimbursement> findByUser(int id) {
			try(Connection conn= HibernateUtil.getConnection()){
				String sql = "SELECT * FROM reimbursement WHERE reimb_author =" +id+";";
				Statement statement = conn.createStatement();
				List<Reimbursement> list = new ArrayList<>();
				ResultSet result = statement.executeQuery(sql);
							
				while (result.next()){
					Reimbursement r = new Reimbursement(result.getInt("reimb_id"),
							result.getDouble("reimb_amount"),
							result.getString("reimb_submitted"),
							result.getString("reimb_resolved"),
							result.getString("reimb_description"),
							result.getInt("reimb_author"),
							result.getInt("reim_resolver"),
							result.getInt("reim_status_id"),
							result.getInt("reim_type_id"));
					
					list.add(r);
				}
				return list;
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return Collections.emptyList();
		}
		
		@Override
		public List<Reimbursement> findByStatus(String status) {
			try(Connection conn= HibernateUtil.getConnection()){
				String sql = "SELECT * FROM reimbursement"
						+ "JOIN reimb_status"
						+ "ON r.reim_status_id =rs.reimb_status_id"
						+ "WHERE reimb_status= ?;";			
				List<Reimbursement> list = new ArrayList<>();
				PreparedStatement statement = conn.prepareStatement(sql);
				
				statement.setString(1, status);
				ResultSet result = statement.executeQuery(sql);
				
				while (result.next()){
					Reimbursement r = new Reimbursement(result.getInt("reimb_id"),
							result.getDouble("reimb_amount"),
							result.getString("reimb_submitted"),
							result.getString("reimb_resolved"),
							result.getString("reimb_description"),
							result.getInt("reimb_author"),
							result.getInt("reim_resolver"),
							result.getInt("reim_status_id"),
							result.getInt("reim_type_id"));
					
					list.add(r);
				}			
				return list;		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
		}

		@Override
		public boolean addReimbursement(Reimbursement addR) {
			try(Connection conn= HibernateUtil.getConnection()){
				String sql = "INSERT INTO reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, "
						+ "reimb_author, reim_resolver, reim_status_id,	reim_type_id) "
						+ "VALUES (?, ?, ?, ?, ?, ?,?, ?, ?);";
				PreparedStatement statement = conn.prepareStatement(sql);
				
				int index=0;
				statement.setDouble(++index, addR.getAmount());
				statement.setString(++index, addR.getSubmitted());
				statement.setString(++index, addR.getResolved() );
				statement.setString(++index, addR.getDescription());
				statement.setInt(++index, addR.getAuthor());
				statement.setInt(++index, addR.getResolver());
				statement.setInt(++index, addR.getStatusId());
				statement.setInt(++index, addR.getTypeId());
				
				
				 statement.execute();
				//execute returns true only if it brings back data 
				 return true;
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
		}

		@Override
		public boolean updateReimbursement(Reimbursement updateR) {
			try(Connection conn= HibernateUtil.getConnection()){
				String sql = "UPDATE reimbursement SET reimb_amount= ?, reimb_submitted= ?,"
						+ " reimb_resolved= ?, reimb_description= ?, reimb_author= ?, reim_resolver= ? "
						+ "reim_status_id=?,reim_type_id=? WHERE reimb_id=?;";
				
				PreparedStatement statement = conn.prepareStatement(sql);
				
				int index=0;
				statement.setDouble(++index, updateR.getAmount());
				statement.setString(++index, updateR.getSubmitted());
				statement.setString(++index, updateR.getResolved() );
				statement.setString(++index, updateR.getDescription());
				statement.setInt(++index, updateR.getAuthor());
				statement.setInt(++index, updateR.getResolver());
				statement.setInt(++index, updateR.getStatusId());
				statement.setInt(++index, updateR.getTypeId());
				statement.execute();
				return true;
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
		}

		

		
}
