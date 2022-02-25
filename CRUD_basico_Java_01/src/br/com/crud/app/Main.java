package br.com.crud.app;
import br.com.crud.model.crud;
import br.com.crud.dao.crudDao;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		crudDao Cruddao = new crudDao();
     crud Crud = new crud();
     Crud.setCodigo(01);
     Crud.setDados_inseridos("João Paulo");
     Crud.setData_inserida(new Date());
     
     Cruddao.save(Crud);
     
     crud cr = new crud();
     cr.setDados_inseridos("Maria Victória");
     cr.setData_inserida(new Date());
     cr.setCodigo(1);
     
     //Cruddao.update(cr);
     
     Cruddao.deleteByID(8);
     
     for(crud c : Cruddao.getCrud()) {
    	 System.out.println("ID: "+c.getCodigo());
    	 
     }
     
	}
    
}
