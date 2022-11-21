package hw_6;

import java.util.*;

public class LaptopSeller {
    static Set<Laptop> available = new HashSet<>();
    static final Map<Integer, String> choices = new HashMap<>();
       choices.put(1, "ram");
        choices.put(2, "storage");
        choices.put(3, "cpu");
        choices.put(4, "os");
        choices.put(5, "manufacturer");
        
    //     {
    //         put(1, "ram");
    //         put(2, "storage");
    //         put(3, "cpu");
    //         put(4, "os");
    //         put(5, "manufacturer");
    //     }
    // };

    public static int getUserChoice(Scanner in) {
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ\n2 - Объем ЖД\n3 - Процессор\n4 - Операционная система\n5 - Производитель");
        String result = in.nextLine();
        return Integer.parseInt(result);
    }

    public static int getLowerBound(Scanner in) {
        System.out.println("Введите минимальный желаемый объем: ");
        String result = in.nextLine();
        return Integer.parseInt(result);
    }

    public static String getName(Scanner in) {
        System.out.println("Введите наименование: ");
        String result = in.nextLine();
        return result.toLowerCase();
    }

    public static Set<Laptop> getByLowerBound(int lowerBound, String item) {
        Set<Laptop> result = new HashSet<>();

        for (Laptop laptop : available) {
            if (item.equals("ram") && laptop.getRam() >= lowerBound) {
                result.add(laptop);
            } else if (item.equals("storage") && laptop.getStorage() >= lowerBound) {
                result.add(laptop);
            }
        }

        return result;
    }

    public static Set<Laptop> getByName(String name, String item) {
        Set<Laptop> result = new HashSet<>();

        for (Laptop laptop : available) {
            if (item.equalsIgnoreCase("cpu") && laptop.getCpuType().toLowerCase().contains(name)) {
                result.add(laptop);
            } else if (item.equalsIgnoreCase("os") && laptop.getOs().toLowerCase().contains(name)) {
                result.add(laptop);
            } else if (item.equalsIgnoreCase("manufacturer")
                    && laptop.getManufacturer().toLowerCase().contains(name)) {
                result.add(laptop);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        available.add(new Laptop("Asus", 22100.0));
        available.add(new Laptop("Lenovo", 24500.00));
        available.add(new Laptop(4, 128, "AMD Athlon Silver", "Integrated",
                "IPS 14", "Windows 11", "Lenovo", 24900));
        available.add(new Laptop(16, 512, "Apple M1 Pro", "Integrated",
                "mini-LED 14,2", "macOS", "Apple", 262000));
        available.add(new Laptop(16, 512, "AMD Ryzen 9", "Radeon RX 6800M",
                "IPS 15,6", "No OS", "Asus Rog Strix", 198000));
        available.add(new Laptop(8, 512, "Intel Core i5", "Integrated Intel Iris Xe",
                "IPS 15,6", "No OS", "Lenovo ThinkPad", 90000));

        int choice = getUserChoice(in);
        int lowerBound = 0;
        String cpu = "";
        String os = "";
        String maker = "";
        Set<Laptop> result;

        switch (choice) {
            case 1:
                lowerBound = getLowerBound(in);
                result = getByLowerBound(lowerBound, "ram");
                break;
            case 2:
                lowerBound = getLowerBound(in);
                result = getByLowerBound(lowerBound, "storage");
                break;
            case 3:
                cpu = getName(in);
                result = getByName(cpu, "cpu");
                break;
            case 4:
                os = getName(in);
                result = getByName(os, "os");
                break;
            case 5:
                maker = getName(in);
                result = getByName(maker, "manufacturer");
                break;
            default:
                System.out.println("Неверный выбор пункта меню");
                result = available;
                break;
        }

        for (Laptop laptop : result) {
            System.out.println(laptop);
        }

        in.close();
    }
}
