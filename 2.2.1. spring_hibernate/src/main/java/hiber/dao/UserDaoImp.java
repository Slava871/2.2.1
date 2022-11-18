package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository  //нужно для объявления дао бином
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void add(Car car) {sessionFactory.getCurrentSession().save(car);}

   @Override
   public void add(Long carId) {
      sessionFactory.getCurrentSession().cre
   }


   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

//
//   @Override
//   @SuppressWarnings("unchecked")
//   public List<Car> listCars() {
//      TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
//      return query.getResultList();
//   }
//


}
