package ua.foxminded.javaspring.schooldb.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScannerConfig {

	@Bean
	public Scanner openScanner() {
		return new Scanner(System.in);
	}
}
