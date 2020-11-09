@startuml
class RegularPolygon {
    - int n
    - double side
    - double x
    - double y
	+ RegularPolygon()
    + RegularPolygon(int n, double side)
    + RegularPolygon(int n, double side, double x, double y)
    + int getN()
	+ double getSide()
	+ double getX()
	+ double getY()
	+ void setN(int n)
	+ void setSide(double side)
	+ void setX(double x)
	+ void setY(double y)
	+ double getPerimeter()
	+ double getArea()
	+ void drawPolygon()
}
@enduml