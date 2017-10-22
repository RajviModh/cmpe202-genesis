interface Person {
    Person clone();
}

class Garry implements Person {
    private final String NAME = "Garry";

    @Override
    public Person clone() {
        return new Garry();
    }

    @Override
    public String toString() {
        return NAME;
    }
}

class Sal implements Person {
    private final String NAME = "Sal";

    @Override
    public Person clone() {
        return new Sal();
    }

    @Override
    public String toString() {
        return NAME;
    }
}

class Bill implements Person {
    private final String NAME = "Bill";

    @Override
    public Person clone() {
        return new Bill();
    }

    @Override
    public String toString() {
        return NAME;
    }
}

class Factory {
    private static final Map<String, Person> prototypes = new HashMap<>();

    static {
        prototypes.put("Garry", new Garry());
        prototypes.put("Sal", new Sal());
        prototypes.put("Bill", new Bill());
    }

    public static Person getPrototype(String type) {
        try {
            return prototypes.get(type).clone();
        } catch (NullPointerException ex) {
            System.out.println("Prototype having the name: " + type + ", does not exist!");
            return null;
        }
    }
}

public class PrototypeFactory {
    public static void main(String[] args) {
        if (args.length > 0) {
            for (String type : args) {
                Person prototype = Factory.getPrototype(type);
                if (prototype != null) {
                    System.out.println(prototype);
                }
            }
        } else {
            System.out.println("Execute again with the arguments of command string! ");
        }
    }
}