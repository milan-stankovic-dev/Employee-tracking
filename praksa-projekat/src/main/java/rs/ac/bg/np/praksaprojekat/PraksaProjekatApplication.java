package rs.ac.bg.np.praksaprojekat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import rs.ac.bg.np.praksaprojekat.service.UserService;

@SpringBootApplication
public class PraksaProjekatApplication {

	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(PraksaProjekatApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void setUp(){
		userService.init();
	}
}
