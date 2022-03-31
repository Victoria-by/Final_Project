Реализовать 3 тест кейса для онлайнера

1)открыть раздел каталог, проверить присутствие секций "Электроника", "Компьютеры и сети","Бытовая техника",
 "Стройка и ремонт", "Дом и сад","Авто и мото","Красота и спорт","Детям и мамам","Работа и офис","Еда".
  
2)открыть секцию каталога "Компьютеры и сети". Убедиться, что появляется вертикальный список пунктов секции и 
присутствуют как минимум пункты "Ноутбуки,компьютеры, мониторы","Комплектующие","Хранение данных", "Сетевое оборудование".

3)Открыть пункт "Комплектующие". Проверить, что в появившемся списке комплектующих все элементы содержат название, 
количество товаров и минимальную цену.

Все тесты должны быть независимы друг от друга.

Если используется Junit5 - использовать assertAll, где это целесообразно. В случае использования других фреймворков 
или Selenide.should - сделать аналог, позволяющий выполнить несколько независимых проверок без мнгновенного 
прекращения на первой.Переписать фреймворк используя Selenide.

Теперь возможность запуска тестов на разных браюзерах обязательна (минимум chrome, firefox).
+Сконфигурировать Selenium Grid и ноду, во фреймворке должна быть возможность запуска
тестов удаленно на Selenium Grid. (RemoteWebDriverCreator)

финальный проект: 
 1) К проекту selenide прикрутить allure report (со скринами на fail и skip) 
 2) Сконфигурировать логи
 3) Засетапить у себя локально дженкинс, запустить тесты на дженкенке. 
 Allure report должен конфигурироваться после рана на дженкенсе

