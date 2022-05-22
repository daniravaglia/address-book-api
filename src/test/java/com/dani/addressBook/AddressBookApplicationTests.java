package com.dani.addressBook;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dani.addressBook.domain.Contact;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AddressBookApplicationTests {

	@Test
	void notNullTest() {

		Contact contact = new Contact();
		System.out.println(contact.getName());
		try {
			contact.setName(null);
		} catch (Exception e) {
			assertEquals(NullPointerException.class, e.getClass());
		}
	}

}
