package com.example.booking;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.booking.dao")
@EnableAutoConfiguration
@SpringBootApplication
public class MeetingRoomBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetingRoomBookingSystemApplication.class, args);
	}

}
