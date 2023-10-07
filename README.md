# JPA_HW_9
Завдання:
1. За допомогою JPA приєднайся до БД учасників ОСББ багато будинкового ЖК, яка розглядалася в минулому ДЗ.
2. За допомогою Criteria API, зроби запит до БД, результатом якого буде список  власників квартир, які не мають права в'їзду на територію ЖК, з їхніми з ПІБ та номерами електронної пошти, а також номером і адресою будинку, номером и площею квартири, якщо вони фактично проживають в ЖК і при цьому мають менше двох квартир у власності.
3. Отриманий результат виведи в консоль.

Рекомендації:
- Зверни увагу на стандартизований підхід до організації транзакційної роботи з БД.

Формат здачі:
- Відправ посилання на Git зі скриптом отриманого результату.

Умови приймання:
1. Наявний git-проект, що відповідає вимогам ДЗ.
2. Програма з'єднується з БД за допомогою JPA Criteria API.
3. В програмі виконується запит до БД згідно наведених умов за допомогою JPA.
4. Запит без помилок виконується та коректно фільтрує дані згідно до умов ДЗ.
5. Результат роботи запиту рядками (колонки через кому) виведений в консоль та збережений в текстовому файлі. Файл доданий до git-проекту.