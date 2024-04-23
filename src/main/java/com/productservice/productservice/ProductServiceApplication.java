package com.productservice.productservice;


import com.productservice.productservice.inheritencerelations.singletable.*;
import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.models.Products;
import com.productservice.productservice.repository.CategoryRepository;
import com.productservice.productservice.repository.PriceRepository;
import com.productservice.productservice.repository.ProductsRepository;
import org.hibernate.dialect.function.array.JsonArrayViaElementArgumentReturnTypeResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.UUID.fromString;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductsRepository productsRepository;
    private final PriceRepository priceRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository,
                                     ProductsRepository productsRepository,
                                     PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.productsRepository = productsRepository;
        this.priceRepository = priceRepository;
    }

    //        private MentorRepository mentorRepository;
//        private StudentRepository studentRepository;
//        private UserRepository userRepository;
//        ProductServiceApplication(@Qualifier("st_mentorrepository")MentorRepository mentorRepository,
//                                  @Qualifier("st_studentrepository") StudentRepository studentRepository,
//                                  @Qualifier("st_userrepository") UserRepository userRepository){
//            this.mentorRepository = mentorRepository;
//            this.studentRepository = studentRepository;
//            this.userRepository = userRepository;
//        }
    //        private MentorRepository mentorRepository;
//        private StudentRepository studentRepository;
//        private UserRepository userRepository;
//        private TaReprository taReprository;
//
//
//
//        ProductServiceApplication(@Qualifier("tpc_mentorrepository") MentorRepository mentorRepository,
//                                  StudentRepository studentRepository , UserRepository userRepository,
//                                  TaReprository taReprository){
//            this.mentorRepository = mentorRepository;
//            this.studentRepository = studentRepository;
//            this.userRepository = userRepository;
//            this.taReprository = taReprository;
//
//        }
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Mentor mentor1 = new Mentor();
//        mentor1.setName("Sumeet Malik");
//        mentor1.setEmail("sumeet@gmail.com");
//        mentor1.setAvgRating(4.8);
//        mentorRepository.save(mentor1);

        //tpc inheritence

//        Mentor mentor = new Mentor();
//        mentor.setName("Deepak kasera");
//        mentor.setEmail("deepak@gmail.com");
//        mentor.setAvgRating(4.7);
//        mentorRepository.save(mentor);
//
//        Student student1 = new Student();
//        student1.setName("Sherin");
//        student1.setEmail("dua.sherin@gmail.com");
//        student1.setPsp(88.8);
//        studentRepository.save(student1);
//
//        User user1 = new User();
//        user1.setName("Akshat");
//        user1.setEmail("a@gmail.com");
//        userRepository.save(user1);
//
//        Ta ta = new Ta();
//        ta.setName("Avril");
//        ta.setEmail("av@gmail.com");
//        ta.setTa_session("12.33 pm");
//        taReprository.save(ta);
//
//        List<User> users = userRepository.findAll();
//        for(User user: users ){
//            System.out.println(user.toString() );
//        }

        //single table inheritence


//        User user = new User();
//        user.setName("Archit");
//        user.setEmail("archit@gmail.com");
//        userRepository.save(user);
//
//        Mentor mentor = new Mentor();
//        mentor.setName("Sumeet");
//        mentor.setEmail("sumeet@gmail.com");
//        mentor.setAvgRating(4.7);
//        mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("Pulkit");
//        student.setEmail("pulkit@gmail.com");
//        student.setPsp(99.0);
//        studentRepository.save(student);



//        Category category = new Category();
//        category.setName("Apple Devices");
//        Category savedCategory = categoryRepository.save(category);

//        Optional<Category> optionalCategory  = categoryRepository
//                .findById(UUID.fromString("6d82edc4-71b1-40ee-8642-5c5bd0c0ec42"));
//        if(optionalCategory.isEmpty()){
//            throw new Exception("category is null");
//        }
//        Category category1 = optionalCategory.get();

//        Products product = new Products();
//        product.setDescription("Apple is the best device");
//        product.setTitle("Iphone-16");
//        product.setCategory(category1 );
//        Products savedProduct = productsRepository.save(product);


        //Q.Find all the products with category = Apple Devices.
//        List<Products> products = category1.getProducts();
//
//        for(Products product1 :products){
//            System.out.println(product1.getTitle());
//        }

        //gives error :failed to lazily initialize a collection of role
        // Sol : resolve by eager initialize in category

//   with price n order classes cardianality
//        Price price = new Price();
//        price.setCurrency("rupees");
//        price.setValue(12000.0);
//
//        Price savedPrice = priceRepository.save(price);
//
//        Category category = new Category();
//        category.setName("Apple Devices");
//        Category savedCategory = categoryRepository.save(category);
//
//        Products product = new Products();
//        product.setTitle("Apple-16 pro");
//        product.setDescription("apple is the best device");
//        product.setCategory(savedCategory);
//        product.setPrice(savedPrice);
//
//        Products savedProduct = productsRepository.save(product);

        //priceRepository.deleteById(UUID.fromString("8cbfa519-6c87-4dc4-bf95-f7b74de662c8"));
    // as deleting the price for particular product wont be possible due to fk constraint
     //  as it cannot be nullable

     //so solution would be to dlete the product
        //  when i delete product the price table will be there
        // ideally price has no meaning alone it is for particular
        //product so when i delete product the price of that product also
        //be deleted


        // we use cascade.remove

        productsRepository.deleteById(UUID.fromString("4d852043-7880-4a44-8a72-b0ec811f9322"));


        //read about cascades types


    }
}
