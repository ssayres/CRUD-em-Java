package br.com.crud.dao;

import com.mysql.jdbc.PreparedStatement;

import br.com.crud.connections.connection;
import br.com.crud.model.crud;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
public class crudDao {
	
public void save(crud db) {
    //CREATE
	String sql ="INSERT INTO dados(dados_inseridos,data_inserida) VALUES (?,?) ";
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = connection.createConnectiontoMySQL();
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, db.getDados_inseridos());
		pstm.setDate(2, new Date(db.getData_inserida().getTime()));
		
		pstm.execute();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(pstm!=null) {
				pstm.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public void update(crud Crud ) {
	//UPDATE
	String sql = "UPDATE dados SET dados_inseridos= ?, data_inserida = ? "+
"WHERE codigo = ?";
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = connection.createConnectiontoMySQL();
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setString(1,Crud.getDados_inseridos());
		pstm.setDate(2, new Date(Crud.getData_inserida().getTime()));
	    pstm.setInt(3, Crud.getCodigo());
	    
	    pstm.execute();
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(pstm!=null) {
				pstm.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
public void deleteByID(int codigo) {
	String sql = "DELETE FROM dados WHERE codigo = ?";
	Connection conn = null;
	PreparedStatement pstm = null;
	try {
		conn = connection.createConnectiontoMySQL();
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
	    pstm.setInt(1, codigo);
	    
	    pstm.execute();
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(pstm!=null) {
				pstm.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
public List<crud> getCrud(){
    //READ
	String sql = "SELECT * FROM dados";
	List<crud> informacoes = new ArrayList<crud>();
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	try {
		conn = connection.createConnectiontoMySQL();
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		rset = pstm.executeQuery();
		
		while(rset.next()) {
			crud busca = new crud();
			busca.setCodigo(rset.getInt("codigo"));
			busca.setDados_inseridos(rset.getString("dados_inseridos"));
			busca.setData_inserida(rset.getDate("data_inserida"));
			
			informacoes.add(busca);
		}	
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				 if(rset!=null) {
			    	 rset.close();
			     }
			     if (pstm !=null) {
			    	 pstm.close();
			     }
			     if(conn!=null) {
			    	 conn.close();
			     }
				}catch(Exception e) {
					e.printStackTrace();
			}
		}
		return informacoes;
}
}