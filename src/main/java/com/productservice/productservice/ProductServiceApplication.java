package com.productservice.productservice;


import com.productservice.productservice.inheritencerelations.singletable.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
        private MentorRepository mentorRepository;
        private StudentRepository studentRepository;
        private UserRepository userRepository;
        ProductServiceApplication(@Qualifier("st_mentorrepository")MentorRepository mentorRepository,
                                  @Qualifier("st_studentrepository") StudentRepository studentRepository,
                                  @Qualifier("st_userrepository") UserRepository userRepository){
            this.mentorRepository = mentorRepository;
            this.studentRepository = studentRepository;
            this.userRepository = userRepository;
        }
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


        User user = new User();
        user.setName("Archit");
        user.setEmail("archit@gmail.com");
        userRepository.save(user);

        Mentor mentor = new Mentor();
        mentor.setName("Sumeet");
        mentor.setEmail("sumeet@gmail.com");
        mentor.setAvgRating(4.7);
        mentorRepository.save(mentor);

        Student student = new Student();
        student.setName("Pulkit");
        student.setEmail("pulkit@gmail.com");
        student.setPsp(99.0);
        studentRepository.save(student);
    }
}
