package test.com.dmall.homvee.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zlt.seniorpersonnel.dao.domain.Vender;
import com.zlt.seniorpersonnel.service.vender.VenderService;

public class TestVenderService extends BaseJunit{
	@Autowired
	private VenderService venderService;

	@Test
	public void testSaveEntry() throws Exception{
		Vender vender = new Vender();
		vender.setVenderName("5678967890AAAAAA");
		int id = venderService.saveEntry(vender,vender);
		System.out.println(id);
	}
	@Test
	public void testModifyByKey(){
		Vender vender = new Vender();
		vender.setVenderName("AAAAA");
		vender.setId(1);
		int id = venderService.modifyByKey(vender);
		System.out.println(id);
	}
	@Test
	public void testDeleteByKey(){
		int id = venderService.deleteByKey(2L);
		System.out.println(id);
	}
	@Test
	public void testDeleteByCondition(){
		Vender vender = new Vender();
		vender.setVenderName("AAAAA");
		int id = venderService.deleteByCondition(vender);
		System.out.println(id);
	}
	@Test
	public void testLogicDelByCondition(){
		Vender vender = new Vender();
		vender.setVenderName("AAAAA");
		int id = venderService.logicDelByCondition(vender);
		System.out.println(id);
	}
	@Test
	public void testLogicDelByKey(){
		int id = venderService.logicDelByKey(1L);
		System.out.println(id);
	}

}
