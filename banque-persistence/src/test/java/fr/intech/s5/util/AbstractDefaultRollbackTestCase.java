package fr.intech.s5.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations={"classpath:appContextTest.xml"})
@RunWith(value=SpringJUnit4ClassRunner.class)
public class AbstractDefaultRollbackTestCase extends AbstractTransactionalJUnit4SpringContextTests{

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/**
	 * @return hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate(){
		if(hibernateTemplate == null){
			hibernateTemplate = new HibernateTemplate(getSessionFactory());
		}
		return this.hibernateTemplate;
	}
	
	/**
	 * @return sessionFactory
	 */
	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}
	
	/**
	 * @return currentSession
	 */
	protected Session getCurrentSession(){
		return getSessionFactory().getCurrentSession();
	}
	
	/**
	 * @param beanName
	 * @return bean
	 */
	protected Object getBean(String beanName){
		return applicationContext.getBean(beanName);
	}
	
	@Before
	public void setup() throws Exception{	
	}
	
	@After
	public final void tearDown()throws Exception{
		//Interdit la surdefinition pour eviter le mecanisme de transaction par defaut
		//Utiliser OnTearDownIntransaction()
	}
	
	@Test
	public void setupTest() {
	}
}
