package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

//будет происходить тестирование работоспособности нашего приложения
public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      userService.add(new Car("Bugatti", 127));
      userService.add(new Car("Toyota", 10));
      userService.add(new Car("Lada", 5));
      userService.add(new Car("Lambo", 223));

       List<User> users = userService.listUsers();
       List<Car> cars = userService.listCars();

       for(int j=0; j<users.size(); j++){
           users.get(j).setCar(cars.get(j));
           userService.update(users.get(j));
       }

       User usr =   userService.getUserWithCar();

//       for (User user : users) {
//           System.out.println("Id = "+user.getId());
//           System.out.println("First Name = "+user.getFirstName());
//           System.out.println("Last Name = "+user.getLastName());
//           System.out.println("Email = "+user.getEmail());
//           System.out.println();
//       }
       context.close();
   }
}
