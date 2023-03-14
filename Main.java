public class Main {
    public static void main(String[] args) {

        ShopToys shop = new ShopToys();

        shop.loadShopToysFile();
        // Добавляем игрушки
        shop.addToy(1, "Машинка", 3, 20);
        shop.addToy(2, "Кукла", 4, 40);
        shop.addToy(3, "Робот", 3, 80);
        

        // shop.addRandomToy(100); //Сгенерировали список 100 случайных игрушек

        // for (Toy toy : shop.toys) {  // Просмотр списка игрушек
        //     System.out.println(toy);
        // }

        shop.listPriz(5); // Добавляем в очередь выдачи N игрушек
        shop.listPriz(3); // Добавляем в очередь выдачи ещё N игрушек

        // System.out.println("\nСписок призов:");
        // for (Object object : shop.listPriz){
        //     System.out.println((Toy) object);
        // }

        for (int i = 0; i < 5; i++) { // Получаем приз, уменьшаем количество в списке, запись в файл 
            shop.priz();
        }
    }
}
