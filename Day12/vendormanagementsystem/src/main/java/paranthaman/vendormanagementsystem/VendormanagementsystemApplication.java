package paranthaman.vendormanagementsystem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Vendor Management System", version = "1.0.0", description = "This is Version 1 Backend for the Vendor Management System", contact = @Contact(name = "PARANTHAMAN L", email = "paranthamanl2004@gmail.com")))

@SpringBootApplication
public class VendormanagementsystemApplication {
	@Value("${server.port}")
	private static int port;

	public static void main(String[] args) {
		SpringApplication.run(VendormanagementsystemApplication.class, args);
		System.out.println("Vendor Management System Server is Started in port " + port + " ...");
	}

}