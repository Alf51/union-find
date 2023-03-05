# Union-find
Программа для нахождения и объединения непересекающихся множеств

а) Программа считывает файл состоящий из строк вида: 

A1;B1;C1
A2;B2;C2
A3;B3
...

б) Находит множество уникальных строчек и разбивает их на непересекающиеся группы по следующему критерию:

Если две строчки имеют совпадения непустых значений в одной или более колонках, они принадлежат одной группе. 
Например, строчки

111;123;222
200;123;100
300;;100

все принадлежат одной группе, так как первые две строчки имеют одинаковое значение 123 во второй колонке, а две последние одинаковое значение 100 в третьей колонке

строки

100;200;300
200;300;100

не должны быть в одной группе, так как значение 200 находится в разных колонках

в) Выводит полученные группы в файл result.txt

Группа 1

строчка1
строчка2
строчка3

...

Группа 2

строчка1
строчка2
строчка3

Сверху расположены группы с наибольшим числом элементов.

Приемлемое время работы - до 30 секунд.

* Строки вида
 "8383"200000741652251"
 "79855053897"83100000580443402";"200000133000191"
 являются некорректными и должны пропускаться
 
**Инструкция по запуску:**	

• необходима версия Java 18;

• unionFind.jar (расположен в корне программы)

• файл со строками (в качестве тестового можно взять из корня программы файл lng.csv)

• Параметры программы задаются при запуске через аргументы командной строки: 
1. java -jar unionFind.jar {название файла}.формат

Для удобства советую поместить unionFind.jar и ваш файл со строками в одну папку

**Пример запуска программы через командную строку Windows:**
java -jar unionFind.jar lng.csv

Время работы алгоритма на 
Ryze 5500U
составляет 3 секунды


