package com.enuminfo.farm;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.enuminfo.farm.model.UserContactInfo;
import com.enuminfo.farm.model.UserOrder;
import com.enuminfo.farm.model.UserSelectItem;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RunFrontGUI.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")
public class RunFrontGuiTest {
	@Value("${local.server.port}")
	private int port = 0;

	UserOrder order = new UserOrder();
	@Test
	public void contextLoads() {
//		@SuppressWarnings("rawtypes")
//		ResponseEntity<Map> entity = new TestRestTemplate().getForEntity("http://localhost:" + port + "/env", Map.class);
//		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}
	
	@Before
	public void initialize(){
		UserContactInfo info = new UserContactInfo();
		info.setContactNumber(new Long(12344567));
		info.setEmailId("raghu@gmail.com");
		info.setName("test");
		info.setUpdateDate(null);
		
		UserSelectItem item1 = new UserSelectItem();
		item1.setStatus("ordered");
		item1.setItemName("Pototo");
		item1.setPrice(10);
		item1.setQuantity(10);
		
		UserSelectItem item2 = new UserSelectItem();
		item2.setStatus("ordered");
		item2.setItemName("tamato");
		item2.setPrice(20);
		item2.setQuantity(30);
		
		List<UserSelectItem> items = Arrays.asList(item1, item2);
		
		//order.setItems(items);
		order.setUserContactInfo(info);
	}
	@Test
	public void test_saveOrder(){
			HttpEntity<UserOrder> entity = new HttpEntity<UserOrder>(order);
		ResponseEntity<Void> response = new TestRestTemplate().postForEntity("http://localhost:" + port + "/orderItems",entity,Void.class );
		assertEquals("HTTP status should be 201: Created", HttpStatus.CREATED, response.getStatusCode());
	}
	@Test
	public void test_fetchOrders(){
		List<UserOrder> list = new ArrayList<UserOrder>();
		ResponseEntity<Collection> forEntity = new TestRestTemplate().getForEntity("http://localhost:" + port + "/fetchOrders",Collection.class);
		Iterable<UserOrder> itr = forEntity.getBody();
		for (UserOrder userOrder : itr) {
			System.out.println(userOrder.toString());
		}
		assertEquals("HTTP status should be 201: Created", HttpStatus.CREATED, forEntity.getStatusCode());
	}
	@Ignore
	@Test
	public void test_fetchOrderByUser(){
		ResponseEntity<UserOrder> response = new TestRestTemplate().getForEntity("http://localhost:" + port + "/fetchOrders/1",UserOrder.class );
		UserOrder order = response.getBody();
		System.out.println(order.toString());
		
		assertEquals("HTTP status should be 201: Created", HttpStatus.CREATED, response.getStatusCode());
	}
	
	
}
