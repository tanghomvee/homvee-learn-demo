package test.com.dmall.homvee.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homvee.dao.domain.Vender;
import com.homvee.dao.vender.VenderDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-config-dao.xml"})
public class TestVenderDao {
	/*@Autowired
	private VenderDao venderDao;
	@Test
	public void testSaveEntry(){
		Vender vender = new Vender();
		vender.setVenderName("56789678FFFFFFFFF90");
		int id = venderDao.saveEntry(vender,vender);
		System.out.println(id);
	}
	@Test
	public void testModifyByKey(){
		Vender vender = new Vender();
		vender.setVenderName("AAAAA");
		vender.setId(1);
		int id = venderDao.modifyByKey(vender);
		System.out.println(id);
	}
	@Test
	public void testDeleteByKey(){
		int id = venderDao.deleteByKey(2L);
		System.out.println(id);
	}
	@Test
	public void testDeleteByCondition(){
		Vender vender = new Vender();
		vender.setVenderName("AAAAA");
		int id = venderDao.deleteByCondition(vender);
		System.out.println(id);
	}
	@Test
	public void testLogicDelByCondition(){
		Vender vender = new Vender();
		vender.setVenderName("AAAAA");
		int id = venderDao.logicDelByCondition(vender);
		System.out.println(id);
	}
	@Test
	public void testLogicDelByKey(){
		int id = venderDao.logicDelByKey(1L);
		System.out.println(id);
	}*/
}
