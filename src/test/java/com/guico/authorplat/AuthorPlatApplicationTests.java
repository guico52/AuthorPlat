package com.guico.authorplat;

import com.guico.authorplat.service.impl.UserServiceImpl;
import jakarta.activation.spi.MimeTypeRegistryProvider;
import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootTest
class AuthorPlatApplicationTests {

	@Resource
	JavaMailSenderImpl javaMailSender;

	String to = "1305487489@qq.com";
	String username = "guico";

	String token = "testToken";

	@Test
	void contextLoads() {
		MimeTypeRegistryProvider mimeTypeRegistryProvider;
	}
	@Test
	void mailSenderTest() throws MessagingException {
		MimeMessageHelper helper = new MimeMessageHelper(javaMailSender.createMimeMessage());
		helper.setFrom("Author-plat");
		helper.setTo(to);
		helper.setSubject("Author-plat");
		helper.setText("test");
		javaMailSender.send(helper.getMimeMessage());

	}

}
