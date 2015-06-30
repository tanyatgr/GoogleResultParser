# GoogleResultParser
Google Result Parser

Користувач вводить (з терміналу) пошуковий запит. Програма відкриває вікно
Firefox, завантажує сторінку Google, вводить пошуковий запит і натискає “Пошук”. 
Отримаємо список заголовків сторінок в терміналі.

Для запуску виконати

mvn clean
mvn package
java -cp target/CVTest-1.0-SNAPSHOT.jar app.parser.Main $1

$1 - параметр пошуку


