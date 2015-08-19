package com.test.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.test.dao.UserDao;
import com.test.test.domain.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	 	 
	@Transactional
	public void insert(User user) {
		userDao.save(user); 
	}

	public User search(String userName) {
		return userDao.findOneByUsername(userName); 
	} 
	
	/*public Iterable<User> searchall()
	{
		return userDao.findAll();
	}

	public void deleteone(User user)
	{
		userDao.delete(user); 
	}
	
	public boolean check(long a)
	{
		 return userDao.exists(a);//exist的参数为什么是long？
	}
	
	public Iterable<User> selecttime(String starttime,String endtime)
	{ 
		//select * from table1 where field1 > 2011-4-25 and field1<2011-5-31
	//	userDao.findAll(arg0)
	}
	
	 public List<User> queryBySql(String sql) {    
		 
		// new CriteriaImpl().
		 
	       // List<User> list = getSession().createNativeQuery(sql).getResultList(); 
	        Query query = getSession().createNativeQuery(sql, User.class);
	        return (List<User>) query.getResultList();
	        //query.getResultList().toString()
	       // return list;    
	    }    
	        
    public int excuteBySql(String sql)    
    {    
        int result ;    
        Query query = this.getSession().createNativeQuery(sql);    
        result = query.executeUpdate();    
        return result;    
    }  
    
    @Autowired
    private EntityManagerFactory entityManagerFactory;    
    
    public EntityManager getSession() {    
        return entityManagerFactory.createEntityManager();   
    }  */  	
	     
}
