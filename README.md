# Flight Filter Service

## Описание
Flight Filter Service - это Java-приложение, предназначенное для фильтрации списка рейсов на основе различных критериев. Этот сервис поможет пользователям получить список рейсов, соответствующих определенным условиям, таким как время вылета, время прилета и общее время пребывания на земле.

## Особенности
- **Фильтрация по времени вылета:** исключает рейсы, вылетающие до текущего момента времени.
- **Фильтрация по времени прилета:** исключает рейсы, в которых время прилета предшествует времени вылета.
- **Фильтрация по времени на земле:** исключает рейсы, в которых общее время на земле превышает два часа.

## Технологии
- Java 
- JUnit (для тестирования)
