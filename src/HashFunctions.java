public class HashFunctions {

    public static int hashFunction(String name) {
        int sum = 0;
        for (int i = 0; i < name.length(); i++) {
            sum += name.charAt(i);
        }
        return sum % 10;
    }

    public static void storeName(String name, String[] hashSet) {
        int index = hashFunction(name);

        if (hashSet[index] == null) {
            hashSet[index] = name;
            System.out.println("Stored " + name + " at index " + index);
        } else {
            System.out.println("Collision detected!");
        }
    }

}
