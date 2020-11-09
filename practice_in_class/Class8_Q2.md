@startuml
class Circle2D {
    - double x
    - double y
    - double radius

    + Circle2D()
    + double getX()
    + double getY()
    + double getRadius()
    + Circle2D(double x, double y, double radius)
    + double getArea()
    + double getPerimeter()
    + boolean contains(double x, double y)
    + boolean contains(Circle2D circle)
    + boolean overlaps(Circle2D circle)
}
@enduml