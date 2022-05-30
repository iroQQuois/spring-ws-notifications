package ru.iroqquois.wsnotification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iroqquois.wsnotification.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
