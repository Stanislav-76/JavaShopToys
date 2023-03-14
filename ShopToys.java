import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShopToys {
    public List<Toy> toys;
    public Queue<Toy> listPriz;

    public ShopToys(){
        toys = new ArrayList<Toy>();
        listPriz = new LinkedList<Toy>();
    }

    public void addToy(int id, String name, int count, int weight){
        Toy toy = new Toy(id, name, count, weight);
        toys.add(toy);
        saveShopToyFile();
    }
        
    public void addRandomToy(int count){
        for (int i = 1; i < count+1; i++) {
            int countToy = (int)(Math.random()*10 + 1);
            int weight = (int)(Math.random()*100 + 1);
            if (countToy > count){
                countToy = count;
            }
            count -= countToy;
            Toy toyN = new Toy(i, "Toy" + i, countToy, weight);
            toys.add(toyN);
        }
        saveShopToyFile();
    }

    public void listPriz(int n){
        int[] lstCount = new int [toys.size()];
        int j = 0;
        for (Toy toy : toys) {
            lstCount[j++] = toy.getCount();
            for(Toy item : listPriz){
                if(toy == item){
                    toy.setCount(toy.getCount() - 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            Toy priz = getRandomWeight(toys);
            if (priz != null) {
                priz.setCount(priz.getCount() - 1);
                listPriz.add(priz);                
            }
        }
        j = 0;
        for (Toy toy : toys) {
            toy.setCount(lstCount[j++]); ;
        }
    }

    private Toy getRandomWeight(List<Toy> items){
        int totalWeight = 0;
        for (Toy item : items) {
            totalWeight += item.getWeight()*item.getCount();
        }
        while(totalWeight > 0){
            double value = Math.random()*totalWeight + 1, weight = 0;
            for (Toy item : items){
                weight += item.getWeight()*item.getCount();
                if (value < weight && item.getCount() > 0)
                    return item;
            }
        }
        return null;
    }

    public void priz(){
        Toy priz = listPriz.poll();
        if (priz != null){
            priz.setCount(priz.getCount() - 1);
            System.out.println("Ваш приз: " + priz.getName());
            addPrizFile(priz);
            saveShopToyFile();
        } else {
            System.out.println("Призов не осталось");    
        }
    }

    private void addPrizFile(Toy toy){
        try (FileWriter fw = new FileWriter("prizes.txt", true)) {
            fw.write(String.valueOf(toy)+"\n");
            fw.flush();          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveShopToyFile(){
        try (FileWriter fw = new FileWriter("shopToys.txt")) {
            for (Toy item : toys){
                if(item.getCount() > 0){
                    fw.write(String.valueOf(item)+"\n");
                }
            }
            fw.flush();          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadShopToysFile(){        
        try (BufferedReader br = new BufferedReader(new FileReader("shopToys.txt"))){
            String str;
            String[] res;
            while ((str = br.readLine()) != null) {
                res = str.split(",");
                addToy(Integer.parseInt(res[0]), res[1], Integer.parseInt(res[2]), Integer.parseInt(res[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
