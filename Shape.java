package exercise;




class Shape {
    public double area() {
        System.out.println("Default area");
        return 0.0;
    }
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        if (radius <= 0) {
            System.out.println("Area = 0");
            return 0.0;
        }
        double result = Math.PI * radius * radius;
        System.out.printf("Area≈ %.1f%n", result);
        return result;
    }
}

class Rectangle extends Shape {
    private double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        if (length <= 0 || width <= 0) {
            System.out.println("Area 0");
            return 0.0;
        }
        double result = length * width;
        System.out.printf("Area= %.0f%n", result);
        return result;
    }
}
