package com.manage.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.manage.model.UserDAO;
import com.manage.model.UserDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@WebAppConfiguration
public class UserDAOTest {
	@Autowired
	UserDAO dao;
	
	List<UserDTO> list = new ArrayList<UserDTO>();
	
	@Before
	public void setup() {
		dao.deleteAllUser();
		
		UserDTO dto1 = new UserDTO("hello1", "1234", "nameHello1", "server1");
		UserDTO dto2 = new UserDTO("hello2", "1234", "nameHello2", "server2");
		UserDTO dto3 = new UserDTO("hello3", "1234", "nameHello3", "server3");
		UserDTO dto4 = new UserDTO("hello4", "1234", "nameHello4", "server4");
		
		list.add(dto1);list.add(dto2);list.add(dto3);list.add(dto4);
		
		for(UserDTO dto : list)
			dao.addUser(dto);
	}
	
	@Test
	public void getListTest() {
		
		List<UserDTO> newList = dao.getUserList();
		
		assertThat(newList.get(0).getId(), is("hello1"));
		assertThat(newList.get(1).getId(), is("hello2"));
		assertThat(newList.get(2).getId(), is("hello3"));
		assertThat(newList.get(3).getId(), is("hello4"));
	}
	
	@Test
	public void getUserTest() {
		UserDTO dto = dao.getUser("hello1");
		
		assertThat(dto.getId(), is("hello1"));
	}
	
	@Test
	public void modifyUserTest() {
		UserDTO dto = list.get(0);
		
		dto.setName("update");
		dao.modifyUser(dto);
		assertThat(dao.getUser(dto.getId()).getName(), is("update"));
	}
	
	@Test
	public void deleteUser() {
		dao.deleteUser(list.get(0).getId());
		assertThat(dao.getUserList().size(), is(3));
	}
	
	@Test
	public void loginTest() {
		UserDTO result = dao.login(list.get(0));
		assertThat(result.getId(), is("hello1"));
	}
}
