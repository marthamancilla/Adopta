/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hbm.HibernateUtil;
import org.hibernate.type.Type;
import java.util.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import pojo.Click;
import pojo.Elemento;
import java.util.List;
import org.hibernate.type.StandardBasicTypes;
import org.json.JSONObject;

/**
 *
 * @author usuario
 */
public class ClickDAO {
    Session session; //Es una sesion creada por HibernateUtil para cada usuario
    
    public ClickDAO(){
        session=HibernateUtil.getLocalSession(); //Obtiene una sesion local desde el creador de sesiones de HibernateUtil
    }
    
    public  Click getPersonaById(int id){
        return (Click)session.load(Click.class, id); //Consulta la base de datos para obtener un objeto Persona con su id
    }
    
    
    public Elemento  getElementoByIdAndClass(String id, String clase){
        Elemento elemento = (Elemento)session.createCriteria(Elemento.class)
                .add(Restrictions.eq("id", id))
                .add(Restrictions.eq("clase", clase)).uniqueResult(); 
        return elemento;
    }
   
    
    public JSONArray getDataMain(){
        List total=(List)session.createCriteria(pojo.Click.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.rowCount())
                        .add(Projections.groupProperty("idElemento"))
                ).list();
        
        JSONArray json=new JSONArray(total);
        JSONArray retorno=new JSONArray();
        for(int i=0;i<json.toList().size();i++){
            JSONObject jsonaux=new JSONObject();
            JSONArray subarray=json.getJSONArray(i);
            jsonaux.put("clicks", subarray.get(0));
            jsonaux.put("elemento", subarray.get(1));
            retorno.put(jsonaux);
        }
        
        return  retorno;
    } 
   
    public boolean updateById(int id,Click persona){ 
        Click personaAModificar=getPersonaById(id); //Utiliza el metodo getPersonaById de esta misma clase para obtener un objeto tipo Persona el cual se editara
        try{
            Transaction transaccion=session.beginTransaction(); //Inicia una nueva transaccion desde el objeto local sesion            
            session.update(personaAModificar); //Le pide a la sesion local que actualice los datos de el objeto modificado
            transaccion.commit(); //Le ordena a la transaccion intentar realizar la operacion
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean saveElemento(String id, String clase){
        Elemento ele = new Elemento();
            ele.setId(id);
            ele.setClase(clase);
            
        try{
            Transaction transaccion=session.beginTransaction();
            session.save(ele);
            transaccion.commit();
            return true;
        }catch(Exception e){
            
        }finally{
            HibernateUtil.closeLocalSession();
        }
        return false;
    }
    
    //Guarda un nuevo objeto tipo Persona con los parametros recibidos en la operacion
    public boolean saveClick(String id, String clase){
        Click c = new Click();
        System.out.println(id);
        Elemento ele = getElementoByIdAndClass(id, clase);
        LocalDate local = LocalDate.now();
        LocalTime localtime = LocalTime.now();
        
        if(ele == null){
            System.out.println("hey tu");
            ele = new Elemento();
            ele.setId(id);
            ele.setClase(clase);
            saveElemento(id, clase);
        }
        
        
        c.setFecha(new Date());
        c.setIdElemento(ele);
        
        try{
            Transaction transaccion=session.beginTransaction();
            session.save(c);
            transaccion.commit();
            System.out.println("Si sirve " + id + " " + clase);
            return true;
        }catch(Exception e){
            
        }finally{
            
        }
        return false;
    }
    
    
}
