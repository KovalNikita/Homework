package ru.sberbank.homework.koval.parsers;

public abstract class NumberParser {
    void assertTrue(boolean actual) {
        if (!actual) {
            throw new NumberFormatException();
        }
    }

    boolean checkUnderlining(String number) {
        int len = number.length();
        return (number.charAt(0) != '_' &&
                number.charAt(len - 1) != '_');
    }

    String deleteUnderlining(String number) {
        return number.replace("_", "");
    }

    public abstract boolean checkType(String number);

    public abstract double parse(String number);
}

class DoubleParser extends NumberParser {
    @Override
    public boolean checkType(String number) {
        return number.contains(".");
    }

    @Override
    public double parse(String number) {
        String[] parts = number.split("\\.");
        if (parts.length != 2) {
            throw new NumberFormatException();
        }

        String intPart = parts[0];
        String fractPart = parts[1];
        if (intPart.isEmpty()) {
            assertTrue(checkUnderlining(intPart));
            intPart = deleteUnderlining(intPart);
        }

        assertTrue(!fractPart.isEmpty());
        assertTrue(checkUnderlining(fractPart));
        fractPart = deleteUnderlining(fractPart);
        return Double.parseDouble(intPart + "." + fractPart);
    }
}

class IntegerParser extends NumberParser {
    private int radix;
    private String prefix;

    IntegerParser(int radix, String prefix) {
        this.radix = radix;
        this.prefix = prefix;
    }

    private String deletePostfix(String number) {
        int len = number.length();
        if (len > 0 && number.charAt(len - 1) == 'l') {
            return number.substring(0, len - 1);
        }
        return number;
    }

    private String deletePrefix(String number) {
        return number.substring(prefix.length());
    }

    @Override
    public boolean checkType(String number) {
        return number.startsWith(prefix);
    }

    @Override
    public double parse(String number) {
        number = deletePostfix(number);
        number = deletePrefix(number);

        assertTrue(!number.isEmpty());
        assertTrue(checkUnderlining(number));

        number = deleteUnderlining(number);
        return Long.parseLong(number, radix);
    }
}

class BinIntegerParser extends IntegerParser {
    BinIntegerParser() {
        super(2, "0b");
    }
}

class OctIntegerParser extends IntegerParser {
    OctIntegerParser() {
        super(8, "0");
    }

    @Override
    boolean checkUnderlining(String number) {
        int len = number.length();
        return number.charAt(len - 1) != '_';
    }
}

class DecIntegerParser extends IntegerParser {
    DecIntegerParser() {
        super(10, "");
    }
}

class HexIntegerParser extends IntegerParser {
    HexIntegerParser() {
        super(16, "0x");
    }
}