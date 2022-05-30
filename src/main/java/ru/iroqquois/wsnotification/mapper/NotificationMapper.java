package ru.iroqquois.wsnotification.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.iroqquois.wsnotification.entity.Notification;
import ru.iroqquois.wsnotification.payload.request.NotificationUpdateRequest;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    Notification fromUpdateRequest(NotificationUpdateRequest request);

    @BeanMapping(nullValueCheckStrategy = ALWAYS, nullValuePropertyMappingStrategy = IGNORE)
    void update(Notification update, @MappingTarget Notification target);
}
