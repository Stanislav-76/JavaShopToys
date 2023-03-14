## Информация о проекте
Необходимо написать проект для розыгрыша в магазине игрушек.  
Функционал должен содержать добавление новых игрушек и задания веса для выпадения игрушек.

## Реализация
- Каждая игрушка (class `Toy`) содержит id, name, количество и шанс выпадения(вес).
- Можно добавлять новые игрушки, c сохранением в файл (`shopToys.txt`). Добавлен генератор игрушек.
- С помощью `Queue` формируется очередь заданной длины по принципу случайного выбора с учетом шанса выпадения игрушки.
- При выдаче игрушки (приза) из очереди (если очередь не пуста) умешается количество в базе.
- Выданная игрушка записывается в файл `prizes.txt`