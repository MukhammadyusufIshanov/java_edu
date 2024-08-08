package homework;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;

class Laptop {
    String brand;
    int ram; // in GB
    int storage; // in GB
    String operatingSystem;
    String color;

    public Laptop(String brand, int ram, int storage, String operatingSystem, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

class LaptopStore {
    Set<Laptop> laptops = new HashSet<>();

    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
    }

    public void filterLaptops() {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "ram");
        criteria.put(2, "storage");
        criteria.put(3, "operatingSystem");
        criteria.put(4, "color");

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int criterion = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (!criteria.containsKey(criterion)) {
            System.out.println("Неверный критерий");
            return;
        }

        String filterCriterion = criteria.get(criterion);
        System.out.println("Введите минимальное значение для критерия " + filterCriterion + ":");
        String filterValue = scanner.nextLine();

        Set<Laptop> filteredLaptops = new HashSet<>();
        for (Laptop laptop : laptops) {
            boolean matches = false;
            if ("ram".equals(filterCriterion)) {
                matches = laptop.ram >= Integer.parseInt(filterValue);
            } else if ("storage".equals(filterCriterion)) {
                matches = laptop.storage >= Integer.parseInt(filterValue);
            } else if ("operatingSystem".equals(filterCriterion)) {
                matches = laptop.operatingSystem.equalsIgnoreCase(filterValue);
            } else if ("color".equals(filterCriterion)) {
                matches = laptop.color.equalsIgnoreCase(filterValue);
            }

            if (matches) {
                filteredLaptops.add(laptop);
            }
        }

        if (filteredLaptops.isEmpty()) {
            System.out.println("Нет ноутбуков, соответствующих указанным критериям.");
        } else {
            System.out.println("Найденные ноутбуки:");
            for (Laptop laptop : filteredLaptops) {
                System.out.println(laptop);
            }
        }
    }

    public static void main(String[] args) {
        LaptopStore store = new LaptopStore();
        store.addLaptop(new Laptop("Dell", 16, 512, "Windows", "Black"));
        store.addLaptop(new Laptop("Apple", 8, 256, "macOS", "Silver"));
        store.addLaptop(new Laptop("HP", 8, 1024, "Windows", "Blue"));

        store.filterLaptops();
    }
}