package com.example.mongodblab2;

import com.example.mongodblab2.dtos.EnclosuresDto;
import com.example.mongodblab2.dtos.FeedingsDto;
import com.example.mongodblab2.services.EnclosuresService;
import com.example.mongodblab2.services.FeedingsService;
import org.bson.types.ObjectId;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Random;

@SpringBootApplication
public class Mongodblab2Application {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        return modelMapper;
    }



    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Mongodblab2Application.class);
        app.setDefaultProperties(Collections.singletonMap("spring.profiles.default", "mongodb"));
        app.run(args);
    }

    @Component
    public class CustomCode implements CommandLineRunner {
        @Autowired
        private FeedingsService feedingsService;
        @Autowired
        private EnclosuresService enclosuresService;

        @Override
        public void run(String... args) throws Exception {
            Random random = new Random();
            Long id = 1L;
            for (int i = 1; i <= 10; i++) {
                String name = "Вольер №" + i;
                String type = randomType();
                String food = randomFood();

                EnclosuresDto.SizeDto size = new EnclosuresDto.SizeDto();
                size.setArea(random.nextInt(500) + 100);
                size.setVolume(random.nextInt(1000) + 500);

                EnclosuresDto.AnimalDto[] animals = new EnclosuresDto.AnimalDto[3];
                for (int j = 0; j < 3; j++) {
                    animals[j] = new EnclosuresDto.AnimalDto();
                    animals[j].setId(id++);
                    animals[j].setName(randomAnimalName());
                    animals[j].setSpecies(randomAnimalSpecies());
                    animals[j].setAge(random.nextInt(18) + 1);
                }

                EnclosuresDto enclosure = new EnclosuresDto(null, name, type, food, size, animals);
                enclosuresService.createEnclosures(enclosure);
            }

            for (int i = 0; i < 10; i++) {
                LocalDate now = LocalDate.now();
                String food =  randomFood();
                int quantity = random.nextInt(100) + 1;
                FeedingsDto feedings = new FeedingsDto(null, now, food, quantity);
                feedingsService.createFeedings(feedings);
            }
        }
        private static String randomType() {
            String[] types = {"Открытый", "Закрытый", "Полуоткрытый"};
            return types[new Random().nextInt(types.length)];
        }

        private static String randomFood() {
            String[] foods = {"Мясо", "Рыба", "Трава", "Фрукты"};
            return foods[new Random().nextInt(foods.length)];
        }

        private static String randomAnimalName() {
            String[] names = {"Симба", "Шер Хан", "Бамблби", "Кинг Конг", "Гепарду", "Тигре", "Пумаму", "Пантерис", "Леопиред", "Лево", "Пандусу"};
            return names[new Random().nextInt(names.length)];
        }

        private static String randomAnimalSpecies() {
            String[] species = {"Лев", "Тигр", "Леопард", "Пантера"};
            return species[new Random().nextInt(species.length)];
        }
    }
}
