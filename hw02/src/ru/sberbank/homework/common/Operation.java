package ru.sberbank.homework.common;

import java.util.HashMap;

import ru.sberbank.homework.common.ExpressionFormatException;

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

    static HashMap<String, Operation> op = new HashMap<>();

    static {
        op.put("+", ADDITION);
        op.put("-", SUBTRACTION);
        op.put("*", MULTIPLICATION);
        op.put("/", DIVISION);
    }

    public abstract double apply(double a, double b);

    public static Operation getOperation(String operation) {
        if (op.containsKey(operation)) {
            return op.get(operation);
        }
        throw new ExpressionFormatException();
    }
}




