package ru.sberbank.homework.koval;

import java.util.HashMap;

enum Operation {
    ADDITION {
        public double apply(double a, double b) {
            return a + b;
        }
    },
    SUBTRACTION {
        public double apply(double a, double b) {
            return a - b;
        }
    },
    MULTIPLICATION {
        public double apply(double a, double b) {
            return a * b;
        }
    },
    DIVISION {
        public double apply(double a, double b) {
            return a / b;
        }
    };

    static HashMap<String, Operation> operations = new HashMap<>();

    static {
        operations.put("+", ADDITION);
        operations.put("-", SUBTRACTION);
        operations.put("*", MULTIPLICATION);
        operations.put("/", DIVISION);
    }

    public abstract double apply(double a, double b);

    public static Operation getOperation(String operationName) {
        Operation operation = operations.get(operationName);
        if (operation == null) {
            throw new ExpressionFormatException();
        }
        return operation;
    }
}




