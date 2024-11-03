package com.example.cleaningstartup;

import com.example.cleaningstartup.entity.CleaningServiceItem;
import com.example.cleaningstartup.entity.CleaningServiceItem.*;
import com.example.cleaningstartup.repository.CleaningServiceItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CleaningStartUpApplication {

    public static void main(String[] args) {
        SpringApplication.run(CleaningStartUpApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(CleaningServiceItemRepository repo) {
        return args -> {
            repo.deleteAll();
            repo.save(new CleaningServiceItem("w1", "Санузел и ванная комната", Type.WET_CLEANING));
            repo.save(new CleaningServiceItem("w2", "Обеспыливание горизонтальных поверхностей и мебели", Type.WET_CLEANING));
            repo.save(new CleaningServiceItem("w3", "Протирка зеркал - Протирка дверей - Протирка фасадов шкафов (внутри если пустые)", Type.WET_CLEANING));
            repo.save(new CleaningServiceItem("w4", "Санузел и ванная комната", Type.WET_CLEANING));
            repo.save(new CleaningServiceItem("w5", "Протирка фасадов шкафов (внутри если пустые)", Type.WET_CLEANING));
            repo.save(new CleaningServiceItem("g1", "Полы и плинтуса сухая и влажная уборка - Обеспыливание всех поверхностей", Type.GENERAL_CLEANING));
            repo.save(new CleaningServiceItem("g2", "Чистка зеркал - Протирка дверей)", Type.GENERAL_CLEANING));
            repo.save(new CleaningServiceItem("g3", "Обеспыливание фасадов шкафов", Type.GENERAL_CLEANING));
            repo.save(new CleaningServiceItem("g4", "Мойка и обезжиривание фасадов кухонных шкафов, столешницы и фартука", Type.GENERAL_CLEANING));
            repo.save(new CleaningServiceItem("g5", "Мойка кухонных раковин, смесителей", Type.GENERAL_CLEANING));
            repo.save(new CleaningServiceItem("g6", "Санузел и ванная комната (моем полностью со стенами)", Type.GENERAL_CLEANING));
            repo.save(new CleaningServiceItem("r1", "Комнаты и коридоры", Type.CLEANING_AFTER_REPAIR));
            repo.save(new CleaningServiceItem("r2", "Удаление строительной пыли и сложных загрязнений со всех поверхностей на всю высоту помещения", Type.CLEANING_AFTER_REPAIR));
            repo.save(new CleaningServiceItem("r3", "Кухня - Мытьё кухонного гарнитура, бытовой техники, удаление следов ремонта", Type.CLEANING_AFTER_REPAIR));
            repo.save(new CleaningServiceItem("r4", "Ванная комната", Type.CLEANING_AFTER_REPAIR));
            repo.save(new CleaningServiceItem("r5", "Очистка и дезинфекция сантехники. Мытьё плитки и потолков, очистка швов на всю высоту помещения.\n" +
                    "                          - Уборка после ремонта содержит более 45 видов работ", Type.CLEANING_AFTER_REPAIR));
            repo.save(new CleaningServiceItem("d1", "Диваны", Type.DRY_CLEANING_OF_UPHOLSTERED_FURNITURE));
            repo.save(new CleaningServiceItem("d2", "Стулья", Type.DRY_CLEANING_OF_UPHOLSTERED_FURNITURE));
            repo.save(new CleaningServiceItem("d3", "Кресла", Type.DRY_CLEANING_OF_UPHOLSTERED_FURNITURE));
            repo.save(new CleaningServiceItem("d4", "Матрасы", Type.DRY_CLEANING_OF_UPHOLSTERED_FURNITURE));
            repo.save(new CleaningServiceItem("d5", "Ковролины", Type.DRY_CLEANING_OF_UPHOLSTERED_FURNITURE));
            repo.save(new CleaningServiceItem("wc1", "Инвентарь", Type.WINDOW_CLEANING));
            repo.save(new CleaningServiceItem("wc2", "Окна", Type.WINDOW_CLEANING));
            repo.save(new CleaningServiceItem("wc3", "Мытьё окон включает в себя мытьё окна с двух сторон, рам, отливов и подоконников", Type.WINDOW_CLEANING));
            repo.save(new CleaningServiceItem("wac1", "Инвентарь", Type.WASHING_CURTAINS));
            repo.save(new CleaningServiceItem("wac2", "Бережная чистка штор", Type.WASHING_CURTAINS));
            repo.save(new CleaningServiceItem("wac3", "Вывоз и доставка", Type.WASHING_CURTAINS));
        };
    }

}
