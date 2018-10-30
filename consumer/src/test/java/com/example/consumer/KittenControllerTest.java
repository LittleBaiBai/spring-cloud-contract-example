package com.example.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(
		ids = {"com.example:demo:+:stubs:8080"},
		stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
public class KittenControllerTest {

	@Autowired
	private KittenController controller;

	@Test
	public void getKittens_returnsAListOfKittenNames() {
		List<String> names = controller.getNames();
		assertThat(names).hasSize(1);
		assertThat(names.get(0)).isEqualTo("Chocobo");
	}
}
