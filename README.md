Переписать фреймворк используя Selenide.
Теперь возможность запуска тестов на разных браюзерах обязательна (минимум chrome, firefox).
+Сконфигурировать Selenium Grid и ноду, во фреймворке должна быть возможность запуска
тестов удаленно на Selenium Grid. (RemoteWebDriverCreator)

Конфигурации для Maven: 
1) clean test -Dsuite=AllTests -DdriverType=chrome -DisRemote=true
(Запускает тесты на chrome удаленно. Если нужно локально, -DisRemote=любое значение)

2) clean test -Dsuite=AllTests -DdriverType=firefox -DisRemote=true
(Запускает тесты на firefox удаленно !SessionNotCreatedException!)
 (Если нужно локально, -DisRemote=любое значение. Получилось только с хардкодом)
 
финальный проект: 
 1) К проекту selenide прикрутить allure report (со скринами на fail и skip) 
 2) Сконфигурировать логи
 3) Засетапить у себя локально дженкинс, запустить тесты на дженкенке. 
 Allure report должен конфигурироваться после рана на дженкенсе

