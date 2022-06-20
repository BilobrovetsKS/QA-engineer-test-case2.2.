# Case 2.2 UI-автотесты
Задача:
- написать автоматические тесты покрывающие следующие кейсы:
  - Кейс 1 "Разница двух целых чисел" на сайте https://testsheepnz.github.io/BasicCalculator.html ;
  - Кейс 2 "Конкатенация двух строк" на сайте https://testsheepnz.github.io/BasicCalculator.html ;
  - Кейс 3 "Появление сообщения при вводе строки в поле" на сайте https://testsheepnz.github.io/random-number.html ;

Структура проекта:
- 2 тест класса (прописана логика - такая как запуск браузера, запуск самих тестов);
   - FastTesting - запускает одновременно все тесты (скорость выполнения 2 сек.);
   - SeparateTesting - запускает тесты поочередно, так же можно локально запустить один из тестов (скорость выполнения 9 сек.);
- три промежуточных тест класса (содержат общие методы для группы тестов, ссылки на хранение драйверов).

Как запустить проект:
- загрузить проект из данного репозитория в IntelliJIdea;
- изменить путь хранения драйверов в файле testForBasic/src/test/resources/conf.properties;
- перейти к файлам по пути testForBasic/src/test/java/tests;
- подгрузить все необходимые библиотеки;
- запустить тест.
