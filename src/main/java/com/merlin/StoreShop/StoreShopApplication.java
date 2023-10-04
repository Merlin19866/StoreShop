package com.merlin.StoreShop;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreShopApplication {

	public static void main(String[] args) 
            {
                //SpringApplication.run(StoreShopApplication.class, args);
                Application.launch(AppCore.class, args);
	}

}
