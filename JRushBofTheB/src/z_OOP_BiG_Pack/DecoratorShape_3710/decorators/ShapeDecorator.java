package z_OOP_BiG_Pack.DecoratorShape_3710.decorators;

import z_OOP_BiG_Pack.DecoratorShape_3710.shapes.Shape;

public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
